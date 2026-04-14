package com.utility.calculator.dto.response;

import java.util.List;

public record ErrorResponse(
        String timestamp,
        int status,
        String error,
        String errorCode,
        String traceId,
        String correlationId,
        String path,
        String method,
        List<String> errors
) {
}
