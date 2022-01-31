package com.claim.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.claim.entity.Student;
import com.claim.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/")
	public String welcome(Model model) {
		return "index";
	}

	@GetMapping("/sign-up")
	public ModelAndView signUp(Model model) {
		return new ModelAndView("sign-up", "student", new Student());
	}

	@PostMapping("/sign-up")
	public String handleSignUp(Model model, @ModelAttribute("student") Student student, HttpSession session) {
		service.saveStudent(student);
		model.addAttribute("newStudent", student);
		return "thank-you";
	}
	
	@GetMapping("/log-in")
	public ModelAndView logIn(Model model) { 
		return new ModelAndView("log-in", "student", new Student());
	}

	@PostMapping("/log-in")
	public String handleLogIn(Model model, @ModelAttribute("student") Student student, HttpSession session) {
		
		Student studentFromDb = service.findStudentByLogIn(student.getEmail(), student.getPassword());
		model.addAttribute("loggedInStudent", studentFromDb);
		return "home";
	}
	
	@GetMapping("/display-students")
	public String get(Model model) {
		List<Student> students = service.getStudents();
		model.addAttribute("students", students);
		return "display-students";
	}
}
