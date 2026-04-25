import java.util.Arrays;

public class Quick_Sort_Practise_16 {

	public static void main(String... args)
	{
		int[] arr1 = {212,43,5,57,-2,0,-223,-3,904};
		quickSort(arr1,0,arr1.length);
		System.out.println(Arrays.toString(arr1));
	}


	public static void quickSort(int[] arr, int start, int end)
	{
		if(end -  start  < 2) return;

		int pivotSortedIndex  = quickSortPivot(arr,start,end);

		quickSort(arr,start,pivotSortedIndex);
		quickSort(arr,pivotSortedIndex+1,end);
	}

	public static int quickSortPivot(int[] arr, int start, int end)
	{
		int pivot = arr[start];

		int i = start;
		int j = end;

		while(i<j)
		{
			while( i<j && arr[--j] >= pivot);
			if( i < j )
			{
				arr[i] = arr[j];
			}
			while(i<j && arr[++i] <= pivot);
			if(i < j )
			{
				arr[j++] = arr[i];
			}
		}

		arr[start] = pivot;
		return j;
	}


}
