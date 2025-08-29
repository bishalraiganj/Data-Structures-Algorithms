package ArrayQueue;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ArrayQueue<T extends Object> {


	private T[] queue;
	private int front;
	private int back;

	public ArrayQueue(Class<T> clazz,int capacity)
	{

		// We are returning the actual generic type of array at runtime
		//but since the method signature of Array.newInstance() has Object as return type
		//the compiler thinks it is object even though the actual type is the generic type[]
		//because , we are sending the Class object/instance representing that generic type of array
		// cause arrays are reified
		//we still have to cast to tell the compiler that trust me it is of that type T[]
		// This approach is better than creating Object[] and casting
		// cause , in our cause the actual type is our desired on even though we have to pass the
		// class object
		this.queue =  (T[]) Array.newInstance(clazz,capacity);
	}


	public void add(T item)
	{

		// if there are less than half the size of number of elements then we shift them back to
		// the start, we do not create another double sized array and shift ,
		//we do it directly , because we still have significant space left
		if(back == queue.length && (back-front >= queue.length/2 ))
		{
			queue = Arrays.copyOf(queue,queue.length * 2 );
		}
		else if(back == queue.length)
		{
			int count = 0;
			for(T val : queue)
			{
				queue[count++] = val;
			}
		}
		else
		{
			queue[back++] = item;
		}

	}

	public T remove()
	{
		if(front ==  back ) // or back - front == 0
		{
			front = 0;
			back = 0;
			throw  new NoSuchElementException();
		}

		T item = queue[front];
		queue[front++] = null;

		return item;
	}

	public T peek() {
		if (front == back){
			throw new NoSuchElementException();
		}
		return queue[front];
	}

	public int size()
	{
		return back - front;
	}

	public boolean isEmpty()
	{
		return back == front;
	}


	public void printQueue()
	{

		StringJoiner sj = new StringJoiner(", ","[","]");

		for(T val : queue) {
			if (val != null) {
				sj.add(val.toString());
			}
		}

		System.out.println(sj.toString());

	}



}
