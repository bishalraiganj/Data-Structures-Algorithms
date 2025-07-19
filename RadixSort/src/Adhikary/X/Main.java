package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args)
	{

		int[] arr = {2454,2224,5644,7565,2356,5747}; // radix/ base =10 , width = 4 , stable CountingSort used

		radixSort(arr,10,4);
		System.out.println(Arrays.toString(arr));



	}



	public static void radixSort(int[] arr , int radix , int width)
	{
		for(int i = 0 ; i < width ; i++ )
		{
			radixSingleSort(arr,i,radix);
		}

	}




	public static void radixSingleSort(int[] inputArr , int position, int radix)
	{

		int numInts = inputArr.length;

		int[] countArr = new int[radix];

		for(int value : inputArr  )
		{
			countArr[getDigit(position,value,radix)]++;
		}

		// now in the following countArr will store the last index+1 of the value in the original input array that is represented by its index

		for(int j = 1 ; j < radix ; j++ )
		{
			countArr[j] += countArr[j - 1 ];
		}

		int[] tempArr = new int[numInts];

		for(int i = numInts- 1 ; i >= 0 ; i--)
		{
			tempArr[--countArr[getDigit(position,inputArr[i],radix)]] = inputArr[i];
		}

		System.arraycopy(tempArr,0 ,inputArr , 0 , numInts);

	}




	public static int getDigit(int position , int value , int radix)
	{
		return ( value / (int) Math.pow(10,position) ) % radix ;
	}






}
