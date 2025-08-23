package Stack;

public class Main {

	public static void main(String... args)
	{

		ArrayStack as = new ArrayStack(5);

		Employee bishal = new Employee("Bishal","Adhikary",1);
		Employee roshni = new Employee("Roshni","Srti",2);
		Employee trishita = new Employee("Trishita","Arya",3);
		as.push(bishal);
		as.push(roshni);
		as.push(trishita);

		as.printStack();

		System.out.println("-".repeat(50));
		System.out.println(as.peek());

		System.out.println("-".repeat(50));
		System.out.println(as.pop());
		System.out.println("-".repeat(50));

		as.printStack();


		System.out.println("-".repeat(50));

		LinkedStack<Employee> ls = new LinkedStack();
		ls.push(bishal);
		ls.push(roshni);
		ls.push(trishita);

		ls.printStack();

		System.out.println(ls.pop());

		System.out.println("-".repeat(50));
		ls.printStack();


	}

}
