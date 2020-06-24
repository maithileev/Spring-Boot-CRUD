package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
}
