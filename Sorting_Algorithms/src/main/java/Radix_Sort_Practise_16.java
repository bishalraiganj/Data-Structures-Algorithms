import java.util.Arrays;

public class Radix_Sort_Practise_16 {


	public static void main(String... args)
	{
		int[] arr1 = {23,19,23,34,11,99,23,45};

		radixSort(arr1,10,2);

		System.out.println(Arrays.toString(arr1));

	}


	public static void radixSort(int[] arr, int radix,int width)
	{
		for(int i = 0 ; i < width ; i++)
		{
			radixSingleSort(arr,i,radix);
		}
	}




	public static void radixSingleSort(int[] arr,int indexFromEnd , int radix)
	{
		int[] frequencyAndPositionArr = new int[radix];
		int[] tempSortedArr = new int[arr.length];

		for(int val : arr)
		{
			frequencyAndPositionArr[getDigit(val,indexFromEnd,radix)]++;
		}

		//determining and storing the positions for each number digit wise in the freqAndPosArr
		for(int i = 1 ; i < frequencyAndPositionArr.length ; i++)
		{
			frequencyAndPositionArr[i] += frequencyAndPositionArr[i-1];
		}

		for(int  i =  arr.length - 1 ; i >= 0 ; i--)
		{
			tempSortedArr[(frequencyAndPositionArr[getDigit(arr[i],indexFromEnd,radix)]-- ) -1 ] = arr[i];
		}

		System.arraycopy(tempSortedArr, 0 , arr, 0 , tempSortedArr.length);
	}

	public static int getDigit(int num, int indexFromEnd,int radix)
	{
		return num / (int) Math.pow(10, indexFromEnd) % radix;
	}


}
