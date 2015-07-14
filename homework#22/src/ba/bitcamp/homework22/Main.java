package ba.bitcamp.homework22;

public class Main {

	public static void main(String[] args) {
		LinkedListDouble list = new LinkedListDouble();

		// Testing add methods
		list.add(3.14);
		list.add(5.5);
		list.add(3.21);
		list.add(9.9);
		System.out.println(list);
		System.out.println();
		
		list.add(0.07, 2);
		System.out.println(list);
		System.out.println();
		
		

	
		Double first = list.getFirst();
		System.out.println("First element: "+first);
		Double last = list.getLast();
		System.out.println("Last element: "+last);
		Double middle = list.getMidle();
		System.out.println("Middle element: "+middle);
		
		

		
		list.removeFirst();
		System.out.println(list);
		System.out.println();
		list.removeLast();
		System.out.println(list);
		System.out.println();
		list.remove(1);
		System.out.println(list);
		System.out.println();

		
		LinkedListDouble newList = new LinkedListDouble(list);
		newList.add(1.1);
		newList.add(2.2);
		newList.add(3.3);
		newList.add(4.4);
		
		System.out.println(newList);

	}

}
