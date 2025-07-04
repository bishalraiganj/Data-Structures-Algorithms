package Adhikary.X;

public class Main {

    public static void main(String... args)
    {

        int[] intArray = {20,35,-15,7,55,1,-22};

        int index = 0;
        for(int i = 0 ; i <intArray.length ; i++)
        {
            if(intArray[i] == 7)
            {
//            System.out.println("index = " + i);
            index = i ;
                break;
            }
        }

        System.out.println("index = " + index);




    }
}
