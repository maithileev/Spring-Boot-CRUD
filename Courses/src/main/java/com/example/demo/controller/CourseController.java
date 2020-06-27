package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CourseModel;
import com.example.demo.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Course")
public class CourseController {

	@Autowired
	CourseService service;
	
	@PostMapping(value = "/Add")
	public void insertCourse(@RequestBody CourseModel courseModel) {
		boolean result = service.addCourse(courseModel);
		
		if(result==true) {
			System.out.println("Course added");
		}
		else {
			System.out.println("Not added");
		}
	}
	
	@GetMapping(value = "/{id}")
	public CourseModel getCourse(@PathVariable Long id) {
		CourseModel course = service.getCourse(id);
		return course; 
	}
	
	@GetMapping(value = "/OurCourses")
	public List getCourses() {
		List<CourseModel> courses= service.getCourses();
		return courses;
	}
	
	@PutMapping(value = "/UpdateCourse/{id}")
	public CourseModel updateCourse(@RequestBody CourseModel c , @PathVariable Long id) {
		CourseModel courseModel = service.updateCourse(id, c);
		return courseModel;
	}
	
	@DeleteMapping(value = "/RemoveCourse/{id}")
	public void deleteCourse(@PathVariable Long id) {
		boolean result = service.deleteCourse(id);
		
		if(result == true) {
			System.out.println("Deleted");
		}
		else {
			System.out.println("Something went wrong");
		}
	}
}
