package com.example.repository;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	Iterable<Student> findByDateOfBirthBetween(LocalDate fromDate, LocalDate toDate);
	Iterable<Student> findByDateOfBirthAfter(LocalDate dateOfBirth);
	Iterable<Student> findByDateOfBirthBefore(LocalDate dateOfBirth);
	Iterable<Student> findByNameEquals(String name);
	Iterable<Student> findByNameLike(String pattern);
}
