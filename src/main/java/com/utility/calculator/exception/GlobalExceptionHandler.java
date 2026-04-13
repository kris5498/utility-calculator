package com.utility.calculator.exception;

import com.utility.calculator.constants.ApiConstants;
import com.utility.calculator.constants.ErrorConstants;
import com.utility.calculator.dto.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException ex, HttpServletRequest request) {
        String traceId = getOrCreateTraceId();
        LOGGER.warn("traceId={}, code={}, message={}", traceId, ex.getErrorCode(), ex.getMessage());
        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getErrorCode(),
                List.of(ex.getMessage()),
                request.getRequestURI(),
                request.getMethod(),
                traceId
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String traceId = getOrCreateTraceId();
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());
        LOGGER.warn("traceId={}, Request validation failed: {}", traceId, String.join(", ", errors));
        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                ErrorConstants.INVALID_INPUT,
                errors,
                request.getRequestURI(),
                request.getMethod(),
                traceId
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {
        String traceId = getOrCreateTraceId();
        List<String> errors = ex.getConstraintViolations()
                .stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.toList());
        LOGGER.warn("traceId={}, Constraint validation failed: {}", traceId, String.join(", ", errors));
        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                ErrorConstants.INVALID_INPUT,
                errors,
                request.getRequestURI(),
                request.getMethod(),
                traceId
        );
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        String traceId = getOrCreateTraceId();
        String allowedMethods = ex.getSupportedMethods() == null
                ? "[]"
                : Arrays.toString(ex.getSupportedMethods());
        String methodNotAllowedMessage = ErrorConstants.METHOD_NOT_ALLOWED_MESSAGE + ". "
                + String.format(ErrorConstants.ALLOWED_METHODS_MESSAGE, allowedMethods);
        LOGGER.warn("traceId={}, Method not allowed: {}", traceId, ex.getMessage());
        return buildErrorResponse(
                HttpStatus.METHOD_NOT_ALLOWED,
                ErrorConstants.METHOD_NOT_ALLOWED,
                List.of(methodNotAllowedMessage),
                request.getRequestURI(),
                request.getMethod(),
                traceId
        );
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NoHandlerFoundException ex) {
        String traceId = getOrCreateTraceId();
        LOGGER.warn("traceId={}, API not found: {}", traceId, ex.getRequestURL());
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                ErrorConstants.RESOURCE_NOT_FOUND,
                List.of(ErrorConstants.RESOURCE_NOT_FOUND_MESSAGE),
                ex.getRequestURL(),
                ex.getHttpMethod(),
                traceId
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request) {
        String traceId = getOrCreateTraceId();
        LOGGER.error("traceId={}, Unhandled exception", traceId, ex);
        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ErrorConstants.INTERNAL_ERROR,
                List.of(ErrorConstants.INTERNAL_SERVER_ERROR),
                request.getRequestURI(),
                request.getMethod(),
                traceId
        );
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(
            HttpStatus status,
            String errorCode,
            List<String> errors,
            String path,
            String method,
            String traceId
    ) {
        ErrorResponse body = new ErrorResponse(
                OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                status.value(),
                status.getReasonPhrase(),
                errorCode,
                traceId,
                path,
                method,
                errors
        );
        return ResponseEntity.status(status).body(body);
    }

    private String getOrCreateTraceId() {
        String traceId = MDC.get(ApiConstants.TRACE_ID_KEY);
        if (traceId == null || traceId.isBlank()) {
            traceId = UUID.randomUUID().toString();
        }
        return traceId;
    }
}
