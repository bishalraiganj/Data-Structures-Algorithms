package HashTable;


import Stack.Employee;

import java.util.*;

public class Challenge2 {

	public static void main(String[] args) {

		LinkedList<Employee> employees = new LinkedList<>();
		employees.add(new Employee("Jane", "Jones", 123));
		employees.add(new Employee("John", "Doe", 5678));
		employees.add(new Employee("Mike", "Wilson", 45));
		employees.add(new Employee("Mary", "Smith", 5555));
		employees.add(new Employee("John", "Doe", 5678));
		employees.add(new Employee("Bill", "End", 3948));
		employees.add(new Employee("Jane", "Jones", 123));

		employees.forEach(e -> System.out.println(e));


		HashMap<Integer,Employee> hm = new HashMap<>();
//		employees.forEach((e)->{
//			hm.put(e.id(),e);
//		});
//
//		hm.entrySet().forEach(e->{
//			System.out.println("Key:"+e.getKey()+" Value:"+e.getValue());
//		});


		int index = -1;
		ListIterator<Employee> li = employees.listIterator();

		List<Integer> removeList = new ArrayList<>();
		while(li.hasNext())
		{

			index++;
			Employee e = li.next();
			if(hm.containsKey(e.id()))
			{
				removeList.add(index);
			}
			else {
				hm.put(e.id(), e);
			}

		}

		removeList.forEach(System.out::println);

		int removedCounter =0;
		for(int i :  removeList)
		{

			employees.remove(i-removedCounter);
			removedCounter++;

		}
		employees.forEach(System.out::println);


//        int[] nums = new int[10];
//        int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };
//        for (int i = 0; i < numsToAdd.length; i++) {
//            nums[hash(numsToAdd[i])] = numsToAdd[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
	}

	public static int hash(int value) {
		return Math.abs(value % 10);
	}
}
