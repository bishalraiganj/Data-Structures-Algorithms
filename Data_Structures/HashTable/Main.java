package HashTable;

import Stack.Employee;

public class Main {

	public static void main(String[] args)
	{





//		SimpleHashTable<String,String> sht = new SimpleHashTable<>(String.class,String.class,10);
//
//		sht.put("Adhikary","Bishal Adhikary");
//		sht.put("Franklin","Ranson Franklin");
//		sht.put("Aryan","Kartik Aryan");
//		sht.put("Adhikary","Ron");
//		sht.put("Casemiro","Footballer Casemiro");
//		sht.put("Zul","Monna Zul");
//		sht.put("Met","Life Met");
//
//
//		sht.printHashTable();
//
//		System.out.println(sht.get("Casemiro"));
//		System.out.println("-".repeat(50)+"\n\n");
//
//
//
//		SimpleHashTable<Integer, Employee> sht2 = new SimpleHashTable<>(Integer.class,Employee.class,10);
//		Employee bishal = new Employee("Bishal","Adhikary",1);
//		Employee ranson = new Employee("Ranson","Franklin",2);
//		Employee kartik = new Employee("Kartik","Aryan",3);
//		Employee ron = new Employee("Ron","Adhikary",4);
//		Employee footballer = new Employee("Footballer","Casemiro",5);
//		Employee conflict1 =  new Employee("Conflict","1",1);
//
//		sht2.put(1,bishal);
//		sht2.put(2,ranson);
//		sht2.put(3,kartik);
//		sht2.put(4,ron);
//		sht2.put(5,footballer);
//		sht2.put(1,conflict1);
//
//		sht2.printHashTable();
//
//		System.out.println(sht2.get(1));
//
//		System.out.println("-".repeat(50));
//
//		System.out.println(sht2.get(2));
//		System.out.println(sht2.removeFirst(2));
//		System.out.println(sht2.removeFirst(3));
//		System.out.println(sht2.get(1));
//
//		System.out.println(sht2.removeFirst(1));
//
//		System.out.println(sht2.get(1));
//		System.out.println("-".repeat(50));
//
//		sht2.printHashTable();
//
//		System.out.println("-".repeat(50));
//		System.out.println(sht2.removeFirst(1));
//
//		sht2.printHashTable();
//
//		System.out.println("-".repeat(50));
////		sht2.removeFirst(2);
//		sht2.put(2,new Employee("Le","Roy",2));
//		sht2.printHashTable();
//
////		sht2.removeFirst(2);
//		System.out.println(sht2.get(2));
//		sht2.printHashTable();
//
//
//		System.out.println("-".repeat(50));
//
//		sht2.put(3,new Employee("Sf","ss",3));
////		sht2.put(3,new Employee("sff","sfs",3));
//		sht2.printHashTable();
//
//
//		sht2.printHashTable();
//		sht2.put(123456789,new Employee("bishal","9A",9));
//		sht2.printHashTable();
//		System.out.println(sht2.get(123456789));
//
//
//		System.out.println(hashValueDemo(234,10));


		System.out.println(" Testing ChainedHashTable ");


		ChainedHashTable<Integer,String> ct =  new ChainedHashTable<>(Integer.class,String.class,10);
		ct.put(1,"a");
		ct.put(2,"b");
		ct.put(3,"c");
		ct.put(1234567,"fffff");
		ct.put(12345,"e");
		ct.put(9,"a1");

		ct.printHashTable();

		ct.remove(1234567);
		ct.remove(2);
		ct.remove(9);
		ct.printHashTable();

		System.out.println(ct.get(1));
		System.out.println(ct.get(9));
		System.out.println(ct.get(12345));

		System.out.println("-".repeat(50));

		ChainedHashTable<String,Employee> ct2 =  new ChainedHashTable<>(String.class,Employee.class,10);
		Employee bishal = new Employee("Bishal","Adhikary",1);
		Employee ranson = new Employee("Ranson","Franklin",2);
		Employee ron = new Employee("Ron","Aryan",3);
		Employee atish = new Employee("Atish","Bharat",4);
		Employee rita = new Employee("Rita","Tripathi",5);

		ct2.put("Adhikary",bishal);
		ct2.put("Franklin",ranson);
		ct2.put("Tripathi",rita);
		ct2.put("Bharat",atish);
		ct2.put("Aryan",ron);


		ct2.printHashTable();

		System.out.println("-".repeat(50));

		System.out.println(ct2.get("Franklin"));
		ct2.remove("Tripathi");
		ct2.printHashTable();


	}


	private  static int hashValueDemo(Object key, int capacity)
	{

		if(key instanceof Employee)
		{
			Employee e = (Employee) key;

			return e.lastName().length() % capacity;
		}
		else if(key instanceof String)
		{
			String str = (String) key;
			return str.length() % capacity;
		}
		else
		{
			// If primitive's such as int's floats's doubles's are key's then toString() is
			// invoked on their auto-boxed versions and their decimal string version is returned
			return key.toString().length() % capacity;
		}

	}
}
