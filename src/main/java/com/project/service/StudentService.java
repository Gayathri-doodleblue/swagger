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

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> viewStudent() {
		return studentRepository.findAll();
	}

	public Student updatestudent(Student student) {

		Student existingStudent = studentRepository.findByStudentId(student.getStudentId());

		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setDepartment(student.getDepartment());

		existingStudent.setContact(student.getContact());

		return studentRepository.save(existingStudent);
	}
	
	public void deleteStudent(Long studentId)
	{
		//Student existingStudent = studentRepository.findByStudentId(student.getStudentId());
		
		 studentRepository.deleteByStudentId(studentId);
	}

}
