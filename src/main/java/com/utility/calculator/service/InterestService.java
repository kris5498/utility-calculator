package com.utility.calculator.service;

import com.utility.calculator.dto.request.SimpleInterestRequest;
import com.utility.calculator.dto.response.SimpleInterestResponse;

import java.math.BigDecimal;

public interface InterestService {

    SimpleInterestResponse calculateSimpleInterest(SimpleInterestRequest request);

    BigDecimal convertTimeToYears(
            String timeInputMode,
            String timeDaysOnly,
            String timeMonthsOnly,
            String timeYearsOnly,
            String timeDmyDays,
            String timeDmyMonths,
            String timeDmyYears
    );
}
