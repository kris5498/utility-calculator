package com.utility.calculator.service;

import com.utility.calculator.dto.request.SimpleInterestRequest;
import com.utility.calculator.dto.response.SimpleInterestResponse;

public interface InterestService {

    SimpleInterestResponse calculateSimpleInterest(SimpleInterestRequest request);
}
