package Adhikary.X;

import java.util.Arrays;

public class Main {

	public static void main(String... args)
	{
		int[] intArr = {20,35,-15,7,55,1,-22};

		for(int firstUnsortedIndex = 1 ; firstUnsortedIndex < intArr.length ; firstUnsortedIndex++)
		{

			int newElement = intArr[firstUnsortedIndex];

			for(int i = firstUnsortedIndex - 1 ; i >= 0 ; i--)
			{
				if(intArr[i] <= newElement)
				{
					intArr[i+1] = newElement;
					break;
				}


				intArr[i+1] = intArr[i];

				if(i == 0) {  // We only need this when we are checking at the 0th position  of the sorted partition , and the newElement is still smaller ,
					// so there are no more iterations for the possibility of newElement  to be greater

					//because we will already be checking the last (0th index element of the sorted partition) and
					// at this position we must assign newElement
					intArr[i] = newElement;
				}
			}

		}

		System.out.println(Arrays.toString(intArr));


	}

}
