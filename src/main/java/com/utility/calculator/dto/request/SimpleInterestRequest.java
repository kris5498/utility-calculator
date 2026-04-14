package com.utility.calculator.dto.request;

import com.utility.calculator.constants.ApiConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Schema(description = ApiConstants.SCHEMA_SIMPLE_INTEREST_REQUEST_DESCRIPTION)
public record SimpleInterestRequest(
        @Schema(description = ApiConstants.SCHEMA_SIMPLE_INTEREST_PRINCIPAL_DESCRIPTION, example = ApiConstants.SCHEMA_SIMPLE_INTEREST_PRINCIPAL_EXAMPLE)
        @NotNull
        @Positive
        BigDecimal principal,

        @Schema(description = ApiConstants.SCHEMA_SIMPLE_INTEREST_RATE_DESCRIPTION, example = ApiConstants.SCHEMA_SIMPLE_INTEREST_RATE_EXAMPLE)
        @NotNull
        @Positive
        BigDecimal rate,

        @Schema(description = ApiConstants.SCHEMA_SIMPLE_INTEREST_TIME_DESCRIPTION, example = ApiConstants.SCHEMA_SIMPLE_INTEREST_TIME_EXAMPLE)
        @NotNull
        @Positive
        BigDecimal time
) {
}
