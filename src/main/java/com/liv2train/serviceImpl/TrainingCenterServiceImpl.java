package com.liv2train.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.liv2train.DTO.ResponseEntityDTO;
import com.liv2train.DTO.TrainingCenterRequestDTO;
import com.liv2train.DTO.TrainingCenterResponseDTO;
import com.liv2train.entities.Address;
import com.liv2train.entities.Course;
import com.liv2train.entities.TrainingCenter;
import com.liv2train.repository.AddressRepository;
import com.liv2train.repository.CourseRepository;
import com.liv2train.repository.TrainingCenterRepository;
import com.liv2train.service.TrainingCenterService;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {

	@Autowired
	TrainingCenterRepository trainingCenterRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	CourseRepository courseRepository;
	
	
	/**
	 * This method takes TrainingCenter as object and create a response DTO  
	 */
	private static TrainingCenterResponseDTO toResponseDTO(TrainingCenter center) {
		TrainingCenterResponseDTO responseDTO = new TrainingCenterResponseDTO();
		responseDTO.setAddressDetail(center.getAddress().getDetail());
		responseDTO.setCenterCode(center.getCode());
		responseDTO.setCenterName(center.getName());
		responseDTO.setCity(center.getAddress().getCity());
		responseDTO.setContactEmail(center.getEmail());
		responseDTO.setContactPhone(center.getPhone());
		responseDTO.setId(center.getId());
		responseDTO.setPincode(center.getAddress().getPincode());
		responseDTO.setState(center.getAddress().getState());
		responseDTO.setStudentCapacity(center.getStudentCapacity());
		
		List<String> courses = new ArrayList<String>();
		for (Course course : center.getCoursesOffered()) {
			courses.add(course.getName());
		}
		responseDTO.setCoursesOffered(courses);
		
		return responseDTO;
	}
	
	
	@Override
	public ResponseEntity<?> saveTrainingCenter(TrainingCenterRequestDTO trainingCenterRequestDTO) {
		
		Set<Course> courses = new HashSet<>();
		for (String courseName : trainingCenterRequestDTO.getCoursesOffered()) {
			Course course =  courseRepository.findByName(courseName).orElse(null);
			if(course == null) {
				course = new Course(courseName);
				courseRepository.save(course);
			}
			courses.add(course);
		}
		
		Address address = new Address();
		address.setCity(trainingCenterRequestDTO.getCity());
		address.setDetail(trainingCenterRequestDTO.getAddressDetail());
		address.setPincode(trainingCenterRequestDTO.getPincode());
		address.setState(trainingCenterRequestDTO.getState());
		
		addressRepository.save(address);
		
		TrainingCenter trainingCenter = new TrainingCenter();
		trainingCenter.setCode(trainingCenterRequestDTO.getCenterCode());
		trainingCenter.setCoursesOffered(courses);
		trainingCenter.setEmail(trainingCenterRequestDTO.getContactEmail());
		trainingCenter.setName(trainingCenterRequestDTO.getCenterName());
		trainingCenter.setPhone(trainingCenterRequestDTO.getContactPhone());
		trainingCenter.setStudentCapacity(trainingCenterRequestDTO.getStudentCapacity());
	    trainingCenter.setAddress(address);
	    
		trainingCenterRepository.save(trainingCenter);
		
		TrainingCenterResponseDTO trainingCenterResponseDTO = toResponseDTO(trainingCenter);
		
		ResponseEntityDTO responseEntityDTO = new ResponseEntityDTO();
		responseEntityDTO.setStatus("Success");
		responseEntityDTO.setMessage("Training center saved successfully");
		responseEntityDTO.setData(trainingCenterResponseDTO);
		return new ResponseEntity<>(responseEntityDTO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllTrainingCenters() {
		
		List<TrainingCenter> trainingCenters = trainingCenterRepository.findAll();
		
		List<TrainingCenterResponseDTO> trainingCentersListDTO = new ArrayList<TrainingCenterResponseDTO>();
		
		for (TrainingCenter trainingCenter : trainingCenters) {
			TrainingCenterResponseDTO trainingCenterResponseDTO = toResponseDTO(trainingCenter);
			trainingCentersListDTO.add(trainingCenterResponseDTO);
		}
		
		ResponseEntityDTO responseEntityDTO = new ResponseEntityDTO();
		responseEntityDTO.setStatus("Success");
		responseEntityDTO.setMessage("List of training centers");
		responseEntityDTO.setData(trainingCentersListDTO);
		
		return new ResponseEntity<>(responseEntityDTO, HttpStatus.OK);
		
	}

	/**
	 * This methods return the list of all training centers in paginated form.
	 */
	@Override
	public ResponseEntity<?> getAllTrainingCentersPaginated(Integer pageNo, Integer pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());
		
		Slice<TrainingCenter> pagedResult = trainingCenterRepository.findAll(pageable);
		
		List<TrainingCenterResponseDTO> trainingCentersListDTO = new ArrayList<TrainingCenterResponseDTO>();

		for (TrainingCenter trainingCenter : pagedResult.getContent()) {
			TrainingCenterResponseDTO trainingCenterResponseDTO = toResponseDTO(trainingCenter);
			trainingCentersListDTO.add(trainingCenterResponseDTO);
		}
		
		ResponseEntityDTO responseEntityDTO = new ResponseEntityDTO();
		responseEntityDTO.setStatus("Success");
		responseEntityDTO.setMessage("List of training centers");
		responseEntityDTO.setData(trainingCentersListDTO);
		
		return new ResponseEntity<>(responseEntityDTO, HttpStatus.OK);
	}
	
	

}
