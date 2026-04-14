package com.utility.calculator.service.impl;

import com.utility.calculator.constants.ApiConstants;
import com.utility.calculator.dto.request.SimpleInterestRequest;
import com.utility.calculator.dto.response.SimpleInterestResponse;
import com.utility.calculator.service.InterestService;
import com.utility.calculator.util.InterestCalculatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

@Service
public class InterestServiceImpl implements InterestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InterestServiceImpl.class);

    @Override
    public SimpleInterestResponse calculateSimpleInterest(SimpleInterestRequest request) {
        final long startTimeMs = System.currentTimeMillis();
        final String traceId = getOrCreateMdcValue(ApiConstants.TRACE_ID_KEY);
        final String correlationId = getOrCreateMdcValue(ApiConstants.CORRELATION_ID_KEY);

        LOGGER.info(ApiConstants.LOG_MSG_SIMPLE_INTEREST_STARTED, traceId, correlationId);

        final BigDecimal interest = InterestCalculatorUtil.calculateSimpleInterest(
                request.principal(),
                request.rate(),
                request.time()
        );
        final BigDecimal totalAmount = request.principal().add(interest);

        LOGGER.info(
                ApiConstants.LOG_MSG_SIMPLE_INTEREST_COMPLETED,
                traceId,
                correlationId,
                System.currentTimeMillis() - startTimeMs
        );
        return new SimpleInterestResponse(interest, totalAmount);
    }

    @Override
    public BigDecimal convertTimeToYears(
            String timeInputMode,
            String timeDaysOnly,
            String timeMonthsOnly,
            String timeYearsOnly,
            String timeDmyDays,
            String timeDmyMonths,
            String timeDmyYears
    ) {
        if (ApiConstants.TIME_INPUT_MODE_DAYS_ONLY.equals(timeInputMode)) {
            BigDecimal days = parsePositive(timeDaysOnly);
            return days.divide(BigDecimal.valueOf(ApiConstants.DAYS_IN_YEAR), ApiConstants.TIME_CONVERSION_SCALE, RoundingMode.HALF_UP);
        }

        if (ApiConstants.TIME_INPUT_MODE_MONTHS_ONLY.equals(timeInputMode)) {
            BigDecimal months = parsePositive(timeMonthsOnly);
            return months.divide(BigDecimal.valueOf(ApiConstants.MONTHS_IN_YEAR), ApiConstants.TIME_CONVERSION_SCALE, RoundingMode.HALF_UP);
        }

        if (ApiConstants.TIME_INPUT_MODE_YEARS_ONLY.equals(timeInputMode)) {
            return parsePositive(timeYearsOnly);
        }

        if (ApiConstants.TIME_INPUT_MODE_DAYS_MONTHS_YEARS.equals(timeInputMode)) {
            int days = parseNonNegativeInt(timeDmyDays);
            int months = parseNonNegativeInt(timeDmyMonths);
            BigDecimal years = parseNonNegative(timeDmyYears);

            if (days > ApiConstants.MAX_DAYS_IN_MONTH_INPUT || months > ApiConstants.MAX_MONTHS_IN_YEAR_INPUT) {
                throw new IllegalArgumentException(ApiConstants.UI_ERROR_INVALID_TIME_COMBINATION);
            }

            BigDecimal totalYears = years
                    .add(BigDecimal.valueOf(months)
                            .divide(BigDecimal.valueOf(ApiConstants.MONTHS_IN_YEAR), ApiConstants.TIME_CONVERSION_SCALE, RoundingMode.HALF_UP))
                    .add(BigDecimal.valueOf(days)
                            .divide(BigDecimal.valueOf(ApiConstants.DAYS_IN_YEAR), ApiConstants.TIME_CONVERSION_SCALE, RoundingMode.HALF_UP));

            if (totalYears.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException(ApiConstants.UI_ERROR_INVALID_TIME_COMBINATION);
            }
            return totalYears;
        }

        throw new IllegalArgumentException(ApiConstants.UI_ERROR_INVALID_TIME_MODE);
    }

    private BigDecimal parsePositive(String value) {
        BigDecimal parsedValue = new BigDecimal(value);
        if (parsedValue.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(ApiConstants.UI_ERROR_INVALID_TIME_COMBINATION);
        }
        return parsedValue;
    }

    private BigDecimal parseNonNegative(String value) {
        BigDecimal parsedValue = new BigDecimal(value);
        if (parsedValue.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(ApiConstants.UI_ERROR_INVALID_TIME_COMBINATION);
        }
        return parsedValue;
    }

    private int parseNonNegativeInt(String value) {
        int parsedValue = Integer.parseInt(value);
        if (parsedValue < 0) {
            throw new IllegalArgumentException(ApiConstants.UI_ERROR_INVALID_TIME_COMBINATION);
        }
        return parsedValue;
    }

    private String getOrCreateMdcValue(String key) {
        String value = MDC.get(key);
        if (value == null || value.isBlank()) {
            return UUID.randomUUID().toString();
        }
        return value;
    }
}
