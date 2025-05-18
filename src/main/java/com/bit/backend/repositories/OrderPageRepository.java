package com.bit.backend.repositories;

import com.bit.backend.entities.OrderPageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPageRepository extends JpaRepository<OrderPageEntity, Long> {
}
