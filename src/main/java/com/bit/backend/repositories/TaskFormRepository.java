package com.bit.backend.repositories;


import com.bit.backend.entities.TaskFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskFormRepository extends JpaRepository<TaskFormEntity, Long> {
}
