package com.utility.calculator.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalculatorUtil {

    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);
    private static final int SCALE = 2;

    private InterestCalculatorUtil() {
        // Prevent instantiation
    }

    public static BigDecimal calculateSimpleInterest(BigDecimal principal, BigDecimal rate, BigDecimal time) {
        return principal
                .multiply(rate)
                .multiply(time)
                .divide(ONE_HUNDRED, SCALE, RoundingMode.HALF_UP);
    }
}
