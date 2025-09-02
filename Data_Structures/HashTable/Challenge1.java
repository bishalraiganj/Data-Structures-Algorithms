package HashTable;

import java.util.Arrays;

public class Challenge1 {


	public static void main(String... args)
	{

		int[] backingArr = new int[10];
		int[] exArr = {5982,43,6894,500,99,-58};


		for(int val:exArr)
		{
			backingArr[hashValue(val)]=val;
		}



		System.out.println(Arrays.toString(backingArr));
		System.out.println(backingArr[hashValue(-58)]);



	}


	public static int hashValue(int val)
	{

		return  Math.abs(val) % 10;
	}
}
