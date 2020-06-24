package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class CourseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long courseId;
	
	@Column
	private String courseStatus;
	
	@Column
	private String courseName;
	
	@Column
	private String courseDuration;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	@Override
	public String toString() {
		return "CourseModel [courseId=" + courseId + ", courseStatus=" + courseStatus + ", courseName=" + courseName
				+ ", courseDuration=" + courseDuration + "]";
	}
	
	
}
