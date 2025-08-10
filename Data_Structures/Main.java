public class Main {


	public static void main(String... args)
	{
//		Employee janeJones = new Employee("Jane","Jones",123);
//		Employee johnDoe = new Employee("John","Doe",4567);
//		Employee marySmith = new Employee("Mary","Smith",789);
//		Employee mikeWilson = new Employee("Mike","Wilson",3245);
//
//
//		EmployeeLinkedList list = new EmployeeLinkedList();
//		list.addToFront(janeJones);
//		list.addToFront(johnDoe);
//		list.addToFront(marySmith);
//		list.addToFront(mikeWilson);
//
//
//		list.printList();
//
//		System.out.println(list.getSize());
//
//		list.removeFromFront();
//		System.out.println(list.getSize());
//		list.printList();
//
//		System.out.println("-".repeat(50));
//
//		EmployeeDoublyLinkedList list2 = new EmployeeDoublyLinkedList();
//		list2.addToFront(janeJones);
//		list2.addToFront(johnDoe);
//		list2.addToFront(marySmith);
//		list2.addToFront(mikeWilson);
//
//		list2.printList();
//		System.out.println(list2.getSize());
//
//		Employee bishal = new Employee("Bishal","Adhikary",1);
//		list2.addToEnd(bishal);
//		list2.printList();
//		System.out.println(list2.getSize());
//
//		list2.removeFromFront();
//		list2.printList();
//		System.out.println(list2.getSize());
//
//		System.out.println("-".repeat(50));
//		list2.removeFromEnd();
//		list2.printList();
//		System.out.println(list2.getSize());
//
//
//
//		System.out.println("-".repeat(50));
//		list2.printList();
//		list2.addBefore(bishal,janeJones);
//		list2.printList();
//
//		Employee mirage = new Employee("Mirage","2000",1984);
//
//		list2.addBefore(mirage,bishal);
//		list2.printList();
//		System.out.println(list2.getSize());
//
//
//		System.out.println("-".repeat(50));
//		EmployeeDoublyLinkedList list3 = new EmployeeDoublyLinkedList();
//		list3.addToEnd(bishal);
//		list3.printList();
//		list3.addBefore(mirage,bishal);
//		list3.printList();


		System.out.println("-".repeat(50));

		SinglyLinkedList<Employee> list = new SinglyLinkedList<>();

		Employee bishal = new Employee("Bishal","Adhikary",1);
		Employee ranson = new Employee("Ranson","Franklin",2);
		Employee shyamol = new Employee("Shyaml","Ha",3);
		Employee bhuvan = new Employee("Bhuvan","Bam",88);
		Employee rocky = new Employee("Rocky","Bhai",70);


		list.addToFrontSorted(bishal);
		list.addToFrontSorted(ranson);
		list.addToFrontSorted(shyamol);
		list.addToFrontSorted(bhuvan);
		list.addToFrontSorted(rocky);
		list.addToFrontSorted(new Employee("Horibol","Bhajagourange",6));

		System.out.println(list.printList());



	}
}
