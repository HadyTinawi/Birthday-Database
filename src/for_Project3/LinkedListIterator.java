package for_Project3;

import java.util.Iterator;

public class LinkedListIterator<E extends Comparable<E>> implements Iterator<E> {
	private LinkedList<E> ll;
	private Object element;
	private int index;
	private boolean removeGotCalled;
	
	public LinkedListIterator(LinkedList<E> thelist) {
		ll = thelist;
		element = ll.get(0);
		index = 0;
		removeGotCalled = false;
	}
	
	
	@Override
	public boolean hasNext() {
		return element != null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		Object toReturn = element;
		index++;
		try {
			element = ll.get(index);
		}catch(IndexOutOfBoundsException e) {
			element = null;
		}
		removeGotCalled = false;
		return (E)toReturn;
	}
	
	//If remove is called before next, or if it is called multiple times 
	//in a row without calling next an IllegalStateException is thrown
	@Override
	public void remove() {
		if(index == 0 || removeGotCalled) {
			throw new IllegalStateException();
		}
		ll.remove(ll.get(index-1));//HADY: Should I change the remove from the generic type E to int (as the eclipse resolve thingy suggests)?
		index--;
		removeGotCalled = true;
	}
}
