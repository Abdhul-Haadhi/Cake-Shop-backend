package com.bit.backend.repositories;

import com.bit.backend.entities.ProductRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRegistrationRepository extends JpaRepository<ProductRegistrationEntity,Long> {
}
