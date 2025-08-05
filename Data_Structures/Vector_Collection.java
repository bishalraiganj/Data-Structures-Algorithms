import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Vector_Collection {


	public static void main(String... args)
	{


		List<Employee> employeeList = new Vector<>();

		ForkJoinPool fkjp = new ForkJoinPool(12);


		Employee bishal = new Employee("Bishal","Adhikary",1);
		Employee remisen = new Employee("Remisen","Eisen",2);
		Employee albert = new Employee("Albert","Einstein",3);
		Employee ben = new Employee("Ben","Benjamin",1);
		Employee antonio  = new Employee("Antonio","Rudiger",1);




		fkjp.submit(()->{
			employeeList.add(bishal);
			System.out.println(Thread.currentThread().getName() + " Added " +  bishal);
		});
		fkjp.submit(()->{
			employeeList.add(remisen);
			System.out.println(Thread.currentThread().getName() + " Added " +  remisen);
		});

		fkjp.submit(()->{
			employeeList.add(albert);
			System.out.println(Thread.currentThread().getName() + " Added " +  albert);
		});
		fkjp.submit(()->{
			employeeList.add(ben);
			System.out.println(Thread.currentThread().getName() + " Added " +  ben);
		});

		fkjp.submit(()->{
			employeeList.add(antonio);
			System.out.println(Thread.currentThread().getName() + " Added " +  antonio);
		});

		System.out.println("-".repeat(50));



		Map<Integer,List<Employee>> groupedList= employeeList.parallelStream()
				.collect(Collectors.groupingBy((e)->{
				return	e.id();
				},Collectors.toList()));

		groupedList.entrySet().forEach((e)->{
			System.out.println(e.getKey() + " | " + e.getValue());
		});


	}


}
