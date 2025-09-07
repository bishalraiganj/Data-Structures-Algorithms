package practise;

import java.util.Arrays;

public class BinarySearch2 {

	public static void main(String... args)
	{
		int[] intArr = {2,46,6,8,0,-3,5};
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));
		System.out.println(binarySearch(intArr,0,intArr.length,46,0));

	}



	public static int binarySearch(int[] arr,int start,int end, int searchVal,int recursionCounter)
	{
		if(end - start < 0 )
		{
			return -1;
		}

		if(recursionCounter == 0)
		{
			Arrays.sort(arr);
		}
		recursionCounter++;

		int mid = (end + start) / 2 ;

		if(arr[mid] == searchVal)
		{
			return mid;
		}
		else if( arr[mid] > searchVal)
		{
			return binarySearch(arr,start,mid,searchVal,recursionCounter);
		}
		else{
			return binarySearch(arr,mid+1,end,searchVal,recursionCounter);
		}

	}



}
