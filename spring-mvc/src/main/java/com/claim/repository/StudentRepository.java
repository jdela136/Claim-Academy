package com.claim.repository;

import com.claim.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
	
	@Query("SELECT S FROM Student S WHERE S.email = ?1 AND S.password = ?2")
	Student findStudentByLogIn(String email, String password);
}