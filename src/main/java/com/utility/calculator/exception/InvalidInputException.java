package com.utility.calculator.exception;

import com.utility.calculator.constants.ErrorConstants;

public class InvalidInputException extends RuntimeException {

    private final String errorCode;

    public InvalidInputException(String message) {
        super(message);
        this.errorCode = ErrorConstants.INVALID_INPUT;
    }

    public InvalidInputException(String messageTemplate, Object... args) {
        this(String.format(messageTemplate, args));
    }

    public InvalidInputException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
