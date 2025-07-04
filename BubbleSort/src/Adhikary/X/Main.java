package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args)
	{

		int[] intArr = { 20,35,-15,7,55,1,-22 };

		int[] sortedIntArr = bubbleSort(intArr);

		System.out.println(Arrays.toString(sortedIntArr));



	}


	private static int[] bubbleSort(int[] intArr)
	{
		for(int lastUnsortedIndex = intArr.length - 1 ; lastUnsortedIndex > 0 ; lastUnsortedIndex--)
		{
			for(int i = 0 ; i < lastUnsortedIndex ; i++)
			{
				swap(intArr , i , i + 1);
			}
		}
		return intArr;
	}



	private static void swap(int[] arr, int i , int j)
	{
		if(i == j)
		{
			return;
		}
		else if(arr[i] > arr[j]) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}


}
