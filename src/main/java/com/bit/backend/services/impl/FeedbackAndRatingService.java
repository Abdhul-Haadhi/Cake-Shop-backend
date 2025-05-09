package com.bit.backend.services.impl;

import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.dtos.FeedbackAndRatingDto;
import com.bit.backend.entities.EmployeeRegistrationEntity;
import com.bit.backend.entities.FeedbackAndRatingEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.EmployeeRegistrationMapper;
import com.bit.backend.mappers.FeedbackAndRatingMapper;
import com.bit.backend.repositories.EmployeeRegistrationRepository;
import com.bit.backend.repositories.FeedbackAndRatingRepository;
import com.bit.backend.services.FeedbackAndRatingServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackAndRatingService implements FeedbackAndRatingServiceI {

    private final FeedbackAndRatingRepository feedbackAndRatingRepository;
    private final FeedbackAndRatingMapper feedbackAndRatingMapper;

    public FeedbackAndRatingService(FeedbackAndRatingRepository feedbackAndRatingRepository, FeedbackAndRatingMapper feedbackAndRatingMapper) {
        this.feedbackAndRatingRepository = feedbackAndRatingRepository;
        this.feedbackAndRatingMapper = feedbackAndRatingMapper;
    }


    @Override
    public FeedbackAndRatingDto addFeedbackAndRatingEntity(FeedbackAndRatingDto feedbackAndRatingDto) {
        try {
            System.out.println("*******************************");

            FeedbackAndRatingEntity feedbackAndRatingEntity = feedbackAndRatingMapper.toFeedbackAndRatingEntity(feedbackAndRatingDto);

            FeedbackAndRatingEntity savedItem = feedbackAndRatingRepository.save(feedbackAndRatingEntity);
            FeedbackAndRatingDto savedDto = feedbackAndRatingMapper.toFeedbackAndRatingDto(savedItem);

            return savedDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<FeedbackAndRatingDto> getData() {
        try {
            List<FeedbackAndRatingEntity> feedbackAndRatingEntityList = feedbackAndRatingRepository.findAll();
            List<FeedbackAndRatingDto> feedbackAndRatingDtoList = feedbackAndRatingMapper.toFeedbackAndRatingDtoList(feedbackAndRatingEntityList);
            return feedbackAndRatingDtoList;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public FeedbackAndRatingDto updateFeedbackAndRating(long id, FeedbackAndRatingDto feedbackAndRatingDto) {
        try {
            Optional<FeedbackAndRatingEntity> optionalFeedbackAndRatingEntity = feedbackAndRatingRepository.findById(id);

            if (!optionalFeedbackAndRatingEntity.isPresent()) {
                throw new AppException("Employee Registration does not Exists", HttpStatus.BAD_REQUEST);
            }

            FeedbackAndRatingEntity newFeedbackAndRatingEntity = feedbackAndRatingMapper.toFeedbackAndRatingEntity(feedbackAndRatingDto);
            newFeedbackAndRatingEntity.setId(id);


            FeedbackAndRatingEntity feedbackAndRatingEntity = feedbackAndRatingRepository.save(newFeedbackAndRatingEntity);
            FeedbackAndRatingDto responseFeedbackAndRatingDto = feedbackAndRatingMapper.toFeedbackAndRatingDto(feedbackAndRatingEntity);
            return responseFeedbackAndRatingDto;
        }
        catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
