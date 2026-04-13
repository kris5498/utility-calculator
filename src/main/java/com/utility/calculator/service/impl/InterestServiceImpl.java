package com.utility.calculator.service.impl;

import com.utility.calculator.constants.ApiConstants;
import com.utility.calculator.dto.request.SimpleInterestRequest;
import com.utility.calculator.dto.response.SimpleInterestResponse;
import com.utility.calculator.service.InterestService;
import com.utility.calculator.util.InterestCalculatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Service
public class InterestServiceImpl implements InterestService {

    @Override
    public SimpleInterestResponse calculateSimpleInterest(SimpleInterestRequest request) {
        final long startTimeMs = System.currentTimeMillis();
        final String traceId = UUID.randomUUID().toString();
        MDC.put(ApiConstants.TRACE_ID_KEY, traceId);

        try {
            log.info("traceId={}, Simple interest calculation started", traceId);

            final BigDecimal interest = InterestCalculatorUtil.calculateSimpleInterest(
                    request.principal(),
                    request.rate(),
                    request.time()
            );
            final BigDecimal totalAmount = request.principal().add(interest);

            log.info(
                    "traceId={}, Simple interest calculation completed: durationMs={}",
                    traceId,
                    System.currentTimeMillis() - startTimeMs
            );
            return new SimpleInterestResponse(interest, totalAmount);
        } finally {
            MDC.remove(ApiConstants.TRACE_ID_KEY);
        }
    }
}
