package for_Project3;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Comparable<Person>, Serializable{
	
	//Instance variables: A Name, A Date (the birthday date), and a static int numPeople that should be initialized to 0. 
	//All should be private.
	
	private Name name;
	private Date date;
	private static int numPeople = 0;
	
	
	//Two constructors. One should take an already created Name and a Date, and increment numPeople.  The other should take the arguments 
	//necessary to create a Name and a Date in the body of the Person constructor, and also increment numPeople.
		
	
	//HADY: How do I include the 2 different constructors? Is what I wrote the one that takes a created Name and Date?
	
	
	//RESOLVED 
	
	public Person(Name name, Date date) {
		this.name = name;
		this.date = date;
		numPeople++;
	}
	
	public Person(String first, String last, Month month, int day, int year) {
		name = new Name(first, last);
		date = new Date(month, day, year);
		numPeople++;
	}
	//HADY: Again What am I supposed to do in this part?
	
	public Name getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public static int getNumPeople() {
		return numPeople;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date, name);
	}
	
	

	@Override
	public String toString() {
		return name + ", " + date + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(date, other.date) && Objects.equals(name, other.name);
	}


	
	//HADY: Is the compare method just like what we see normally? comparing the names and returning <0 or 0> or =?
	@Override
	public int compareTo(Person o) {
		int num = this.name.getLast().compareTo(o.getName().getLast());
		if(num == 0) {
			num = this.name.getFirst().compareTo(o.getName().getFirst());
		}
		return num;
	}

	
	
	
}
