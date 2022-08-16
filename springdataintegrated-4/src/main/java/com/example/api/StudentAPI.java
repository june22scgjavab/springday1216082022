package com.example.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.StudentDTO;
import com.example.exception.AssessmentException;
import com.example.service.StudentService;

// http://localhost:6666/assessment
@RestController
@RequestMapping("/assessment")
public class StudentAPI {

	
	@Autowired
	private StudentService studentService;

	@Autowired
	private Environment environment;

	// GET--->// http://localhost:6666/assessment/students/1

	@GetMapping("/students/{id}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Integer studentId) throws AssessmentException {

		StudentDTO studentDTO =studentService.getStudent(studentId);
		return new ResponseEntity<>(studentDTO, HttpStatus.OK);

	}
	// PUT--->// http://localhost:5555/assessment/students/111

	/*   Enter the data for adding the student score as below
	 *           {
    
                   "name": "John",
                   "dateOfBirth": "2000-11-13",
                   "marksScored": 90,
                    "assessmentDTO": {
                    "assessmentId": 222
     
                             }
             }
	 * 
	 * 
	 */
	
	@PostMapping("/students/{assessmentId}")
	
	
	public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO,@PathVariable Integer assessmentId) throws AssessmentException {
		studentService.addStudent(studentDTO,assessmentId);
		String message = environment.getProperty("API.INSERT_SUCCESS");
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}

// DELETE-----> http://localhost:6666/assessment/students/4     
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer studentId) throws AssessmentException {
		studentService.deleteStudent(studentId);
		String message = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}


	// GET------->// http://localhost:6666/assessment/students
	@GetMapping("/students")
	public ResponseEntity<List<StudentDTO>> getStudents() throws AssessmentException {
		List<StudentDTO> studentDTOList = studentService.findAll();
		return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
	}

	

	// GET------->// http://localhost:6666/assessment/students/2000-11-13/2022-12-31
	@GetMapping("/students/{fromDate}/{toDate}")
	public ResponseEntity<List<StudentDTO>> getStudentsBetweenDOB(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate) throws AssessmentException {
		List<StudentDTO> studentDTOList = studentService.findStudentByDateOfBirthBetween(fromDate, toDate);
		return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
	}

	// GET------->// http://localhost:6666/assessment/students/dobafter/2000-12-01
	@GetMapping("/students/dobafter/{dateOfBirth}")
	public ResponseEntity<List<StudentDTO>> getStudentsAfterDOB(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfBirth) throws AssessmentException {
		List<StudentDTO> studentDTOList = studentService.findStudentByDateOfBirthAfter(dateOfBirth);
		return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
	}
	// GET------->// http://localhost:6666/assessment/students/dobbefore/2001-06-16
	@GetMapping("/students/dobbefore/{dateOfBirth}")
	public ResponseEntity<List<StudentDTO>> getStudentsBeforeDOB(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfBirth) throws AssessmentException {
		List<StudentDTO> studentDTOList = studentService.findStudentByDateOfBirthBefore(dateOfBirth);
		return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
	}
	// GET------->// http://localhost:6666/assessment/students/names/Paul
	@GetMapping("/students/names/{name}")
	public ResponseEntity<List<StudentDTO>> getStudentsByName(@PathVariable String name) throws AssessmentException {
		List<StudentDTO> studentDTOList = studentService.findStudentByNameEquals(name);
		return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
	}
	// GET------->// http://localhost:6666/assessment/students/names/pattern/P
	@GetMapping("/students/names/pattern/{pattern}")
	public ResponseEntity<List<StudentDTO>> getStudentsByPattern(@PathVariable String pattern) throws AssessmentException {
		List<StudentDTO> studentDTOList = studentService.findStudentByNameLike(pattern+"%");
		return new ResponseEntity<>(studentDTOList, HttpStatus.OK);
	}
}
