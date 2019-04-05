package com.capgemini.taxapp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.taxapp.exception.CountryNotValidException;
import com.capgemini.taxapp.exception.EmployeeNameInvalidException;
import com.capgemini.taxapp.exception.NotEligibleForTaxCalculation;
import com.capgemini.taxapp.model.TaxCalculator;

public class TaxCalculatorTest {

	@Test
	public void testObjectIsCreatedWithDefaultConstructor() {
		TaxCalculator taxCalculator = new TaxCalculator();
		assertNotNull(taxCalculator);
	}

	@Test
	public void testObjectIsCreatedWithParameterizedConstructor() {
		TaxCalculator taxCalculator = new TaxCalculator("Ron", 34000, true);
		assertNotNull(taxCalculator);
		assertEquals("Ron", taxCalculator.getEmployeeName());
		assertEquals(34000, taxCalculator.getEmployeeSalary());
		assertTrue(taxCalculator.isIndian());
		
	}
	
	@Test(expected = EmployeeNameInvalidException.class)
	public void testWhenEmployeeNameIsInvalid() {
		TaxCalculator taxCalculator = new TaxCalculator("        ", 34000, true);
	}
	
	@Test(expected = CountryNotValidException.class)
	public void testWhenCountryIsInvalid() {
		TaxCalculator taxCalculator = new TaxCalculator("Ron", 34000, false);
	}
	
	@Test(expected = NotEligibleForTaxCalculation.class)
	public void testWhenNotEligibleForTax() {
		TaxCalculator taxCalculator = new TaxCalculator("Ron", 9000, true);
		assertEquals(0, taxCalculator.calculateTax(),0.01);
	}
	
	@Test
	public void testWhenEligibleForTax() {
		TaxCalculator taxCalculator = new TaxCalculator("Ron", 55000, true);
		assertEquals(3300, taxCalculator.calculateTax(),0.01);
	}
}
