package HashTable;

public class Main {

	public static void main(String[] args)
	{

		SimpleHashTable<String,String> ht  = new SimpleHashTable<>(String.class,10);

		ht.put("Adhikary","Bishal Adhikary");
		ht.put("Adhikary","Shaaar Adhikary");
		ht.put("Eizen","Star Eizen");
		ht.put("Franklin","Ranson Frankline");
		ht.put("Srar","Tear Srar");

		ht.printHashTable();


		System.out.println("-".repeat(50));
		System.out.println(ht.get("Eizen"));


	}
}
