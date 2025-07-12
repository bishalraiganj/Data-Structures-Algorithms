package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args) {

		int[] intArray = {20, 35, -15, 7, 55, 1, -22};


		mergeSort(intArray,0,intArray.length);
		System.out.println(Arrays.toString(intArray));
	}


	// { 20 , 35 , -15 , 7 , 55 , 1 , -22 }
	public static void mergeSort(int[] input, int start, int end) {

		int mid = (start + end) / 2;

		if ( end - start < 2)
		{
			return;
		}
		mergeSort(input, start, mid);
		mergeSort(input, mid, end);
		merge(input, start, mid, end);

	}

	// { 20 , 35 , -15 , 7 , 55 , 1 , -22 }
	public static void merge(int[] input, int start, int mid, int end)
	{
		if(input[mid-1] <= input[mid])
		{
			return ;
		}

		int i = start;
		int j = mid ;

		int tempIndex = 0;
		int[] tempArr = new int[end - start];

		// { 31, 32 } {33,34}
		while(i < mid && j < end)
		{
			tempArr[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];

		}

		// { 31,34} {32,33}

		System.arraycopy(input, i , input, start + tempIndex , mid - i );
		System.arraycopy(tempArr,0,input, start  , tempIndex);







	}


}
