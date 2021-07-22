package com.liv2train.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.liv2train.entities.TrainingCenter;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {

	Page<TrainingCenter> findAll(Pageable paging); 
}
