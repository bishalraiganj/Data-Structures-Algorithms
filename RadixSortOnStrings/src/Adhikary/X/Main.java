package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args)
	{

		String[] arr = {"bcdef","dbaqc","abcde","omadd","bbbbb"};

		radixSort(arr,26,5);

		System.out.println(Arrays.toString(arr));

	}

	public static void radixSort(String[] arr,int radix , int width)
	{

		for(int i = 0 ; i < width ; i++)
		{
			radixSingleSort(arr,i,radix);
		}

	}

	public static void radixSingleSort(String[] arr, int position , int radix) // Radix value is 26 because there are 26 small letters
	{


		int[] countArr = new int[radix];
		for(String value : arr)
		{


			countArr[getAscii(value.charAt(value.length()-position-1)) - 97]++; // we subtracted 65 because char 'a' is 65
			// , so in order to get index 0 for 'a'
			// ,  we have to subtract , and so 65 is the min value


		}

//		System.out.println(Arrays.toString(countArr));




		for(int j  = 1 ; j < radix ; j++)
		{
			countArr[ j ] += countArr[ j - 1 ]  ;
		}
//		System.out.println(Arrays.toString(countArr));


		int counter = 0 ;
		String[] tempArr  = new String[arr.length];

		for(int i = arr.length -1 ; i >= 0 ; i--)
		{

			tempArr[(countArr[getAscii(arr[i].charAt(arr[i].length()-position-1))- 97]--) - 1] = arr[i];


		}

//		System.out.println(Arrays.toString(tempArr));

		System.arraycopy(tempArr,0, arr,0,tempArr.length);





	}

	public static int getAscii(char c) // Returns the Ascii equivalent ( 65-90) for all a-z small letters
	{
		return  c;
	}








}
