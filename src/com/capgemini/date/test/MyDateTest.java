package com.capgemini.date.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.date.exception.InvalidDayException;
import com.capgemini.date.exception.InvalidMonthException;
import com.capgemini.date.model.MyDate;
import com.capgemini.student.model.Student;

public class MyDateTest {

	@Test
	public void testObjectIsCreatedWithDefaultConstructor()
	{
		MyDate mydate = new MyDate();
	}
	
	@Test
	public void testObjectIsCreatedWithParameterized() {
		MyDate mydate = new MyDate(21,3,2019);
	}
	
	@Test(expected = InvalidDayException.class)
	public void testWhenInvalidDay() {
		MyDate mydate = new MyDate(29,2,2003);
	}
	
	@Test(expected = InvalidMonthException.class)
	public void testWhenInvalidMonth() {
		MyDate mydate = new MyDate(29,13,2003);
	}

}
