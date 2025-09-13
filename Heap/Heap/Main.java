package Heap;

public class Main {

	public static void main(String... args)
	{


		Heap<Integer> h1 = new Heap<>(Integer.class,100);

		h1.insert(45);
		h1.insert(39);
		h1.insert(38);
		h1.insert(37);
		h1.insert(34);
		h1.insert(40);
		h1.insert(36);
		h1.insert(33);
		h1.insert(32);
		h1.insert(31);
		h1.insert(30);
		h1.insert(47);
		h1.insert(33);
		h1.insert(32);

		h1.printHeap();




	}


}
