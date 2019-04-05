package com.capgemini.factorial.model;

import com.capgemini.factorial.exception.FactorialException;
import com.capgemini.factorial.exception.InvalidInputException;

public class Factorial {
	
	private int MAX = Integer.MAX_VALUE;

	public Factorial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getFactorial(int number) {
		
		long sum=1;
		if(number>=2)
		{
			for(int i =number; i>=2; i--)
			{
				sum = sum * i;
				if(sum > MAX)
					throw new FactorialException("Integer limit exceeded");
			}
		}
		else
		{
			throw new InvalidInputException("Input is less than 2");
		}
		return sum;
	}
}
