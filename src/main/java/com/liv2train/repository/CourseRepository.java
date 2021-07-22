package com.liv2train.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liv2train.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Optional<Course> findByName(String courseName);
}
