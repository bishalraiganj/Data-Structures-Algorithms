package Stack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackChallenge {



	public static void main(String... args)
	{


		String s1 = "Bishal ., Adhikary !,";
		String s2= punctuationRemover(s1);
		System.out.println("Before punct removal : " + s1);
		System.out.println("After punct removal: " + s2);
		System.out.println(s2.length());


	}


	public static boolean palindromeChecker(String str)
	{




return true;
	}

	public static String punctuationRemover(String str)
	{

		//The following pattern removes punctuation and space only
		Pattern p = Pattern.compile("([ \\p{Punct}])+");
		Matcher m = p.matcher(str);

		while(m.find())
		{
			str = str.replace(m.group(),"");
		}

		return str;

	}






}
