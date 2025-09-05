import java.util.Arrays;

public class BinarySearch {



	public static void main(String... args)
	{
		//  0    1    2   3  4  5  6  7   8  9  10  11  12  13   14   15   16
		// -35, -24, -3, -2, 1, 3, 5, 6,  7, 7, 32, 32, 34, 63,  63,  63,  77
		int[] intArr = {1,34,5,32,6,63,7,32,7,3,77,-24,63,63,-3,-35,-2};
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));

					                        //  (0) (1)  (2)  (3) (4)  (5)
//		int[] intArr = { 1 ,4 ,63 ,5 ,6 ,2 }; // 1   2    4    5   6    63

		System.out.println(binarySearch(intArr,63,0,intArr.length,0));




	}

	public static int binarySearch(int[] arr,int searchVal,int start,int end,int recursionTrackCounter)
	{
		int recursionCounter = recursionTrackCounter;
		if(recursionCounter==0)
		{

			Arrays.sort(arr);
		}
		recursionCounter++;

		if(end - start < 1)
		{
			System.out.println("recursion counter value : "+ recursionCounter);
			return -1;
		}

		int mid = (start + end ) / 2;

		if(arr[mid] == searchVal)
		{
			System.out.println("recursion counter value : "+ recursionCounter);

			return mid;
		}
		else if(arr[mid] > searchVal)
		{

		return	binarySearch(arr,searchVal,start,mid,recursionCounter);

		}
		else{
			return binarySearch(arr,searchVal,mid + 1 , end,recursionCounter);
		}

	}


}
