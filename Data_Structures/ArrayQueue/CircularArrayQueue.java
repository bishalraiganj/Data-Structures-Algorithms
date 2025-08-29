package ArrayQueue;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class CircularArrayQueue<T extends Object> {



	private T[] queue;
	private int front;
	private int back;
	private final Class<T> clazz;
	private int capacity;


	public CircularArrayQueue(Class<T> clazz,int capacity)
	{
		this.clazz = clazz;
		this.capacity = capacity;
		queue = (T[]) Array.newInstance(clazz,capacity);
	}



	public void add(T item)
	{
		if(size() == queue.length - 1)
		{
			int numOfItems = size();
			T[] newArray = (T[])  Array.newInstance(clazz,queue.length * 2);
			System.arraycopy(queue,front,newArray,0,queue.length-front);
			if(back < front) {
				System.arraycopy(queue, 0, newArray, queue.length - front, back);
			}
			queue = newArray;

			back = numOfItems;
			front = 0;


		}

		queue[back] = item;
		if(back < queue.length - 1)
		{
			back++;
		}
		else
		{
			back = 0;
		}

	}


	public int size()
	{

		if(front <= back)
		{
			return back - front;
		}
		else
		{
			return queue.length - (front - back);
		}
	}

	public T remove() {
		if (size() == 0) {
			throw new NoSuchElementException();
		}

		T r = queue[front];
		queue[front] = null;

		front++;

		if (size() == 0) {
			front = 0;
			back = 0;
		} else if (front == queue.length)
		{
			front=0;
		}

		return r;
	}


	public void printQueue()
	{

		StringJoiner sj = new StringJoiner(", ","[ "," ]");
		if(front < back)
		{
			for(int i = front; i < back ; i++)
			{
				sj.add(queue[i].toString());
			}
		}
		else
		{
			for(int i = front;i < queue.length ; i++)
			{
				sj.add(queue[i].toString());
			}
			for(int i = 0 ; i < back ; i++)
			{
				sj.add(queue[i].toString());
			}

		}

		System.out.println(sj.toString());
	}

	public String getFrontnBackIndex()
	{
		return front+","+back;
	}


}
