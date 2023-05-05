package for_Project3;

public class Driver {

	public static void main(String[] args) {
//		LinkedList<String> list = new LinkedList<>();
//		
//		//Setting George as the first object in our LinkedList
//		list.head = new Node<String>("George");
//		System.out.println(list.head.getData());
//		
//		
//		//Adding String objects to our LinkedList
//		list.head.setLink(new Node<String>("Lydia"));
//		System.out.println(list.head.getLink().getData());
//		
//		
//		list.head.getLink().setLink(new Node<String>("Barbara"));
//		System.out.println(list.head.getLink().getLink().getData());
//		
//		
//		list.head.getLink().getLink().setLink(new Node<String>("Bobby"));
//		System.out.println(list.head.getLink().getLink().getLink().getData());
//		
//		
//		//Setting Nancy as the first object in our LinkedList
//		Node<String> first = new Node<String>("Nancy");
//		first.setLink(list.head);
//		list.head = first;
//	}

		LinkedList<String> list = new LinkedList<>();
		//list.add("Nancy");
		list.add("George");
		list.add("Lydia");
		list.add("Barbara");
		list.add("Bobby");
		System.out.println(list);
		
		
		list.remove("Lydia");
		list.remove("Bobby");
		//list.remove("Nancy");
		
		System.out.println(list);
		
		
}

}