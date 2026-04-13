package com.utility.calculator.dto.response;

import java.math.BigDecimal;

public record SimpleInterestResponse(
        BigDecimal interest,
        BigDecimal totalAmount
) {
}
