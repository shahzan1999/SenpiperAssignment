package com.liv2train.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "training_centers")
public class TrainingCenter extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 21072021L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=40)
	private String name;
	
	@Column(length=12)
	private String code;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@Column
	private Integer studentCapacity;
	
	// It is assumed here that like one center has multiple courses , one course can also be offered on multiple centers.
	// Therefore ManyToMany relationship is used.
	@ManyToMany
	@JoinTable(
			name = "center_cource",
			joinColumns = @JoinColumn(name = "center_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> coursesOffered;
	
	@Column
    private String email;
    
    @Column
    private String phone;

    // getters and setters
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getStudentCapacity() {
		return studentCapacity;
	}

	public void setStudentCapacity(Integer studentCapacity) {
		this.studentCapacity = studentCapacity;
	}

	public Set<Course> getCoursesOffered() {
		return coursesOffered;
	}

	public void setCoursesOffered(Set<Course> coursesOffered) {
		this.coursesOffered = coursesOffered;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
