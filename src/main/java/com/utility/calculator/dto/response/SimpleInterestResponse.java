package com.utility.calculator.dto.response;

import com.utility.calculator.constants.ApiConstants;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = ApiConstants.SCHEMA_SIMPLE_INTEREST_RESPONSE_DESCRIPTION)
public record SimpleInterestResponse(
        BigDecimal interest,
        BigDecimal totalAmount
) {
}
