package ArrayQueue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {


	public static void main(String... args)
	{

		System.out.println(punctRemover("! Bishal .,, , .! A!dhikary!  "));
		System.out.println(punctRemover2(" @Bishal .! , A!dhikary .."));
		System.out.println(punctRemover3(" !@Bis,,,.al Adh!ikary! "));


//		Pattern p = Pattern.compile("[ \\p{Punct}]*");
//		Matcher m = p.matcher("B");
//		System.out.println(m.find());
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

