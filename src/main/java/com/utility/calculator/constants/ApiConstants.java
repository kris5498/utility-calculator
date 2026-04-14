package com.utility.calculator.constants;

public class ApiConstants {

    private ApiConstants() {}

    public static final String RESPONSE_KEY_TIMESTAMP = "timestamp";
    public static final String RESPONSE_KEY_STATUS = "status";
    public static final String RESPONSE_KEY_ERROR = "error";
    public static final String RESPONSE_KEY_ERROR_CODE = "errorCode";
    public static final String RESPONSE_KEY_MESSAGE = "message";

    public static final String OPERATION_STATUS_SUCCESS = "SUCCESS";
    public static final String OPERATION_STATUS_FAILED = "FAILED";

    public static final String TRACE_ID_KEY = "traceId";
    public static final String CORRELATION_ID_KEY = "correlationId";
    public static final String TRACE_ID_HEADER = "X-Trace-Id";
    public static final String CORRELATION_ID_HEADER = "X-Correlation-Id";
    public static final int REQUEST_ID_MAX_LENGTH = 128;
    public static final String REQUEST_ID_ALLOWED_REGEX = "^[A-Za-z0-9-]+$";

    public static final String BASE_API_PATH = "/api/v1";
    public static final String SIMPLE_INTEREST_PATH = "/interest/simple";

    public static final String CUSTOM_OPEN_AI_TITLE = "Utility Calculator API";
    public static final String CUSTOM_OPEN_AI_DESCRIPTION = "A simple API to calculate simple interest based on principal, rate, and time.";
    public static final String CUSTOM_OPEN_AI_VERSION = "1.0.0";

    public static final String OPEN_AI_TAG_NAME = "Interest Calculation";
    public static final String OPEN_AI_TAG_DESCRIPTION = "Endpoints for calculating different types of interest";

    public static final String OPEN_AI_OPERATION_SUMMARY = "Calculate Simple Interest";
    public static final String OPEN_AI_OPERATION_DESCRIPTION = "Calculates simple interest based on the provided principal, rate, and time.";

    public static final String OPEN_AI_RESPONSE_CODE_OK = "200";
    public static final String OPEN_AI_RESPONSE_CODE_BAD_REQUEST = "400";
    public static final String OPEN_AI_RESPONSE_CODE_INTERNAL_SERVER_ERROR = "500";

    public static final String OPEN_AI_RESPONSE_DESCRIPTION_OK = "Successful calculation";
    public static final String OPEN_AI_RESPONSE_DESCRIPTION_BAD_REQUEST = "Invalid input";
    public static final String OPEN_AI_RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR = "Internal server error";

    public static final String SCHEMA_SIMPLE_INTEREST_REQUEST_DESCRIPTION = "Request object for simple interest calculation";
    public static final String SCHEMA_SIMPLE_INTEREST_PRINCIPAL_DESCRIPTION = "Principal amount";
    public static final String SCHEMA_SIMPLE_INTEREST_RATE_DESCRIPTION = "Rate of interest";
    public static final String SCHEMA_SIMPLE_INTEREST_TIME_DESCRIPTION = "Time in years";
    public static final String SCHEMA_SIMPLE_INTEREST_PRINCIPAL_EXAMPLE = "10000";
    public static final String SCHEMA_SIMPLE_INTEREST_RATE_EXAMPLE = "5";
    public static final String SCHEMA_SIMPLE_INTEREST_TIME_EXAMPLE = "2";

    public static final String SCHEMA_SIMPLE_INTEREST_RESPONSE_DESCRIPTION = "Response object containing interest calculation result";

    public static final String LOG_MSG_SIMPLE_INTEREST_STARTED = "traceId={}, correlationId={}, Simple interest calculation started";
    public static final String LOG_MSG_SIMPLE_INTEREST_COMPLETED = "traceId={}, correlationId={}, Simple interest calculation completed: durationMs={}";
    public static final String LOG_MSG_ERROR_CODE_MESSAGE = "traceId={}, correlationId={}, code={}, message={}";
    public static final String LOG_MSG_REQUEST_VALIDATION_FAILED = "traceId={}, correlationId={}, Request validation failed: {}";
    public static final String LOG_MSG_CONSTRAINT_VALIDATION_FAILED = "traceId={}, correlationId={}, Constraint validation failed: {}";
    public static final String LOG_MSG_METHOD_NOT_ALLOWED = "traceId={}, correlationId={}, Method not allowed: {}";
    public static final String LOG_MSG_API_NOT_FOUND = "traceId={}, correlationId={}, API not found: {}";
    public static final String LOG_MSG_UNHANDLED_EXCEPTION = "traceId={}, correlationId={}, Unhandled exception";
    public static final String LOG_MSG_REQUEST_CONTEXT_INITIALIZED = "traceId={}, correlationId={}, method={}, path={}";

    public static final String LIST_DELIMITER_COMMA_SPACE = ", ";
    public static final String FIELD_MESSAGE_SEPARATOR = ": ";
    public static final String EMPTY_SUPPORTED_METHODS = "[]";
    public static final String MESSAGE_SEPARATOR_DOT_SPACE = ". ";
}
