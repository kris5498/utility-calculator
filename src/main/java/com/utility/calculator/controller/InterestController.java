package com.utility.calculator.controller;

import com.utility.calculator.constants.ApiConstants;
import com.utility.calculator.dto.request.SimpleInterestRequest;
import com.utility.calculator.dto.response.ApiResponse;
import com.utility.calculator.dto.response.SimpleInterestResponse;
import com.utility.calculator.service.InterestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = ApiConstants.OPEN_AI_TAG_NAME, description = ApiConstants.OPEN_AI_TAG_DESCRIPTION)
public class InterestController {

    private final InterestService interestService;

    @PostMapping(ApiConstants.SIMPLE_INTEREST_PATH)
    @Operation(summary = ApiConstants.OPEN_AI_OPERATION_SUMMARY, description = ApiConstants.OPEN_AI_OPERATION_DESCRIPTION)
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = ApiConstants.OPEN_AI_RESPONSE_CODE_OK, description = ApiConstants.OPEN_AI_RESPONSE_DESCRIPTION_OK),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = ApiConstants.OPEN_AI_RESPONSE_CODE_BAD_REQUEST, description = ApiConstants.OPEN_AI_RESPONSE_DESCRIPTION_BAD_REQUEST),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = ApiConstants.OPEN_AI_RESPONSE_CODE_INTERNAL_SERVER_ERROR, description = ApiConstants.OPEN_AI_RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR)
    })
    public ResponseEntity<ApiResponse<SimpleInterestResponse>> calculateSimpleInterest(
            @Valid @RequestBody SimpleInterestRequest request
    ) {
        SimpleInterestResponse response = interestService.calculateSimpleInterest(request);
        return ResponseEntity.ok(new ApiResponse<>(ApiConstants.OPERATION_STATUS_SUCCESS, response));
    }
}
