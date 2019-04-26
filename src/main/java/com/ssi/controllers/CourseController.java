package com.ssi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssi.dao.CourseDAO;
import com.ssi.entity.Course;

@RestController
@RequestMapping("course")
public class CourseController {
	
@Autowired	
CourseDAO dao;	


@PostMapping(produces="application/json")
public Course addNewCourse(@RequestBody Course course){
	dao.addOrModifyCourse(course);
	return course;
}

@PutMapping(produces="application/json")
public Course updateCourse(@RequestBody Course course){
	dao.addOrModifyCourse(course);
	return course;
}

@DeleteMapping(value="{code}",produces="application/json")
public Course deleteCourse(@PathVariable String code){
	Course course=dao.removeCourse(code);
	return course;
}

@GetMapping(value="json/{code}",produces="application/json")
public Course getSingleCourseAsJSON(@PathVariable("code") String code){
	Course course=dao.getCourseById(code);
	return course;
}
@GetMapping(value="xml/{code}",produces="application/xml")
public Course getSingleCourseAsXML(@PathVariable("code") String code){
	Course course=dao.getCourseById(code);
	return course;
}

@GetMapping(value="json",produces="application/json")
public List<Course> getAllCoursesAsJSON(){
	List<Course> courses=dao.getAllCourses();
	System.out.println(courses.size());
	return courses;
}
@GetMapping(value="xml",produces="application/xml")
public List<Course> getAllCoursesAsXML(){
	List<Course> courses=dao.getAllCourses();
	System.out.println(courses.size());
	return courses;
}


@RequestMapping("hello")
public String testAPI(){
	return "HELLO";
}


}
