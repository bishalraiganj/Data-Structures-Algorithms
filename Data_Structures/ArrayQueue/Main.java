package ArrayQueue;

public class Main {

	public static void main(String... args)
	{
		ArrayQueue<String> aq1 = new ArrayQueue<>(String.class,10);

		aq1.add("Bishal Adhikary");
		System.out.println(aq1.isEmpty());
		System.out.println(aq1.size());
		aq1.add("Ranson Franklin");

		System.out.println(aq1.size());
		aq1.printQueue();

		System.out.println("-".repeat(50));
		System.out.println(aq1.remove());
		System.out.println(aq1.size());
		aq1.printQueue();





	}





}
