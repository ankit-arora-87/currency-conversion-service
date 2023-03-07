package com.xnaraassessment.currencyconversionservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversionRequest {

    @NonNull
    private String curr_code;
    @NotNull
    private Double amount;
    @NotBlank
    private String language;
    @NotEmpty
    private String target_code;
}
