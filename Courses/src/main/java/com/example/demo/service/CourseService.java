package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CourseModel;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository; 
	
	public boolean addCourse(CourseModel courseModel) {
		CourseModel course = courseRepository.save(courseModel);
		return course != null?true:false;
	}
}
