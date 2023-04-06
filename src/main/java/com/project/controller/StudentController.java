package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Student;
import com.project.service.StudentService;

@RestController

public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	@GetMapping("/get")
	public List<Student> viewStudent()
	{
		return studentService.viewStudent();
	}


}
