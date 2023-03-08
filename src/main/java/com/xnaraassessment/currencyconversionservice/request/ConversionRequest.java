package com.xnaraassessment.currencyconversionservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversionRequest {

    @NotBlank(message = "Please provide curr_code")
    private String curr_code;
    @NotNull(message = "Please provide amount")
    @Positive(message = "Invalid amount. Amount must be greater than 0.0")
    private Double amount;
    @NotBlank(message = "Please provide language")
    private String language;
    @NotBlank(message = "Please provide target_code")
    private String target_code;
}
