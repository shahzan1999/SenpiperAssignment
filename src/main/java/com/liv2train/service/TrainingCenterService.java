package com.liv2train.service;

import org.springframework.http.ResponseEntity;

import com.liv2train.DTO.TrainingCenterRequestDTO;

public interface TrainingCenterService {
	
	public ResponseEntity<?> saveTrainingCenter(TrainingCenterRequestDTO trainingCenterRequestDTO);
	
	public ResponseEntity<?> getAllTrainingCenters();
	
	public ResponseEntity<?> getAllTrainingCentersPaginated(Integer pageNo, Integer pageSize);

}
