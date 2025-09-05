public class LinearSearch {


	public static void main(String... args)
	{
		int[] intArr = {2,56,6,-2,6,32,5,7,21};

		System.out.println(linearSearch(intArr,2));
		System.out.println(linearSearch(intArr,56));
		System.out.println(linearSearch(intArr,32));
		System.out.println(linearSearch(intArr,21));
		System.out.println(linearSearch(intArr,100));



	}




	public static int linearSearch(int[] arr, int val)
	{
		for(int i = 0; i < arr.length; i++)
		{
			if( arr[i] == val)
			{
				return i;
			}
		}

		return -1;
	}



}
