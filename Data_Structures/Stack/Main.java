package Stack;

public class Main {

	public static void main(String... args)
	{

		ArrayStack as = new ArrayStack(5);

		as.push(new Employee("Bishal","Adhikary",1));
		as.push(new Employee("Roshni","Srti",2));
		as.push(new Employee("Trishita","Arya",3));

		as.printStack();

		System.out.println("-".repeat(50));
		System.out.println(as.peek());

		System.out.println("-".repeat(50));
		System.out.println(as.pop());
		System.out.println("-".repeat(50));

		as.printStack();



	}

}
