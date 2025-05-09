package com.bit.backend.mappers;


import com.bit.backend.dtos.EmployeeRegistrationDto;
import com.bit.backend.dtos.FeedbackAndRatingDto;
import com.bit.backend.entities.EmployeeRegistrationEntity;
import com.bit.backend.entities.FeedbackAndRatingEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))

public interface FeedbackAndRatingMapper {
    FeedbackAndRatingDto toFeedbackAndRatingDto(FeedbackAndRatingEntity feedbackAndRatingEntity);
    FeedbackAndRatingEntity toFeedbackAndRatingEntity(FeedbackAndRatingDto feedbackAndRatingDto);

    List<FeedbackAndRatingDto> toFeedbackAndRatingDtoList(List<FeedbackAndRatingEntity> feedbackAndRatingEntityList);
}
