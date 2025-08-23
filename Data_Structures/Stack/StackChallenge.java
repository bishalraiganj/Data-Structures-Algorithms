package Stack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackChallenge {



	public static void main(String... args)
	{



		System.out.println(punctuationRemover("I did, Did I? "));

		String s1 = "Bis..,ha, l ., Ad?hi..kary?!,";
		String s2= punctuationRemover(s1);
		System.out.println("Before punct removal : " + s1);
		System.out.println("After punct removal: " + s2);
		System.out.println(s2.length());
		System.out.println(punctuationRemover("I did, Did I? "));

		System.out.println("-".repeat(50));

		System.out.println(punctuationRemover("I did, Did I? "));


		System.out.println(palindromeChecker("iammai"));

		System.out.println(palindromeChecker("I did,  ... Did I?"));

		System.out.println(palindromeChecker("abccba"));

		System.out.println(palindromeChecker("Was it a car or a cat I saw ?"));
		System.out.println(palindromeChecker("affa sada"));
		System.out.println(palindromeChecker("oppo"));

//		System.out.println(checkForPalindrome("abccba"));
//		// should return true
//		System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
//		// should return false
//		System.out.println(checkForPalindrome("I did, did I?"));
//		// should return true
//		System.out.println(checkForPalindrome("hello"));
//		// should return false
//		System.out.println(checkForPalindrome("Don't nod"));


	}


	public static boolean palindromeChecker(String str)
	{
		str = punctuationRemover(str);
		GenericLinkedStack<Character> ls = new GenericLinkedStack<>();

		char[] arr = str.toCharArray();
		for(char c : arr)
		{

			ls.push(c);
		}

		String reversedStr = "";

		for(int i = 0 ; i < arr.length ; i++)
		{
			reversedStr += ls.pop();
		}

		return reversedStr.equalsIgnoreCase(str);

	}




	public static String punctuationRemover(String str)
	{

		//The following pattern removes punctuation and space only
//		Pattern p = Pattern.compile("([ \\p{Punct}])");
//		Matcher m = p.matcher(str);
//
//		while(m.find())
//		{
//			str = str.replace(m.group(1	),"");
//		}

		//Can be replace with the following logic
		str = str.replaceAll("[ \\p{Punct}]","");
		return str;

	}






}
