package com.utility.calculator.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record SimpleInterestRequest(
        @NotNull
        @Positive
        BigDecimal principal,

        @NotNull
        @Positive
        BigDecimal rate,

        @NotNull
        @Positive
        BigDecimal time
) {
}
