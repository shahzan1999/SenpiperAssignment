package com.liv2train.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.liv2train.DTO.TrainingCenterRequestDTO;
import com.liv2train.service.TrainingCenterService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/trainingcenters")
public class TrainingCenterController {

	@Autowired
	private TrainingCenterService trainingCenterService;
	
	@PostMapping
	public ResponseEntity<?> createTrainingCenter(@Valid @RequestBody TrainingCenterRequestDTO trainingCenterRequestDTO) {
		return trainingCenterService.saveTrainingCenter(trainingCenterRequestDTO);
	}
	
	@GetMapping
	@ApiOperation(value = "Get All Training Centers")
	public ResponseEntity<?> getAllTrainingCenter() {
		return trainingCenterService.getAllTrainingCenters();
	}
	
	//This api is not a part of minimum viable product that was required in the assignment.
	@GetMapping("/{pageNo}/{pageSize}")
	@ApiOperation(value = "Get All training centers in paginated form",
	              notes = "This API returns all the traing center in paginated form. PageNo starts from 0")
	public ResponseEntity<?> getAllTrainingCenterPaginated(@PositiveOrZero @PathVariable Integer pageNo, 
			                                               @Positive @PathVariable Integer pageSize) {
		return trainingCenterService.getAllTrainingCentersPaginated(pageNo, pageSize);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String , String>
	handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getFieldErrors().forEach(error -> 
		          errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}
	
}
