package ArrayQueue;

public class Main {

	public static void main(String... args)
	{
//		ArrayQueue<String> aq1 = new ArrayQueue<>(String.class,10);
//
//		aq1.add("Bishal Adhikary");
//		System.out.println(aq1.isEmpty());
//		System.out.println(aq1.size());
//		aq1.add("Ranson Franklin");
//
//		System.out.println(aq1.size());
//		aq1.printQueue();
//
//		System.out.println("-".repeat(50));
//		System.out.println(aq1.remove());
//		System.out.println(aq1.size());
//		aq1.printQueue();
//
//		System.out.println("-".repeat(50));
//
//		aq1.add("Anesa B");
//		aq1.add("Oregon s");
//		aq1.add("Star p");
//		aq1.add("Pys a");
//		aq1.add("Simons d");
//		aq1.add("ds ds");
//		aq1.add("Jo j");
//		aq1.add("KP p");
//		aq1.remove();
//		aq1.remove();
//		aq1.remove();
//		aq1.remove();
//		aq1.remove();
//		aq1.remove();
//		aq1.remove();
//		System.out.println("-".repeat(50));
//		System.out.println(aq1.capacity());
//
//		aq1.add("Po s");
//
//		aq1.add("Os d");
//		System.out.println(aq1.capacity());
//		aq1.add("Wd s");
//		aq1.add("Mx s");
//
//
//		System.out.println("-".repeat(50));
//		aq1.remove();
//		aq1.printQueue();
//		System.out.println(aq1.capacity());
//
//		System.out.println(aq1.getFrontnBackCounterPosition());



		System.out.println("-".repeat(20)+" CircularArrayQueue Generic " + "-".repeat(20));


		CircularArrayQueue<String> cq1 = new CircularArrayQueue<>(String.class,5);

		cq1.add("Bishal Adhikary");
		cq1.add("Ranson Franklin");
		cq1.add("Anesa B");
		cq1.add("Oregon s");

		cq1.remove();
		cq1.remove();

		cq1.add(" End val");
		cq1.add("Wrapped Val 1");
		cq1.add("Resizing val");

		cq1.printQueue();

		System.out.println(cq1.size());
		System.out.println(cq1.getFrontnBackIndex());






	}





}
