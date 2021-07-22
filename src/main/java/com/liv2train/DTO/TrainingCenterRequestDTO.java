package com.liv2train.DTO;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class TrainingCenterRequestDTO {

	@NotBlank(message = "Center name cannot be blank")
	@Size(max=40 , message = "Center name cannot be greater than 40 characters")
	private String centerName;
	
	@NotNull
	@Size(min =12 , max = 12 , message = "Center code can only be 12 characters")
	private String centerCode;
	
	@NotBlank(message = " Address cannot be blank")
	private String addressDetail;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	@PositiveOrZero(message = "Student capacity cannot be negative")
	private Integer studentCapacity;
	
	private List<@Size(max = 20, message = "Course Name cannot be greater than 20 characters")String> coursesOffered;
	
	private String contactEmail;
	
	private String contactPhone;

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Integer getStudentCapacity() {
		return studentCapacity;
	}

	public void setStudentCapacity(Integer studentCapacity) {
		this.studentCapacity = studentCapacity;
	}

	public List<String> getCoursesOffered() {
		return coursesOffered;
	}

	public void setCoursesOffered(List<String> coursesOffered) {
		this.coursesOffered = coursesOffered;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	
	
}
