package Heap;

public class Main {

	public static void main(String... args)
	{


		Heap<Integer> h1 = new Heap<>(Integer.class,100);

		h1.insert(45);
		h1.insert(39);
		h1.insert(5);
		h1.insertExact(37);
		h1.insertExact(34);
		h1.insertExact(37);
		h1.insertExact(36);
		h1.insertExact(33);
		h1.insertExact(32);
		h1.insertExact(31);
		h1.insertExact(30);
		h1.insertExact(34);
		h1.insertExact(33);
		h1.insertExact(32);

		h1.fixHeapBelow(2);

		h1.printHeap();

		System.out.println("-".repeat(50));


		Heap<Integer> h2 = new Heap<>(Integer.class,100);

		h2.insert(45);
		h2.insert(39);
		h2.insert(38);
		h2.insert(37);
		h2.insert(34);
		h2.insert(37);
		h2.insert(36);
		h2.insert(33);
		h2.insert(32);
		h2.insert(31);
		h2.insert(30);
		h2.insert(34);
		h2.insert(33);
		h2.insert(32);

		h2.printHeap();



		h2.delete(38);

		System.out.println("\n");

		h2.printHeap();

//		h2.delete(39);

		System.out.println("\n");
//		h2.printHeap();


		h2.delete(32);

		System.out.println("\n");

		h2.printHeap();




	}


}
