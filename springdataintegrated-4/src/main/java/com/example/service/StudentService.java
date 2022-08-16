package com.example.service;

import java.time.LocalDate;
import java.util.List;

import com.example.dto.StudentDTO;
import com.example.entity.Student;
import com.example.exception.AssessmentException;

public interface StudentService {

	void addStudent(StudentDTO studentDTO, Integer assessmentId) throws AssessmentException;

	StudentDTO getStudent(Integer studentId) throws AssessmentException;

	List<StudentDTO> findAll() throws AssessmentException;

	void deleteStudent(Integer voterId) throws AssessmentException;

	List<StudentDTO> findStudentByDateOfBirthBetween(LocalDate fromDate, LocalDate toDate)throws AssessmentException;

	List<StudentDTO> findStudentByDateOfBirthAfter(LocalDate dateOfBirth)throws AssessmentException;

	List<StudentDTO> findStudentByDateOfBirthBefore(LocalDate dateOfBirth)throws AssessmentException;

	List<StudentDTO> findStudentByNameEquals(String name)throws AssessmentException;

	List<StudentDTO> findStudentByNameLike(String pattern)throws AssessmentException;
}
