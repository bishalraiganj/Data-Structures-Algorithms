package Heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap<T extends Comparable<T>> {


	private T[] heap;
	private int size;


	public Heap(Class<T> clazz, int capacity)
	{
		heap =  (T[]) Array.newInstance(clazz,capacity);
	}







	public void insertExact(T element)
	{
		if(isFull())
		{
			throw new ArrayIndexOutOfBoundsException("Heap is full");
		}
		else
		{
			heap[size++] = element;
		}

	}
	public void insert(T element)
	{
		if(isFull())
		{
			throw new ArrayIndexOutOfBoundsException("Heap is full");
		}

		heap[size] = element;

		fixHeapAbove(size);

		size++;



	}


	public void fixHeapBelow(int index)
	{
		fixHeapBelow(index,heap[index]);
	}

	public void fixHeapBelow(int index,T val)
	{
		int lcIndex  = 2 * index + 1;
		int rcIndex = 2 * index + 2;

		if( lcIndex < size && rcIndex <= size) {
			T leftChild = heap[2 * index + 1];
			T rightChild = heap[2 * index + 2];

			T greatest;
			int greatestIndex;
			if (leftChild.compareTo(rightChild) >= 0)
			{
				greatest = leftChild;
				greatestIndex = lcIndex;
			}
			else
			{
				greatest = rightChild;
				greatestIndex = rcIndex;
			}

			if (greatest.compareTo(val) > 0) {
				heap[index] = greatest;
				index = greatestIndex;
				fixHeapBelow(index,val);
			}
			else
			{
				heap[index] = greatest;
			}

		}
		else {
			heap[index] = val;
		}

	}

	public void fixHeapAbove(int index) // Heapify
	{

		T newValue = heap[index];
		if(heap[index].compareTo(heap[getParent(index)]) > 0   )
		{
			while(newValue.compareTo(heap[getParent(index)])>0 && index > 0 )
			{
				heap[index] = heap[getParent(index)];
				index = getParent(index);
			}

			heap[index] = newValue;
		}

	}

	public int getParent(int index)
	{
		return (index - 1) / 2;
	}


	public boolean isFull()
	{
		return size == heap.length;
	}

	public void printHeap()
	{
		for(T val: heap)
		{
			if(val != null)
			{
				System.out.print(val + ",");
			}
		}
	}


}
