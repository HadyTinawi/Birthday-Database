package for_Project3;
import java.util.Comparator;
import java.util.Iterator;

public class LinkedList<E extends Comparable<E>> implements Iterable<E> {

	private Node<E> head;
	private int size;
	private Comparator<E> myComparator;
	
	public LinkedList() {
		head = null;
		size = 0;
		myComparator = null;
	}
	
	public LinkedList(Comparator<E> c) {
		head = null;
		size = 0;
		myComparator = c;
		
	}
	
	public int size() {
		return size;
	}
	
	public void add(E data) {
		Node<E> n = new Node<>(data);
		if(head == null) {
			head = n;
			size++;
			return;
			}
		Node<E> mover = head;
		while(mover.getLink() != null) {
			mover = mover.getLink();
		}
		mover.setLink(n);
		size++;
	}
	
	public void addFirst(E data) {
		Node<E> n = new Node<>(data);
		n.setLink(head);
		head = n;
		size++;
	}
	
	public String toString() {
		String toReturn = "";
		Node<E> mover = head;
		while(mover != null) {
		toReturn += mover.getData() + " - ";
		mover = mover.getLink();
		}
		if(size == 0) {
		return "List is empty";
		}
		return toReturn;
		}
	
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node <E> mover = head;
		for(int i = 0 ; i < index ; i++) {
			mover = mover.getLink();
		}
		return mover.getData();
	}
	
	public E set(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node <E> mover = head;
		for(int i = 0 ; i < index ; i++) {
			mover = mover.getLink();
		}
		return mover.getData();
	}
	
	
	public boolean remove(E data) {
		if(head == null) {
			return false;
		}
		if(head.getData().equals(data)) {
			head = head.getLink();
			size--;
			return true;
		}
		
		Node<E> mover1 = head;
		Node<E> mover2 = head.getLink();
		
		while(mover2 != null) {
			if(mover2.getData().equals(data)) {
				mover1.setLink(mover2.getLink());
				size--;
				return true;
			}else {
				mover1 = mover1.getLink();
				mover2 = mover2.getLink();
			}
		}
		return false;
	}
	
	
	public void addAlpha(E data) {
		//Case 1: First Node, set Head to it
		
		Node<E> n = new Node<>(data);
		if(head == null) {
			head = n;
			size++;
			return;
		}
		Node<E> mover = head;
		
		//Case 2: Only one node, check for size, and compare if data comes before or after mover
		
		if(size == 1) {
			int o = mover.getData().compareTo(data);
			if(o > 0 ) {
				addFirst(data);
			}else {
				add(data);
			}
			return;
		}
		
		//Case 3: At least two Nodes, compare data to both (if it comes after Mover just add, 
		//if it comes before, then compare to previous, if its less than previous, add first,
		//if its greater than previous, add it in the middle
		
		Node<E> previous = head;
				
		while(mover.getLink() != null && data.compareTo(mover.getData()) > 0) {
			previous = mover;
			mover = mover.getLink();
		}
		
		
		
		/*mover = mover.getLink();
		if(size >= 2) {
			int i = mover.getData().compareTo(data);
			if(i > 0) {
				int y = mover.getData().compareTo(data);
				if(y > 0) {
					addFirst(data);
				}else {
					add(data);
				}
			}else {
				add(data);
			}
			return;
		}
		*/
		
		//Case 4: Mover points at the end of the list
		//and item also belongs at the end of the list
		
		if(mover.getLink() == null && data.compareTo(mover.getData()) > 0) {
			this.add(data);
			return;
		}
		
		//Case 5: Mover didn't get beyond pointing at Head, Node should be head of List
		if(mover == head) {
			addFirst(data);
			return;
		}
		
		//Final Case: insert node between previous and mover
		n.setLink(mover);
		previous.setLink(n);
		size++;
	}

	
	
	public boolean contains(E data) {
		Node<E> mover = head;
		while(mover != null) {
		if(mover.getData().equals(data)) {
			return true;
		}else {
			mover = mover.getLink();
			}
		}
		return false;	
	}
	
	private int myCompare(E first, E second){
	      if(myComparator == null){
	         return first.compareTo(second);
	         }
	         return myComparator.compare(first,second);
	   }
	
	public Node<E> getMiddle(Node<E> head){ 
		Node<E> slow = head;
		Node<E> fast = head;
		while(fast.getLink() != null && fast.getLink().getLink() != null) {
			slow = slow.getLink();
			fast = fast.getLink().getLink();
		}
		return slow; 
	}
	
	public Node<E> merge(Node<E> a, Node<E> b){ 
		Node<E> result = null;
		if(a == null) { 
			return b;
		}
		if(b == null) {
			return a;
		}
		if(myCompare(a.getData(), b.getData()) <= 0) { //HADY: Isn't the myCompare here an int? Why am I facing an error?
			result = a;
			result.setLink(merge(a.getLink(), b)); 
		} else {
			result = b;
			result.setLink(merge(a, b.getLink())); 
		}
		return result; 
	}
	
	public Node<E> mergeSort(Node<E> h) { 
		if(h == null || h.getLink() == null) {
			return h; 
		}
		Node<E> middle = getMiddle(h); 
		Node<E> nexttomiddle = middle.getLink(); 
		middle.setLink(null);
		Node<E> left = mergeSort(h);
		Node<E> right = mergeSort(nexttomiddle); 
		Node<E> sortedlist = merge(left, right); 
		return sortedlist;
	}
	
	public void sort() {
		head = this.mergeSort(head);
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator<E>(this);
	}
	
}

	
	
	
	

