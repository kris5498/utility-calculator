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

    public static final String UI_INDEX_PATH = "/";
    public static final String UI_SIMPLE_INTEREST_PATH = "/simple-interest";
    public static final String UI_STYLESHEET_PATH = "/css/app.css";
    public static final String UI_SIMPLE_SCRIPT_PATH = "/js/simple-interest.js";
    public static final String VIEW_INDEX = "index";
    public static final String VIEW_SIMPLE = "simple";

    public static final String REQUEST_PARAM_PRINCIPAL = "principal";
    public static final String REQUEST_PARAM_RATE = "rate";
    public static final String REQUEST_PARAM_TIME = "time";

    public static final String REQUEST_PARAM_TIME_INPUT_MODE = "timeInputMode";
    public static final String REQUEST_PARAM_TIME_DAYS_ONLY = "timeDaysOnly";
    public static final String REQUEST_PARAM_TIME_MONTHS_ONLY = "timeMonthsOnly";
    public static final String REQUEST_PARAM_TIME_YEARS_ONLY = "timeYearsOnly";
    public static final String REQUEST_PARAM_TIME_DMY_DAYS = "timeDmyDays";
    public static final String REQUEST_PARAM_TIME_DMY_MONTHS = "timeDmyMonths";
    public static final String REQUEST_PARAM_TIME_DMY_YEARS = "timeDmyYears";

    public static final String TIME_INPUT_MODE_DAYS_ONLY = "DAYS_ONLY";
    public static final String TIME_INPUT_MODE_DAYS_MONTHS_YEARS = "DAYS_MONTHS_YEARS";
    public static final String TIME_INPUT_MODE_MONTHS_ONLY = "MONTHS_ONLY";
    public static final String TIME_INPUT_MODE_YEARS_ONLY = "YEARS_ONLY";

    public static final int MAX_DAYS_IN_MONTH_INPUT = 31;
    public static final int MAX_MONTHS_IN_YEAR_INPUT = 12;
    public static final int MONTHS_IN_YEAR = 12;
    public static final int DAYS_IN_YEAR = 365;
    public static final int TIME_CONVERSION_SCALE = 10;

    public static final String MODEL_ATTR_RESULT = "result";
    public static final String MODEL_ATTR_ERROR = "error";
    public static final String MODEL_ATTR_SELECTED_TIME_INPUT_MODE = "selectedTimeInputMode";
    public static final String MODEL_ATTR_INPUT_PRINCIPAL = "inputPrincipal";
    public static final String MODEL_ATTR_INPUT_RATE = "inputRate";
    public static final String MODEL_ATTR_INPUT_TIME_DAYS_ONLY = "inputTimeDaysOnly";
    public static final String MODEL_ATTR_INPUT_TIME_MONTHS_ONLY = "inputTimeMonthsOnly";
    public static final String MODEL_ATTR_INPUT_TIME_YEARS_ONLY = "inputTimeYearsOnly";
    public static final String MODEL_ATTR_INPUT_TIME_DMY_DAYS = "inputTimeDmyDays";
    public static final String MODEL_ATTR_INPUT_TIME_DMY_MONTHS = "inputTimeDmyMonths";
    public static final String MODEL_ATTR_INPUT_TIME_DMY_YEARS = "inputTimeDmyYears";

    public static final String MODEL_ATTR_UI_TITLE = "uiTitle";
    public static final String MODEL_ATTR_UI_HOME_HEADING = "uiHomeHeading";
    public static final String MODEL_ATTR_UI_HOME_SUBTITLE = "uiHomeSubtitle";
    public static final String MODEL_ATTR_UI_NAV_SIMPLE_INTEREST = "uiNavSimpleInterest";
    public static final String MODEL_ATTR_UI_SIMPLE_HEADING = "uiSimpleHeading";
    public static final String MODEL_ATTR_UI_LABEL_PRINCIPAL = "uiLabelPrincipal";
    public static final String MODEL_ATTR_UI_LABEL_RATE = "uiLabelRate";
    public static final String MODEL_ATTR_UI_LABEL_TIME = "uiLabelTime";
    public static final String MODEL_ATTR_UI_LABEL_TIME_INPUT_MODE = "uiLabelTimeInputMode";
    public static final String MODEL_ATTR_UI_TIME_OPTION_DAYS_ONLY = "uiTimeOptionDaysOnly";
    public static final String MODEL_ATTR_UI_TIME_OPTION_DMY = "uiTimeOptionDmy";
    public static final String MODEL_ATTR_UI_TIME_OPTION_MONTHS_ONLY = "uiTimeOptionMonthsOnly";
    public static final String MODEL_ATTR_UI_TIME_OPTION_YEARS_ONLY = "uiTimeOptionYearsOnly";
    public static final String MODEL_ATTR_UI_LABEL_DAYS_ONLY = "uiLabelDaysOnly";
    public static final String MODEL_ATTR_UI_LABEL_MONTHS_ONLY = "uiLabelMonthsOnly";
    public static final String MODEL_ATTR_UI_LABEL_YEARS_ONLY = "uiLabelYearsOnly";
    public static final String MODEL_ATTR_UI_LABEL_DMY_DAYS = "uiLabelDmyDays";
    public static final String MODEL_ATTR_UI_LABEL_DMY_MONTHS = "uiLabelDmyMonths";
    public static final String MODEL_ATTR_UI_LABEL_DMY_YEARS = "uiLabelDmyYears";
    public static final String MODEL_ATTR_UI_TIME_FORMAT_NOTE = "uiTimeFormatNote";
    public static final String MODEL_ATTR_UI_TIME_NOTE_DAYS_ONLY = "uiTimeNoteDaysOnly";
    public static final String MODEL_ATTR_UI_TIME_NOTE_DMY = "uiTimeNoteDmy";
    public static final String MODEL_ATTR_UI_TIME_NOTE_MONTHS_ONLY = "uiTimeNoteMonthsOnly";
    public static final String MODEL_ATTR_UI_TIME_NOTE_YEARS_ONLY = "uiTimeNoteYearsOnly";
    public static final String MODEL_ATTR_UI_BUTTON_RESET = "uiButtonReset";
    public static final String MODEL_ATTR_UI_BUTTON_CALCULATE = "uiButtonCalculate";
    public static final String MODEL_ATTR_UI_LINK_HOME = "uiLinkHome";
    public static final String MODEL_ATTR_UI_RESULT_HEADING = "uiResultHeading";
    public static final String MODEL_ATTR_UI_RESULT_INTEREST = "uiResultInterest";
    public static final String MODEL_ATTR_UI_RESULT_TOTAL_AMOUNT = "uiResultTotalAmount";
    public static final String MODEL_ATTR_UI_STYLESHEET_PATH = "uiStylesheetPath";
    public static final String MODEL_ATTR_UI_SIMPLE_SCRIPT_PATH = "uiSimpleScriptPath";
    public static final String MODEL_ATTR_UI_INDEX_PATH = "uiIndexPath";
    public static final String MODEL_ATTR_UI_SIMPLE_INTEREST_PATH = "uiSimpleInterestPath";
    public static final String MODEL_ATTR_REQUEST_PARAM_PRINCIPAL = "requestParamPrincipal";
    public static final String MODEL_ATTR_REQUEST_PARAM_RATE = "requestParamRate";
    public static final String MODEL_ATTR_REQUEST_PARAM_TIME = "requestParamTime";
    public static final String MODEL_ATTR_REQUEST_PARAM_TIME_INPUT_MODE = "requestParamTimeInputMode";
    public static final String MODEL_ATTR_REQUEST_PARAM_TIME_DAYS_ONLY = "requestParamTimeDaysOnly";
    public static final String MODEL_ATTR_REQUEST_PARAM_TIME_MONTHS_ONLY = "requestParamTimeMonthsOnly";
    public static final String MODEL_ATTR_REQUEST_PARAM_TIME_YEARS_ONLY = "requestParamTimeYearsOnly";
    public static final String MODEL_ATTR_REQUEST_PARAM_TIME_DMY_DAYS = "requestParamTimeDmyDays";
    public static final String MODEL_ATTR_REQUEST_PARAM_TIME_DMY_MONTHS = "requestParamTimeDmyMonths";
    public static final String MODEL_ATTR_REQUEST_PARAM_TIME_DMY_YEARS = "requestParamTimeDmyYears";
    public static final String MODEL_ATTR_TIME_INPUT_MODE_DAYS_ONLY = "timeInputModeDaysOnly";
    public static final String MODEL_ATTR_TIME_INPUT_MODE_DAYS_MONTHS_YEARS = "timeInputModeDaysMonthsYears";
    public static final String MODEL_ATTR_TIME_INPUT_MODE_MONTHS_ONLY = "timeInputModeMonthsOnly";
    public static final String MODEL_ATTR_TIME_INPUT_MODE_YEARS_ONLY = "timeInputModeYearsOnly";

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

    public static final String UI_TITLE = "Utility Calculator";
    public static final String UI_HOME_HEADING = "Utility Calculator";
    public static final String UI_HOME_SUBTITLE = "Use the simple interest tool to calculate interest and total amount.";
    public static final String UI_NAV_SIMPLE_INTEREST = "Open Simple Interest Calculator";
    public static final String UI_SIMPLE_HEADING = "Simple Interest Calculator";
    public static final String UI_LABEL_PRINCIPAL = "Principal";
    public static final String UI_LABEL_RATE = "Rate (%)";
    public static final String UI_LABEL_TIME = "Time";
    public static final String UI_LABEL_TIME_INPUT_MODE = "Time Input Format";
    public static final String UI_TIME_OPTION_DAYS_ONLY = "Only days";
    public static final String UI_TIME_OPTION_DMY = "Days + Months + Years";
    public static final String UI_TIME_OPTION_MONTHS_ONLY = "Only months";
    public static final String UI_TIME_OPTION_YEARS_ONLY = "Only years";
    public static final String UI_LABEL_DAYS_ONLY = "Days";
    public static final String UI_LABEL_MONTHS_ONLY = "Months";
    public static final String UI_LABEL_YEARS_ONLY = "Years";
    public static final String UI_LABEL_DMY_DAYS = "Days (max 31)";
    public static final String UI_LABEL_DMY_MONTHS = "Months (max 12)";
    public static final String UI_LABEL_DMY_YEARS = "Years";
    public static final String UI_TIME_FORMAT_NOTE = "For Days + Months + Years, enter up to 31 days and up to 12 months.";
    public static final String UI_TIME_NOTE_DAYS_ONLY = "Enter the number of days.";
    public static final String UI_TIME_NOTE_DMY = "For Days + Months + Years, enter up to 31 days and up to 12 months.";
    public static final String UI_TIME_NOTE_MONTHS_ONLY = "Enter the number of months.";
    public static final String UI_TIME_NOTE_YEARS_ONLY = "Enter the number of years.";
    public static final String UI_BUTTON_RESET = "Reset";
    public static final String UI_BUTTON_CALCULATE = "Calculate";
    public static final String UI_LINK_HOME = "Back to Home";
    public static final String UI_RESULT_HEADING = "Calculation Result";
    public static final String UI_RESULT_INTEREST = "Interest";
    public static final String UI_RESULT_TOTAL_AMOUNT = "Total Amount";
    public static final String UI_ERROR_INVALID_NUMBER = "Invalid numeric input. Please enter valid numbers.";
    public static final String UI_ERROR_INVALID_TIME_MODE = "Invalid time input mode selected.";
    public static final String UI_ERROR_INVALID_TIME_COMBINATION = "Invalid time input. Ensure values are valid and greater than zero.";
}
