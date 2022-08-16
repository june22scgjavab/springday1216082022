package com.example.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.entity.Assessment;
import com.example.entity.Student;



public class StudentDTO {


	private Integer studentId;

	private String name;
	private LocalDate dateOfBirth;
    private Integer marksScored;
	
	private AssessmentDTO assessmentDTO;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(Integer marksScored) {
		this.marksScored = marksScored;
	}
	public AssessmentDTO getAssessmentDTO() {
		return assessmentDTO;
	}
	public void setAssessmentDTO(AssessmentDTO assessmentDTO) {
		this.assessmentDTO = assessmentDTO;
	}
	@Override
	public int hashCode() {
		return Objects.hash(assessmentDTO, dateOfBirth, marksScored, name, studentId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDTO other = (StudentDTO) obj;
		return Objects.equals(assessmentDTO, other.assessmentDTO) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(marksScored, other.marksScored) && Objects.equals(name, other.name)
				&& Objects.equals(studentId, other.studentId);
	}
	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", marksScored=" + marksScored + ", assessmentDTO=" + assessmentDTO + "]";
	}


	

}
