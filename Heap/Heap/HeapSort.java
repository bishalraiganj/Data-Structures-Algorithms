package Heap;

import java.util.Arrays;

public class HeapSort {
	public static void main(String... args)
	{

		int[] intArr = {2,34,53,63,0,898,98,79,9,-9,-33,-2};

		heapSort(intArr);
		System.out.println(Arrays.toString(intArr));


	}


	public static void heapSort(int[] arr) {

		Heap<Integer> heap = new Heap<>(Integer.class, arr.length);


		for (int val : arr) {
			heap.insert(val);
		}


		heap.sort();


		int counter = 0;
		for (int val : heap.getHeap())
		{
		arr[counter++]	= val;
		}

//		System.arraycopy(heap.getHeap(),0,arr ,0,arr.length);


	}
}
