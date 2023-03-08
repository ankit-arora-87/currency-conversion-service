package com.xnaraassessment.currencyconversionservice.controller;

import com.xnaraassessment.currencyconversionservice.request.ConversionRequest;
import com.xnaraassessment.currencyconversionservice.response.ConversionResponse;
import com.xnaraassessment.currencyconversionservice.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/currencyConversion/")
public class CurrencyConversionController {

    @Autowired
    private ConversionService conversionService;


    @PostMapping(name = "convert")
    public ConversionResponse convert(@RequestBody ConversionRequest conversionRequest){

        return conversionService.convert(conversionRequest);
    }
}
