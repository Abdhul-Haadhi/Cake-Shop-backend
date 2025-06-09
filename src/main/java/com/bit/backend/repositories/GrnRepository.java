package com.bit.backend.repositories;

import com.bit.backend.entities.GrnEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrnRepository extends JpaRepository<GrnEntity, Long> {
}
