package com.capgemini.date.model;

import com.capgemini.date.exception.InvalidDayException;
import com.capgemini.date.exception.InvalidMonthException;

public class MyDate {

	private int day;
	private int month;
	private int year;
	
	
	
	public MyDate() {
	}



	public MyDate(int day, int month, int year) {
		if(!isValidMonth(month))
			throw new InvalidMonthException("Invalid month entered");
		this.month = month;
		if(!isValidDay(day, month,year))
			throw new InvalidDayException("Invalid day entered");
		this.day = day;
		this.year = year;
	}



	public boolean isValidMonth(int month) {
		if(month>=1&&month<=12)
			return true;
		return false;
	}



	public boolean isValidDay(int day, int month, int year) {
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
		{
			if(day>31 || day<1)
				return false;
		}
		else if(month==4 || month==6 || month==9 || month==11)
		{
			if(day>30 || day<1)
				return false;
		}
		else if(month ==2)
		{
			if(year%4 == 0)
			{
				if(year%100==0 && year%400!=0)
				{
					if(day>28 || day<1)
						return false;
				}
				else
				{
					if(day>29 || day<1)
						return false;
				}
			}
			else
			{
				if(day>28)
					return false;
			}
		}
		return true;
	}



	public int getDay() {
		return day;
	}



	public void setDay(int day) {
		this.day = day;
	}



	public int getMonth() {
		return month;
	}



	public void setMonth(int month) {
		this.month = month;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}
	
	

}
