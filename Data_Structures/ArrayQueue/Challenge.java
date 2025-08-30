package ArrayQueue;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Stack.*;
public class Challenge {


	public static void main(String... args)
	{

		System.out.println(punctRemover("! Bishal .,, , .! A!dhikary!  "));
		System.out.println(punctRemover2(" @Bishal .! , A!dhikary .."));
		System.out.println(punctRemover3(" !@Bis,,,.al Adh!ikary! "));



//		Pattern p = Pattern.compile("[ \\p{Punct}]*");
//		Matcher m = p.matcher("B");
//		System.out.println(m.find());

		System.out.println("-".repeat(50));

		System.out.println(checkPalindromeString("Racecar"));
		System.out.println(checkPalindromeString("fsadass"));
		System.out.println(checkPalindromeString("iammaI"));


	}


	public static boolean checkPalindromeString(String str)
	{
		// Using both Stack and Queue data structures

		str = punctRemover2(str);
		StringBuilder reversedStr = new StringBuilder();
		char[] cArr = str.toCharArray();
		GenericLinkedStack<String> ls = new GenericLinkedStack<>();
		for(char val : cArr)
		{
			ls.push(String.valueOf(val));
		}

		for(int i = 0 ; i < cArr.length ; i++)
		{
			reversedStr.append(ls.pop());
		}

		//Now using queue to get the original str as is
		//even though it is unnecessary but for the practise of queue's we are still adding and removing from
		// the queue and still getting the original string without space and punctuations because
		//queue follows FIFO


		StringBuilder originalStr = new StringBuilder();
		CircularArrayQueue<String> caq = new CircularArrayQueue<String>(String.class,100);


		for(char val : cArr)
		{
			caq.add(String.valueOf(val));
		}
		for(int i = 0 ; i < cArr.length ; i++)
		{

			originalStr.append(caq.remove());
		}

		return originalStr.toString().equalsIgnoreCase(reversedStr.toString());



	}

	public static String punctRemover(String str)
	{
//		StringBuilder result = new StringBuilder();
		Pattern p = Pattern.compile("[ \\p{Punct}]+");
		Matcher m = p.matcher(str);

	// Test String : "  Bishal,.  !Adhikary ; "
		 while(m.find())
		 {
			 str = str.replaceFirst(m.group(),"");
		 }

		 return str;

	}


	public static String punctRemover2(String str)
	{
		Pattern p = Pattern.compile("[ \\p{Punct}]");
		Matcher m = p.matcher(str);

		//Test String : " !Bish al .,! . A!dhikary .. "
		while(m.find())
		{
		str = str.replace(m.group(),"");
		}

		return str;
	}



	public static String punctRemover3(String str)
	{
		return str.replaceAll("[ \\p{Punct}]+","");
	}
}

