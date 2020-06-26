package com.cjc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/student-service")
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/student-service/{rollno}")
	public Student getStudentByRollno(@PathVariable int rollno){
		Student student=studentRepository.findByRollno(rollno);
		student.setPort(env.getProperty("local.server.port"));
		return student;
	}
}
