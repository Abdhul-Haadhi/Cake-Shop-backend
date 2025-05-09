package com.bit.backend.controllers;


import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.dtos.FeedbackAndRatingDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.EmployeeRegistrationServiceI;
import com.bit.backend.services.FeedbackAndRatingServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class FeedbackAndRatingController {
    private final FeedbackAndRatingServiceI feedbackAndRatingServiceI;

    public FeedbackAndRatingController(FeedbackAndRatingServiceI feedbackAndRatingServiceI) {
        this.feedbackAndRatingServiceI = feedbackAndRatingServiceI;
    }

    @PostMapping("/feedback-and-rating")

    public ResponseEntity<FeedbackAndRatingDto> addForm(@RequestBody FeedbackAndRatingDto feedbackAndRatingDto) {

        try {
            FeedbackAndRatingDto feedbackAndRatingDtoResponse = feedbackAndRatingServiceI.addFeedbackAndRatingEntity(feedbackAndRatingDto);
            return ResponseEntity.created(URI.create("/feedback-and-rating"+feedbackAndRatingDtoResponse.getId())).body(feedbackAndRatingDtoResponse);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/feedback-and-rating")

    public ResponseEntity<List<FeedbackAndRatingDto>> getData(){

        try {
            List<FeedbackAndRatingDto> feedbackAndRatingDtoList = feedbackAndRatingServiceI.getData();
            return ResponseEntity.ok(feedbackAndRatingDtoList);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/feedback-and-rating/{id}")

    public ResponseEntity<FeedbackAndRatingDto> updateFeedbackForm(@PathVariable Long id, @RequestBody FeedbackAndRatingDto feedbackAndRatingDto) {

        try {
            FeedbackAndRatingDto responseFeedbackAndRatingDto = feedbackAndRatingServiceI.updateFeedbackAndRating(id,feedbackAndRatingDto);
            return ResponseEntity.ok(responseFeedbackAndRatingDto);
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
