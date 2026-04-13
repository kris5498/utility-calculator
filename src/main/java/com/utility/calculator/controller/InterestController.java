package com.utility.calculator.controller;

import com.utility.calculator.constants.ApiConstants;
import com.utility.calculator.dto.request.SimpleInterestRequest;
import com.utility.calculator.dto.response.ApiResponse;
import com.utility.calculator.dto.response.SimpleInterestResponse;
import com.utility.calculator.service.InterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping(ApiConstants.BASE_API_PATH)
public class InterestController {

    private final InterestService interestService;

    @PostMapping(ApiConstants.SIMPLE_INTEREST_PATH)
    public ResponseEntity<ApiResponse<SimpleInterestResponse>> calculateSimpleInterest(
            @Valid @RequestBody SimpleInterestRequest request
    ) {
        SimpleInterestResponse response = interestService.calculateSimpleInterest(request);
        return ResponseEntity.ok(new ApiResponse<>(ApiConstants.OPERATION_STATUS_SUCCESS, response));
    }
}
