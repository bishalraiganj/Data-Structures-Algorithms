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




	}


}
