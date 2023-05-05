package for_Project3;

import java.util.Objects;
import java.io.Serializable;

public class Date implements Serializable{
	
	//A Date should consist of a month (a Month enum, which is written for you), a day (int) and a year (int).
	
	private Month month;
	private int day;
	private int year;
	
	
	//The three-argument constructor should only create a new Date object if the combination of Month and day is valid 
	//(see validation method inside Month enum) and if the year is not negative; if arguments are bad, an IllegalArgumentException should be 
	//thrown.
	
	//HADY: does this satisfy the instructions?
	
	//RESOLVED 
	public Date(Month month, int day, int year) throws IllegalArgumentException{
		
		if(!Month.isValidDay(month, day)) {
			throw new IllegalArgumentException(day + " is a bad day for " + month.getName() + "!");
		}
		if(year <= 0) {
			throw new IllegalArgumentException("Year cannot be negative!");
		}
		this.month = month;
		this.day = day;
		this.year = year;
		}
		
	
	//Use Eclipse to generate getters and setters for all instance variables, but modify them to forbid an invalid update to the month, day, 
	//and year in the setters. (See constructor instructions above for what "invalid" means.)
		

	public Month getMonth() {
		return month;
	}

	//HADY: does this satisfy the instructions?
	public void setMonth(Month month) {
		if(Month.isValidDay(month, day)) {
			this.month = month;
		}
	}


	public int getDay() {
		return day;
	}

	//HADY: does this satisfy the instructions?
	public void setDay(int day) {
		if(Month.isValidDay(month, day)) {
			this.day = day;
		}
	}


	public int getYear() {
		return year;
	}

	//HADY: does this satisfy the instructions?
	public void setYear(int year) {
		if(year > 0) {
			this.year = year;
		}
	}

	
	//Use Eclipse to generate the equals() and hashCode() methods so that you override the inherited methods to instead use your instance 
	//variables.
	
	//HADY: What am I supposed to do in this part?
	
	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}

	//Override the inherited toString() to return the Date String in the format "April 19, 2023"
	
	
	@Override
	public String toString() {
		return month + " " + day + ", " + year;
	}
	
	
	
	
	
}
