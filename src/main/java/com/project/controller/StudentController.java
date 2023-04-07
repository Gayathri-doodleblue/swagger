package com.project.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.model.Student;
import com.project.service.FileService;
import com.project.service.StudentService;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;

@RestController

public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private FileService fileService;
	@PostMapping("/add")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Student addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	@GetMapping("/get")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Student> viewStudent()
	{
		return studentService.viewStudent();
	}
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Student updateList(@RequestBody Student student) {
		return studentService.updatestudent(student);
	}
	
	@DeleteMapping("/delete/{studentId}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@Transactional
	public String deleteStudent(@PathVariable Long studentId)
	{
		 studentService.deleteStudent(studentId);
		 return "Deleted successfully";
		
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("image")MultipartFile file) throws IOException {
		String uploadFile = fileService.uploadFile(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadFile);
	}

	@GetMapping("/view/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
		byte[] fileData=fileService.downloadFile(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("file/pdf"))
				.body(fileData);

	}
}
