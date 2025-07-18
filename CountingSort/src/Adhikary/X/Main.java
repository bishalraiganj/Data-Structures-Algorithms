package Adhikary.X;

import java.util.Arrays;

public class Main
{

	public static void main(String... args)
	{

		int[] arr = { 2,3,5,6,3,6,7,3,8,9,10};

		countSort(arr,1,10);
		System.out.println(Arrays.toString(arr));

	}



	public static void countSort(int[] arr, int min, int max)
	{

		int[] countArr  = new int[max - min + 1 ];


		for(int i = 0 ; i < arr.length ; i++)
		{
			countArr[arr[i] - min]++;
		}

		int j = 0;

		for( int i = min ; i <= max ; i++)
		{

			while(countArr[i - min] > 0)
			{
				arr[j++] = i;
				countArr[i - min]--;

			}

		}
	}

}
