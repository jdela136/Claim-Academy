package com.claim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.entity.Student;
import com.claim.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	public void saveStudent(Student student) {
		repository.save(student);
	}
	
	public Student findStudentByLogIn(String email, String password) {
		return repository.findStudentByLogIn(email, password);
	}
	
	public List<Student> getStudents() {
		return repository.findAll();
	}
}
