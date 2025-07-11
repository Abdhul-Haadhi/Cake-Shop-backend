package com.bit.backend.repositories;

import com.bit.backend.entities.OrderSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSummaryRepository extends JpaRepository<OrderSummaryEntity, Long> {
}
