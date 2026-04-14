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

    private String getOrCreateMdcValue(String key) {
        String value = MDC.get(key);
        if (value == null || value.isBlank()) {
            return UUID.randomUUID().toString();
        }
        return value;
    }
}
