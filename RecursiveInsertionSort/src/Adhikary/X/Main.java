package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args)
	{


		int[] intArr = {2,45,64,6,34,2,1,-23,-34};

		int[] arr = {20,35,-15,7,55,1,-22};
		insertionSort(intArr);
		System.out.println(Arrays.toString(intArr));


		System.out.println("-".repeat(50));
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));

		System.out.println("-".repeat(50));

		int[] arr1 = {-132,43,56,64,6,2,3,-2};
		recursiveInsertionSort(arr1,1);
		System.out.println("Recursive Test : " + Arrays.toString(arr1));




	}

	public static void recursiveInsertionSort(int[] arr,int firstUnsortedIndex)
	{
		//Base Case / Breaking Condition
         if(firstUnsortedIndex > arr.length-1)
		 {
			 return;
		 }

		 singleSort(arr,firstUnsortedIndex);


		 firstUnsortedIndex++;
		 recursiveInsertionSort(arr,firstUnsortedIndex);



	}

	public  static void singleSort(int[] arr, int firstUnsortedIndex)
	{
		int k = firstUnsortedIndex;
		int temp = arr[firstUnsortedIndex];
		while(k > 0 && temp < arr[k-1])
		{

			arr[k ] = arr[k - 1 ];
			--k;
		}

		arr[k] = temp;


	}




// Non-recursive sequential insertionSort
	public static void insertionSort(int[] arr)
	{
		for(int j = 1 ; j < arr.length ; j++)
		{
			int k = j;
			int temp = arr[j];

			while(k-1 >= 0 && temp < arr[k-1] ) // I have to check until k = 1 or k- 1 == 0
			{
				arr[k] = arr[k-1];
				--k;
			}
			arr[k] = temp;
		}
	}




}
