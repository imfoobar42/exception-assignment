package com.capgemini.taxapp.model;

import com.capgemini.taxapp.exception.CountryNotValidException;
import com.capgemini.taxapp.exception.EmployeeNameInvalidException;
import com.capgemini.taxapp.exception.NotEligibleForTaxCalculation;

public class TaxCalculator {

	private String employeeName;
	private long employeeSalary;
	private boolean isIndian;
	
	public TaxCalculator() {
		super();
	}

	public TaxCalculator(String employeeName, long employeeSalary, boolean isIndian) {
		if(employeeName == null || employeeName.trim().length()==0)
			throw new EmployeeNameInvalidException("Employee Name should not be blank");
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		if(!isIndian)
			throw new CountryNotValidException("The employee should be Indian to calculate tax");
		this.isIndian = isIndian;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public long getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public boolean isIndian() {
		return isIndian;
	}

	public void setIndian(boolean isIndian) {
		this.isIndian = isIndian;
	}

	public double calculateTax()
	{
		double tax = 0;
		if(employeeSalary > 100000)
			tax = employeeSalary*8/100;
		else if(employeeSalary>50000 && employeeSalary<=100000)
			tax = employeeSalary*6/100;
		else if(employeeSalary>30000 && employeeSalary<=50000)
			tax = employeeSalary*5/100;
		else if(employeeSalary>10000 && employeeSalary<=30000)
			tax = employeeSalary*3/100;
		else
			throw new NotEligibleForTaxCalculation("The employee does not need to pay tax");
		
		return tax;
	}
	
	
	
}
