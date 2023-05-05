package for_Project3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PersonList {
	private int size;
	private LinkedList<Person> list = new LinkedList<Person>();
	
	
	//NEED TO DO: Returns false if p isn't added
	public boolean add(Person p) {
		if(!list.contains(p)) {
			list.add(p);
			return true;
		}else {
			return false;
		}
	}
	
	//NEED TO DO: Returns false if p isn't added
	public boolean addAlpha(Person p) {
		if(!list.contains(p)) {
			list.addAlpha(p);
			return true;
		}else {
			return false;
		}
	}
	
	public Person search(Person p) {
		if(!list.contains(p)) {
			return null;
		}else {
			return p;
		}
	}
	
	public String saveToFile(String fileName) {
		 String messageFromSave = "";
		 try {
		   ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileName));
		   for(int i = 0; i < list.size(); i++) { //HADY: It is asking me to create a size method. What do I do here?
		    oOS.writeObject(list.get(i));
		   }
		   oOS.flush();
		   oOS.close();
		 }catch(Exception e) {
		   messageFromSave = e.toString();
		 }
		  return messageFromSave;
		}

		public String loadFromFile(String fileName) {
		  String toReturn = ""; 
		  try{
		     ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileName));
		     while(oIS.available() > -1) {
		       Person fromFile = (Person)(oIS.readObject());
		       Person found = search(fromFile);
		       if(found == null) {
		         if(add(fromFile)) {
		             toReturn += fromFile + "\n";
		        }else {
		             toReturn += fromFile + " not successfully added to DB.\n";
		        }
		      }else {
		        toReturn += found + " already in the DB.\n";
		      }
		   }
		   oIS.close();
		   }catch (EOFException eOF){
		   }
		   catch(Exception e) {
		      toReturn += e;
		   }
		   return toReturn;
		}
		
	public boolean delete(Name n) { 
		LinkedListIterator<Person> iterator = new LinkedListIterator<Person>(list); //HADY:Is this the iterator I use to iterate through my list?
		//HADY: How do I access each Person object in the list? 
		//HADY: When I do access I just say if(Person.getName().equals(n)) {Person.remove();} ?
		while(iterator.hasNext()) {
			Person p = iterator.next();
			if(p.getName().equals(n)) {
				iterator.remove();
				return true;
		}
	}
		return false;
		
	}
	
	public String hasBirthdayOn(Date date) { //HADY: Do I use the same Iterator I used in the delete method directly above this?
		//HADY: to return the toString I just say Person.toString() ?
		
		for(Person p : list) {
			if(p.getDate().equals(date)) {
				return p.toString();
			}
			
		}return "Nobody has a birthday on that date";
		
	}
	
	public String printList() { //HADY: 
		String toRtrn = "";
		for(Person p : list) {
			toRtrn += p.toString();
		}
		return toRtrn;	
	}
	
	public String sortAlphab() {
		return printList();
	}
	
	// create a brand new LinkedList<Person>, but constructed with a Comparator object, too.Copy over all the Person objects from list, 
	//and call your merge sort on the new list.  Because the LinkedList is constructed with a Comparator, merge sort will sort the list 
	//chronologically. iterate through the list and build a String to return.
	
	public String sortChronol() {
		LinkedList<Person> list2 = new LinkedList<Person>(new ChronoComparator()); //HADY: What argument should go here?
		//How can I copy all the Person objects from the list?
		//HADY: After I call merge sort, I iterate through the list the same way I iterated for the above methods?
		//HADY: What do you mean by build a String to return?
		for(Person p : list) {
			list2.add(p);
		}
		list2.sort();
		String toRtrn = "";
		for (Person p : list2) {
			toRtrn += p.toString();
		}
		return toRtrn;
	}
	
			//HADY: How do I access each Person object in the list? 
			//HADY: When I do access I just say if(Person.getName().equals(n)) {Person.remove();} ?
	public String findPersonByName(Name name) {//HADY:Is this the iterator I use to iterate through my list?
		for(Person p : list) {
			if(p.getName().equals(name)) {
				return p.toString();
			}
		}
		return name + " is not found.";
	}
}
