package for_Project3;

import java.util.Comparator;

public class ChronoComparator implements Comparator<Person> {

	@Override
	public int compare(Person a1, Person a2) {
		Date b1 = a1.getDate();
		Date b2 = a2.getDate();
		if(b1.getYear() == b2.getYear()) {
			if(b1.getMonth().getNum() == b2.getMonth().getNum()) {
			return Integer.compare(b1.getDay(), b2.getDay());
				}else {
					return Integer.compare(b1.getMonth().getDay(), b2.getMonth().getDay());
			}
		}else {
			return Integer.compare(b1.getYear(), b2.getYear());
		}
	}
	
}


//HADY: Here I am supposed to take in 2 Person objects and compare them based off of the Date and NOT the Name
//HADY: My question here is, How do I access the Date part of the object, and how do I access the individual components of the date?

//RESOLVED