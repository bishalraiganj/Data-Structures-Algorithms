package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args) {


		int[] arr = {  20,12,2,4,5,19,6,21,22,23};

		quickSort(arr,0,arr.length);
		System.out.println(Arrays.toString(arr));

	}


	public static void quickSort(int[] arr, int start, int end) {

		if (end - start < 2) {
			return;
		}


		int pivotIndex = partition(arr, start, end);
		quickSort(arr, start, pivotIndex);
		quickSort(arr, pivotIndex + 1, end);

	}

	public static int partition(int[] arr, int start, int end)
	{


		int i = start;
		int j = end;

		int pivot = arr[start];
		while ( i < j )
		{

			while(i < j && arr[--j] >= pivot);

			if( i < j)
			{

				arr[i] = arr[j];

			}

			//{  20,12,2,4,5,19,6,21,22,23}  j = 6 , i = 6

			//{ 20 , 12,2,4,5,25 , 6 ,21,22,23} j = 5 , i = 5
			while( i < j && arr[++i] <= pivot);

			if ( i < j)
			{
				arr[j] = arr[i];
			}

		}


		arr[i] = pivot;
		return j;
	}



}
