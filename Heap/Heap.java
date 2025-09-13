import java.lang.reflect.Array;

public class Heap<T extends Comparable<T>> {


	private T[] heap;
	private int size;


	public Heap(Class<T> clazz, int capacity)
	{
		heap =  (T[]) Array.newInstance(clazz,capacity);
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

	public void fixHeapAbove(int index)
	{

		T newValue = heap[index];
		if(heap[index].compareTo(heap[getParent(index)]) > 0   )
		{
			while(heap[index].compareTo(heap[getParent(index)])>0 && index > 0 )
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



}
