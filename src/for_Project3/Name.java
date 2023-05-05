package for_Project3;

import java.util.Objects;
import java.io.Serializable;

public class Name implements Serializable{
	
	//A Name should consist of three Strings: first, middle, and last.
	
	private String first;
	private String middle;
	private String last;
	
	//You should be able to construct a Name in two ways (two constructors): with and without a middle name.
	
	public Name(String first, String middle, String last) {
		this.first = first;
		this.middle = middle;
		this.last = last;
	}
	
	//Use Eclipse to generate standard getters and setters for all three instance variables.
	
	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	
	//Use Eclipse to generate the equals() and hashCode() method to use your three instance variables.  
	
	//HADY: What am I supposed to do here?
	
	@Override
	public int hashCode() {
		return Objects.hash(first, last, middle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		return Objects.equals(first, other.first) && Objects.equals(last, other.last)
				&& Objects.equals(middle, other.middle);
	}

	
	//Override the inherited toString() to return the Name String in two possible formats: for example "Kristin Alise Jones" or 
	//"Kristin Jones" depending on whether the middle name is empty or not.
	
	//NEED TO DO: Produce the two formats
	//HADY: How can I include two different formats (in better terms, 
	//how can I check if a middle name exists? Is it a simple if(middle){return...;}?
	
	//RESOLVED
	
	@Override
	public String toString() {
		if(middle == null) {
			return first + " " + last;
		}else
		return first + " " + middle + " " + last;
	}

	
		
	}
	
	

