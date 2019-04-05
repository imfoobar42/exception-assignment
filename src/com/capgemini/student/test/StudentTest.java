package com.capgemini.student.test;

import org.junit.Test;

import com.capgemini.student.exception.AgeNotWithinRangeException;
import com.capgemini.student.exception.NameNotValidException;
import com.capgemini.student.model.Student;

import static org.junit.Assert.*;

import org.junit.Before;

public class StudentTest {

	@Test
	public void testObjectIsCreatedWithDefaultConstructor()
	{
		Student student = new Student();
		assertNotNull(student);
	}
	
	@Test
	public void testObjectIsCreatedWithParameterized() {
		Student student = new Student(25, "John Doe", 20, "CS");
		assertNotNull(student);
	}
	
	@Test(expected = AgeNotWithinRangeException.class)
	public void testAgeNotWithinRange() {
		Student student = new Student(25, "John Doe", 25, "CS");
	}
	
	@Test(expected = AgeNotWithinRangeException.class)
	public void testSetAgeNotWithinRange() {
		Student student = new Student(25, "John Doe", 20, "CS");
		student.setStudentAge(25);
	}
	
	@Test(expected = NameNotValidException.class)
	public void testStudentNameWithSpecialCharactersAndNumbers() {
		Student student = new Student(25, "John@94Doe", 20, "CS");
	}
	
	
	@Test(expected = NameNotValidException.class)
	public void testSetStudentNameWithSpecialCharactersAndNumbers() {
		Student student = new Student(25, "John Doe", 20, "CS");
		student.setStudentName("John5$Doe");
	}
}
