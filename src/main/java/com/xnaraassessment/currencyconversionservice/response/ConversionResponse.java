package com.xnaraassessment.currencyconversionservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversionResponse {
    private String result;
    private String statement;
}
