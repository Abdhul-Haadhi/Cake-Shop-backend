package com.bit.backend.services;

import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.dtos.FeedbackAndRatingDto;

import java.util.List;

public interface FeedbackAndRatingServiceI {
    FeedbackAndRatingDto addFeedbackAndRatingEntity(FeedbackAndRatingDto feedbackAndRatingDto);
    List<FeedbackAndRatingDto> getData();
    FeedbackAndRatingDto updateFeedbackAndRating(long id,FeedbackAndRatingDto feedbackAndRatingDto);
}
