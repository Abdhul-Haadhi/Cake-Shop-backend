package com.bit.backend.repositories;

import com.bit.backend.entities.FeedbackAndRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackAndRatingRepository extends JpaRepository<FeedbackAndRatingEntity, Long> {
}
