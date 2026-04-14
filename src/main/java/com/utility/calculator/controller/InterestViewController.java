package com.utility.calculator.controller;

import com.utility.calculator.constants.ApiConstants;
import com.utility.calculator.dto.request.SimpleInterestRequest;
import com.utility.calculator.dto.response.SimpleInterestResponse;
import com.utility.calculator.service.InterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class InterestViewController {

    private final InterestService interestService;

    @GetMapping(ApiConstants.UI_INDEX_PATH)
    public String index() {
        return ApiConstants.VIEW_INDEX;
    }

    @GetMapping(ApiConstants.UI_SIMPLE_INTEREST_PATH)
    public String simpleInterestForm(Model model) {
        model.addAttribute(ApiConstants.MODEL_ATTR_SELECTED_TIME_INPUT_MODE, ApiConstants.TIME_INPUT_MODE_YEARS_ONLY);
        return ApiConstants.VIEW_SIMPLE;
    }

    @PostMapping(ApiConstants.UI_SIMPLE_INTEREST_PATH)
    public String calculateSimpleInterest(
            @RequestParam(ApiConstants.REQUEST_PARAM_PRINCIPAL) String principal,
            @RequestParam(ApiConstants.REQUEST_PARAM_RATE) String rate,
            @RequestParam(ApiConstants.REQUEST_PARAM_TIME_INPUT_MODE) String timeInputMode,
            @RequestParam(value = ApiConstants.REQUEST_PARAM_TIME_DAYS_ONLY, required = false) String timeDaysOnly,
            @RequestParam(value = ApiConstants.REQUEST_PARAM_TIME_MONTHS_ONLY, required = false) String timeMonthsOnly,
            @RequestParam(value = ApiConstants.REQUEST_PARAM_TIME_YEARS_ONLY, required = false) String timeYearsOnly,
            @RequestParam(value = ApiConstants.REQUEST_PARAM_TIME_DMY_DAYS, required = false) String timeDmyDays,
            @RequestParam(value = ApiConstants.REQUEST_PARAM_TIME_DMY_MONTHS, required = false) String timeDmyMonths,
            @RequestParam(value = ApiConstants.REQUEST_PARAM_TIME_DMY_YEARS, required = false) String timeDmyYears,
            Model model
    ) {
        model.addAttribute(ApiConstants.MODEL_ATTR_SELECTED_TIME_INPUT_MODE, timeInputMode);
        populateFormValues(
                model,
                principal,
                rate,
                timeDaysOnly,
                timeMonthsOnly,
                timeYearsOnly,
                timeDmyDays,
                timeDmyMonths,
                timeDmyYears
        );

        try {
            BigDecimal principalValue = new BigDecimal(principal);
            BigDecimal rateValue = new BigDecimal(rate);
            BigDecimal timeInYears = interestService.convertTimeToYears(
                    timeInputMode,
                    timeDaysOnly,
                    timeMonthsOnly,
                    timeYearsOnly,
                    timeDmyDays,
                    timeDmyMonths,
                    timeDmyYears
            );

            SimpleInterestRequest request = new SimpleInterestRequest(principalValue, rateValue, timeInYears);
            SimpleInterestResponse response = interestService.calculateSimpleInterest(request);
            model.addAttribute(ApiConstants.MODEL_ATTR_RESULT, response);
        } catch (NumberFormatException ex) {
            model.addAttribute(ApiConstants.MODEL_ATTR_ERROR, ApiConstants.UI_ERROR_INVALID_NUMBER);
        } catch (IllegalArgumentException ex) {
            model.addAttribute(ApiConstants.MODEL_ATTR_ERROR, ex.getMessage());
        }

        return ApiConstants.VIEW_SIMPLE;
    }

    private void populateFormValues(
            Model model,
            String principal,
            String rate,
            String timeDaysOnly,
            String timeMonthsOnly,
            String timeYearsOnly,
            String timeDmyDays,
            String timeDmyMonths,
            String timeDmyYears
    ) {
        model.addAttribute(ApiConstants.MODEL_ATTR_INPUT_PRINCIPAL, principal);
        model.addAttribute(ApiConstants.MODEL_ATTR_INPUT_RATE, rate);
        model.addAttribute(ApiConstants.MODEL_ATTR_INPUT_TIME_DAYS_ONLY, timeDaysOnly);
        model.addAttribute(ApiConstants.MODEL_ATTR_INPUT_TIME_MONTHS_ONLY, timeMonthsOnly);
        model.addAttribute(ApiConstants.MODEL_ATTR_INPUT_TIME_YEARS_ONLY, timeYearsOnly);
        model.addAttribute(ApiConstants.MODEL_ATTR_INPUT_TIME_DMY_DAYS, timeDmyDays);
        model.addAttribute(ApiConstants.MODEL_ATTR_INPUT_TIME_DMY_MONTHS, timeDmyMonths);
        model.addAttribute(ApiConstants.MODEL_ATTR_INPUT_TIME_DMY_YEARS, timeDmyYears);
    }
}
