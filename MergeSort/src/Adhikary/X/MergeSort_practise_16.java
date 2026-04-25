public class Main{



	public static void main(String... args)
	{

		int[] arr1 = {342,242,5,1,51,5,62,2,-23};
		mergeSort(arr1);
		System.out.println(arr1.toString());
	}


	public static void mergeSort(int[] arr, start, end){


		if(end - start < 2) return;

		int mid = ( end  + start ) /2 ;

		mergeSort(arr,start,mid);
		mergeSort(arr,mid,end);

		merge(arr,start,mid,end);
	}

	public static void merge(int[] arr, int start, int mid, int end)
	{
		if( arr[mid-1] <= arr[mid]) return;

		int i = start;
		int j = mid;

		int tempArr = new int[end - start];
		int counter = 0;

		while( i < mid && j < end)
		{
			tempArr[counter++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}

		if( i < mid)
		{
			System.arraycopy(arr,i,arr,start+counter,mid-i);
		}

		System.arraycopy(tempArr,0,arr,start,counter);


	}






}