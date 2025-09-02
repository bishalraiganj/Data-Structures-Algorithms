package BucketSort;

import java.lang.reflect.Array;
import java.util.*;

public class BucketSort {


	public static void main(String... args)
	{

		int[] intArr = {23,54,53,22,56,12,42,56,21,66,23};
		bucketSort(intArr,10);
		System.out.println(Arrays.toString(intArr));



	}


	public static void bucketSort(int[] arr,int capacity)
	{
		LinkedList<Integer>[] buckets  = new LinkedList[capacity];



		for(int i = 0 ; i < capacity ; i++)
		{
			buckets[i] = new LinkedList<>();
		}


		for(int val : arr)
		{
			buckets[hashValue(val,capacity)].add(val);

		}

		for(LinkedList<Integer> bucket : buckets)
		{
			bucket.sort(Integer::compareTo);
			//Alternative
//			bucket.sort(Comparator.comparing((val)->{ // This lambda is key extractor function functional interface with apply() SAM
//				return val;
//			}));
		}

		int j = 0;
		for(int i = 0 ; i < capacity ; i++)
		{

		Iterator<Integer> it =  buckets[i].listIterator();
			while(it.hasNext())
			{
				arr[j++] = it.next();
			}
		}

	}

	public static int hashValue(int val,int capacity)
	{
		return (val / 10 ) % capacity;
	}


}
