package com.capgemini.student.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.student.exception.AgeNotWithinRangeException;
import com.capgemini.student.exception.NameNotValidException;

public class Student {

	private String regx ="^[\\p{L} .'-]+$";
	Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
	private int rollNumber;
	private String studentName;
	private int studentAge;
	private String courseName;
	
	public Student() {
		
	}
	
	public Student(int rollNumber, String studentName, int studentAge, String courseName) {
		this.rollNumber = rollNumber;
		Matcher matcher = pattern.matcher(studentName);
		if(!matcher.find())
			throw new NameNotValidException("Name should not contain special characters and numbers");
		this.studentName = studentName;
		if(studentAge<15 || studentAge>21)
			throw new AgeNotWithinRangeException("Age is not between 15 and 21");
		this.studentAge = studentAge;
		this.courseName = courseName;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		Matcher matcher = pattern.matcher(studentName);
		if(!matcher.find())
			throw new NameNotValidException("Name should not contain special characters and numbers");
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		if(studentAge<15 || studentAge>21)
			throw new AgeNotWithinRangeException("Age is not between 15 and 21");
		this.studentAge = studentAge;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}	

}
