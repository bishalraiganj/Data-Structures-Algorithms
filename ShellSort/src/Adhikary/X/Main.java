package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args)
	{
		int[] intArr = {20,35,-15,7,55,1,-22};

		for(int gap = intArr.length/2 ; gap > 0 ; gap /= 2)
		{
			for(int i = gap; i < intArr.length ; i++)
			{
				int newElement = intArr[i];
				int j  ;

				for(j = i; j > 0 && intArr[j - gap] > newElement  ; j -= gap)
				{
					intArr[j] = intArr[j - gap];
				}
				intArr[j ] = newElement;



			}

		}




		System.out.println(Arrays.toString(intArr));
	}

}
