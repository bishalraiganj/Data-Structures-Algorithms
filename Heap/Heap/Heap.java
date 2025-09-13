package Heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Heap<T extends Comparable<T>> {


	private T[] heap;
	private int size;


	public Heap(Class<T> clazz, int capacity)
	{
		heap =  (T[]) Array.newInstance(clazz,capacity);
	}





	public T[] getHeap()
	{
		return heap;
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


	public T delete(T element)
	{
		int index = -1;
		T deletedElement = null ;
		for(int i = 0; i < size; i++)
		{
			if(heap[i].compareTo(element) == 0)
			{
				index = i;
				deletedElement = heap[index];
				break;
			}
		}

		if(index == -1)
		{
			throw new NoSuchElementException("Element not found");
		}
		else
		{
			T replacement = heap[size - 1];

			heap[size - 1 ] = null;

			heap[index] = replacement;
			size--;
			fixHeapAbove(index);
			fixHeapBelow(index);
		}

		return deletedElement;
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
			if(rightChild == null)
			{
				greatest  = leftChild;
				greatestIndex = lcIndex;
			}
			else if (  leftChild.compareTo(rightChild) >= 0)
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

	public void sort() {
		int lastHeapIndex = size - 1;
		for (int i = 0; i < lastHeapIndex; i++)
		{
			T tmp = heap[0];
			heap[0] = heap[lastHeapIndex- i];
			heap[lastHeapIndex - i] = tmp;

			fixHeapBelow(0,lastHeapIndex - i - 1);



		}





	}


	public void fixHeapBelow(int index, int lastHeapIndex)
	{
		int childToSwap;


		while( index <= lastHeapIndex )
		{
			int leftChild = getChild(index,true);
			int rightChild = getChild(index,false);

			if(leftChild <= lastHeapIndex) {
				if (rightChild > lastHeapIndex) {
					childToSwap = leftChild;
				} else {
					childToSwap = (heap[leftChild].compareTo(heap[rightChild]) > 0 ? leftChild : rightChild);
				}

				if (heap[index].compareTo(heap[childToSwap]) < 0)
				{
					T temp = heap[index];
					heap[index] = heap[childToSwap];
					heap[childToSwap] = temp;
				}
				else
				{
					break;
				}

				index = childToSwap;


			}
			else
			{
				break;
			}
		}
	}


	public int getChild(int index,boolean left)
	{
		return  2 * index + (left? 1 : 2);
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


	public T peek() {
		if (isEmpty())
		{
			throw new NoSuchElementException("Heap is empty");
		}

		return heap[0];
	}

	public boolean isEmpty()
	{
		return size == 0;
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
