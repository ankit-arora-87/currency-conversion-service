package com.xnaraassessment.currencyconversionservice.service;

import com.xnaraassessment.currencyconversionservice.entities.CurrencyProps;
import com.xnaraassessment.currencyconversionservice.entities.CurrencyRate;
import com.xnaraassessment.currencyconversionservice.repository.CurrencyPropsRepository;
import com.xnaraassessment.currencyconversionservice.repository.CurrencyRateRepository;
import com.xnaraassessment.currencyconversionservice.request.ConversionRequest;
import com.xnaraassessment.currencyconversionservice.response.ConversionResponse;
import com.xnaraassessment.currencyconversionservice.specification.CurrencyConversionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Autowired
    CurrencyRateRepository currencyRateRepository;

    @Autowired
    CurrencyPropsRepository currencyPropsRepository;

    @Override
    public ConversionResponse convert(ConversionRequest conversionRequest) {

        // Get Currency Symbol from Currency Props
        Optional<CurrencyProps> currencyProps = currencyPropsRepository.findByCurrencyCode(conversionRequest.getTarget_code());

        Double output = 0.0;
        ConversionResponse conversionResponse = new ConversionResponse();
        Specification<CurrencyRate> currencyWithBaseSpec = CurrencyConversionSpecification.currencyWithBase(conversionRequest.getCurr_code(), 1);
        Specification whereSpec  = Specification.where(currencyWithBaseSpec);
        if(currencyRateRepository.exists(whereSpec)){
            Optional<CurrencyRate> currencyRateForTargetCode = currencyRateRepository.findByCurrencyCode(conversionRequest.getTarget_code());
            if(currencyRateForTargetCode.isPresent()){
                output = conversionRequest.getAmount()*currencyRateForTargetCode.get().getRateModifier();
            }
        } else {
            Optional<CurrencyRate> currencyRateForCurrentCode = currencyRateRepository.findByCurrencyCode(conversionRequest.getCurr_code());
            Optional<CurrencyRate> currencyRateForTargetCode = currencyRateRepository.findByCurrencyCode(conversionRequest.getTarget_code());
            if(currencyRateForCurrentCode.isPresent() && currencyRateForTargetCode.isPresent()) {
                output = conversionRequest.getAmount()*(currencyRateForTargetCode.get().getRateModifier()/currencyRateForCurrentCode.get().getRateModifier());
            }
        }
        conversionResponse.setResult(currencyProps.get().getSymbol() + " " + output);
        Locale locale = new Locale(conversionRequest.getLanguage(), conversionRequest.getLanguage());

        ResourceBundle statement
                = ResourceBundle.getBundle("statement", locale);

        String statementText = statement.getString("statement");
        conversionResponse.setStatement(statementText.replace("{{curr_value}}", output.toString()));
        return conversionResponse;
    }
}
