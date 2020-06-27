package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public CourseModel getCourse(Long id) {
		CourseModel course = courseRepository.findById(id).get();	
		return course;
	}
	
	public List getCourses() {
		List<CourseModel> courses = new ArrayList<>();
		courses = courseRepository.findAll();
		return courses;
	}
	
	public CourseModel updateCourse(Long id, CourseModel c) {
		CourseModel course = courseRepository.findById(id).get();
		course.setCourseDuration(c.getCourseDuration());
		course.setCourseName(c.getCourseName());
		course.setCourseStatus(c.getCourseStatus());
		courseRepository.save(course);
		return course; 
	}
	
	public boolean deleteCourse(Long id) {
		Optional<CourseModel> course = courseRepository.findById(id);
		
		if(course.isPresent()) {
		courseRepository.delete(course.get());
		return true;
		}
		else
			return false;
	}
	
}
