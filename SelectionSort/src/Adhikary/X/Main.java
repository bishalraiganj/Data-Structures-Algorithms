package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args)
	{
		int[] intArr = {20,35,-15,7,55,1,-22};


		int[] sortedIntArr = selectionSort(intArr);

		System.out.println(Arrays.toString(sortedIntArr));


	}

	private static void swap(int[] arr, int i , int j)
	{
		if(i == j)
		{
			return ;
		}

		else if(arr[i] > arr[j])
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}


	private static int[] selectionSort(int[] arr )
	{
		for(int lastUnsortedIndex = arr.length - 1 ; lastUnsortedIndex > 0 ; lastUnsortedIndex--)
		{
			int largestIndex = 0;

			for(int i = 1 ; i < lastUnsortedIndex ; i++)
				{
						if(arr[largestIndex] < arr[i])
						{
							largestIndex = i;
						}

				}
			swap(arr,largestIndex,lastUnsortedIndex);
		}

		return arr;
	}



}
