package com.capgemini.factorial.test;

import static org.junit.Assert.*;

import org.junit.Before;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import com.capgemini.factorial.exception.FactorialException;
import com.capgemini.factorial.exception.InvalidInputException;
import com.capgemini.factorial.model.Factorial;

public class FactorialTest {

	private Factorial factorial;
	
	@Before
	public void setUp()
	{
		factorial = new Factorial();
		assertNotNull(factorial);
	}
	
	@Test
	public void testWhenInputGreaterThanEqualToTwo()
	{
		assertEquals(120, factorial.getFactorial(5));
	}
	
	@Test(expected = InvalidInputException.class)
	public void testWhenInputLessThanTwo()
	{
		factorial.getFactorial(1);
	}
	
	@Test(expected = FactorialException.class)
	public void testMaxFactorial()
	{
		factorial.getFactorial(54321);
	}
	

}
