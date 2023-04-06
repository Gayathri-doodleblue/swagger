package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Student;
import com.project.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(Student student)
	{
		return studentRepository.save(student);
	}
	
	public List<Student> viewStudent()
	{
		return studentRepository.findAll();
	}

}
