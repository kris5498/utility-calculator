package com.utility.calculator.controller;

import com.utility.calculator.constants.ApiConstants;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

@ControllerAdvice(assignableTypes = InterestViewController.class)
public class ViewModelAttributesAdvice {

    @ModelAttribute("ui")
    public Map<String, String> uiAttributes() {
        return Map.ofEntries(
                Map.entry(ApiConstants.MODEL_ATTR_UI_TITLE, ApiConstants.UI_TITLE),
                Map.entry(ApiConstants.MODEL_ATTR_UI_HOME_HEADING, ApiConstants.UI_HOME_HEADING),
                Map.entry(ApiConstants.MODEL_ATTR_UI_HOME_SUBTITLE, ApiConstants.UI_HOME_SUBTITLE),
                Map.entry(ApiConstants.MODEL_ATTR_UI_NAV_SIMPLE_INTEREST, ApiConstants.UI_NAV_SIMPLE_INTEREST),
                Map.entry(ApiConstants.MODEL_ATTR_UI_SIMPLE_HEADING, ApiConstants.UI_SIMPLE_HEADING),
                Map.entry(ApiConstants.MODEL_ATTR_UI_LABEL_PRINCIPAL, ApiConstants.UI_LABEL_PRINCIPAL),
                Map.entry(ApiConstants.MODEL_ATTR_UI_LABEL_RATE, ApiConstants.UI_LABEL_RATE),
                Map.entry(ApiConstants.MODEL_ATTR_UI_LABEL_TIME, ApiConstants.UI_LABEL_TIME),
                Map.entry(ApiConstants.MODEL_ATTR_UI_LABEL_TIME_INPUT_MODE, ApiConstants.UI_LABEL_TIME_INPUT_MODE),
                Map.entry(ApiConstants.MODEL_ATTR_UI_TIME_OPTION_DAYS_ONLY, ApiConstants.UI_TIME_OPTION_DAYS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_UI_TIME_OPTION_DMY, ApiConstants.UI_TIME_OPTION_DMY),
                Map.entry(ApiConstants.MODEL_ATTR_UI_TIME_OPTION_MONTHS_ONLY, ApiConstants.UI_TIME_OPTION_MONTHS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_UI_TIME_OPTION_YEARS_ONLY, ApiConstants.UI_TIME_OPTION_YEARS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_UI_LABEL_DAYS_ONLY, ApiConstants.UI_LABEL_DAYS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_UI_LABEL_MONTHS_ONLY, ApiConstants.UI_LABEL_MONTHS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_UI_LABEL_YEARS_ONLY, ApiConstants.UI_LABEL_YEARS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_UI_LABEL_DMY_DAYS, ApiConstants.UI_LABEL_DMY_DAYS),
                Map.entry(ApiConstants.MODEL_ATTR_UI_LABEL_DMY_MONTHS, ApiConstants.UI_LABEL_DMY_MONTHS),
                Map.entry(ApiConstants.MODEL_ATTR_UI_LABEL_DMY_YEARS, ApiConstants.UI_LABEL_DMY_YEARS),
                Map.entry(ApiConstants.MODEL_ATTR_UI_TIME_FORMAT_NOTE, ApiConstants.UI_TIME_FORMAT_NOTE),
                Map.entry(ApiConstants.MODEL_ATTR_UI_TIME_NOTE_DAYS_ONLY, ApiConstants.UI_TIME_NOTE_DAYS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_UI_TIME_NOTE_DMY, ApiConstants.UI_TIME_NOTE_DMY),
                Map.entry(ApiConstants.MODEL_ATTR_UI_TIME_NOTE_MONTHS_ONLY, ApiConstants.UI_TIME_NOTE_MONTHS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_UI_TIME_NOTE_YEARS_ONLY, ApiConstants.UI_TIME_NOTE_YEARS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_UI_BUTTON_RESET, ApiConstants.UI_BUTTON_RESET),
                Map.entry(ApiConstants.MODEL_ATTR_UI_BUTTON_CALCULATE, ApiConstants.UI_BUTTON_CALCULATE),
                Map.entry(ApiConstants.MODEL_ATTR_UI_LINK_HOME, ApiConstants.UI_LINK_HOME),
                Map.entry(ApiConstants.MODEL_ATTR_UI_RESULT_HEADING, ApiConstants.UI_RESULT_HEADING),
                Map.entry(ApiConstants.MODEL_ATTR_UI_RESULT_INTEREST, ApiConstants.UI_RESULT_INTEREST),
                Map.entry(ApiConstants.MODEL_ATTR_UI_RESULT_TOTAL_AMOUNT, ApiConstants.UI_RESULT_TOTAL_AMOUNT),
                Map.entry(ApiConstants.MODEL_ATTR_UI_STYLESHEET_PATH, ApiConstants.UI_STYLESHEET_PATH),
                Map.entry(ApiConstants.MODEL_ATTR_UI_SIMPLE_SCRIPT_PATH, ApiConstants.UI_SIMPLE_SCRIPT_PATH),
                Map.entry(ApiConstants.MODEL_ATTR_UI_INDEX_PATH, ApiConstants.UI_INDEX_PATH),
                Map.entry(ApiConstants.MODEL_ATTR_UI_SIMPLE_INTEREST_PATH, ApiConstants.UI_SIMPLE_INTEREST_PATH),
                Map.entry(ApiConstants.MODEL_ATTR_REQUEST_PARAM_PRINCIPAL, ApiConstants.REQUEST_PARAM_PRINCIPAL),
                Map.entry(ApiConstants.MODEL_ATTR_REQUEST_PARAM_RATE, ApiConstants.REQUEST_PARAM_RATE),
                Map.entry(ApiConstants.MODEL_ATTR_REQUEST_PARAM_TIME, ApiConstants.REQUEST_PARAM_TIME),
                Map.entry(ApiConstants.MODEL_ATTR_REQUEST_PARAM_TIME_INPUT_MODE, ApiConstants.REQUEST_PARAM_TIME_INPUT_MODE),
                Map.entry(ApiConstants.MODEL_ATTR_REQUEST_PARAM_TIME_DAYS_ONLY, ApiConstants.REQUEST_PARAM_TIME_DAYS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_REQUEST_PARAM_TIME_MONTHS_ONLY, ApiConstants.REQUEST_PARAM_TIME_MONTHS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_REQUEST_PARAM_TIME_YEARS_ONLY, ApiConstants.REQUEST_PARAM_TIME_YEARS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_REQUEST_PARAM_TIME_DMY_DAYS, ApiConstants.REQUEST_PARAM_TIME_DMY_DAYS),
                Map.entry(ApiConstants.MODEL_ATTR_REQUEST_PARAM_TIME_DMY_MONTHS, ApiConstants.REQUEST_PARAM_TIME_DMY_MONTHS),
                Map.entry(ApiConstants.MODEL_ATTR_REQUEST_PARAM_TIME_DMY_YEARS, ApiConstants.REQUEST_PARAM_TIME_DMY_YEARS),
                Map.entry(ApiConstants.MODEL_ATTR_TIME_INPUT_MODE_DAYS_ONLY, ApiConstants.TIME_INPUT_MODE_DAYS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_TIME_INPUT_MODE_DAYS_MONTHS_YEARS, ApiConstants.TIME_INPUT_MODE_DAYS_MONTHS_YEARS),
                Map.entry(ApiConstants.MODEL_ATTR_TIME_INPUT_MODE_MONTHS_ONLY, ApiConstants.TIME_INPUT_MODE_MONTHS_ONLY),
                Map.entry(ApiConstants.MODEL_ATTR_TIME_INPUT_MODE_YEARS_ONLY, ApiConstants.TIME_INPUT_MODE_YEARS_ONLY)
        );
    }
}

