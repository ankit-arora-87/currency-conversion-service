package com.xnaraassessment.currencyconversionservice.controller;

import com.xnaraassessment.currencyconversionservice.request.ConversionRequest;
import com.xnaraassessment.currencyconversionservice.response.ConversionResponse;
import com.xnaraassessment.currencyconversionservice.service.ConversionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/currencyConversion/")
public class CurrencyConversionController {

    @Autowired
    private ConversionService conversionService;


    @Operation(summary = "Convert Currency", description = "Convert Currency from source currency code to target currency code", tags = { "currency-conversion" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful conversion", content = @Content(schema = @Schema(implementation = ConversionResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)

    })
    @PostMapping(value = "convert", consumes = { "application/json" }, produces = { "application/json" }, name = "convert")
    public ConversionResponse convert(@Valid @RequestBody ConversionRequest conversionRequest){

        return conversionService.convert(conversionRequest);
    }
}
