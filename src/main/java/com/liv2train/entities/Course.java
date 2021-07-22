package com.liv2train.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 21072021L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "coursesOffered")
	private Set<TrainingCenter> trainingCenters;

	public Course() {
		super();
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<TrainingCenter> getTrainingCenters() {
		return trainingCenters;
	}

	public void setTrainingCenters(Set<TrainingCenter> trainingCenters) {
		this.trainingCenters = trainingCenters;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
