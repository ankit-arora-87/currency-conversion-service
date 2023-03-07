package com.xnaraassessment.currencyconversionservice.service;

import com.xnaraassessment.currencyconversionservice.request.ConversionRequest;
import com.xnaraassessment.currencyconversionservice.response.ConversionResponse;
import com.xnaraassessment.currencyconversionservice.utils.MapperUtility;
import org.springframework.stereotype.Service;

@Service
public interface ConversionService {

    public ConversionResponse convert(ConversionRequest conversionRequest);

    default public ConversionResponse requestToEntityConvertor(ConversionRequest conversionRequest, ConversionResponse conversionResponse){
        return MapperUtility.convertRequestToEntity(conversionRequest, conversionResponse);
    }
}
