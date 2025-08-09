public class Main {


	public static void main(String... args)
	{
		Employee janeJones = new Employee("Jane","Jones",123);
		Employee johnDoe = new Employee("John","Doe",4567);
		Employee marySmith = new Employee("Mary","Smith",789);
		Employee mikeWilson = new Employee("Mike","Wilson",3245);


		EmployeeLinkedList list = new EmployeeLinkedList();
		list.addToFront(janeJones);
		list.addToFront(johnDoe);
		list.addToFront(marySmith);
		list.addToFront(mikeWilson);


		list.printList();

		System.out.println(list.getSize());

		list.removeFromFront();
		System.out.println(list.getSize());
		list.printList();

		System.out.println("-".repeat(50));

		EmployeeDoublyLinkedList list2 = new EmployeeDoublyLinkedList();
		list2.addToFront(janeJones);
		list2.addToFront(johnDoe);
		list2.addToFront(marySmith);
		list2.addToFront(mikeWilson);

		list2.printList();
		System.out.println(list2.getSize());

		Employee bishal = new Employee("Bishal","Adhikary",1);
		list2.addToEnd(bishal);
		list2.printList();
		System.out.println(list2.getSize());

		list2.removeFromFront();
		list2.printList();
		System.out.println(list2.getSize());

		System.out.println("-".repeat(50));
		list2.removeFromEnd();
		list2.printList();
		System.out.println(list2.getSize());




	}
}
