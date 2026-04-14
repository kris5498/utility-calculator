package com.utility.calculator.filter;

import com.utility.calculator.constants.ApiConstants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class TraceCorrelationFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TraceCorrelationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Local trace id per service request for application-level observability.
        String traceId = UUID.randomUUID().toString();
        // Correlation id is propagated across services when provided by upstream callers.
        String correlationId = resolveIncomingCorrelationId(request.getHeader(ApiConstants.CORRELATION_ID_HEADER));

        MDC.put(ApiConstants.TRACE_ID_KEY, traceId);
        MDC.put(ApiConstants.CORRELATION_ID_KEY, correlationId);

        response.setHeader(ApiConstants.TRACE_ID_HEADER, traceId);
        response.setHeader(ApiConstants.CORRELATION_ID_HEADER, correlationId);

        LOGGER.debug(
                ApiConstants.LOG_MSG_REQUEST_CONTEXT_INITIALIZED,
                traceId,
                correlationId,
                request.getMethod(),
                request.getRequestURI()
        );

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(ApiConstants.TRACE_ID_KEY);
            MDC.remove(ApiConstants.CORRELATION_ID_KEY);
        }
    }

    private String resolveIncomingCorrelationId(String value) {
        if (value == null) {
            return UUID.randomUUID().toString();
        }

        String trimmedValue = value.trim();
        if (trimmedValue.isEmpty()
                || trimmedValue.length() > ApiConstants.REQUEST_ID_MAX_LENGTH
                || !trimmedValue.matches(ApiConstants.REQUEST_ID_ALLOWED_REGEX)) {
            return UUID.randomUUID().toString();
        }

        return trimmedValue;
    }
}
