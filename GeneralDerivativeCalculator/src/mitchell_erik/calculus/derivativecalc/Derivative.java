package mitchell_erik.calculus.derivativecalc;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Derivative
{
	private static ArrayList<String> parts = new ArrayList<String>();

	private Derivative(){}

	public static String getDerivative(String function)
	{
		String result = null;

		return result;
	}

	public static ArrayList<String> parse(String input)
	{
		int section1 = 0, section2;
		String part;
		for(int i = 0; i < input.length(); i++)
		{
			if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'|| input.charAt(i) == '/'|| input.charAt(i) == '^')
			{
				section2 = i;
				part = input.substring(section1,section2);
				parts.add(part);
				parts.add(input.charAt(i) + "");
				section1=section2+1;
			}
		}
		parts.add(input.substring(section1));
		return parts;
	}
	
	public static ArrayList<String> regexChecker(String regex, String string)
	{
		ArrayList<String> result = new ArrayList<String>();
		Pattern checkRegex = Pattern.compile(regex);
		Matcher regexMatcher = checkRegex.matcher(string);
		
		while(regexMatcher.find())
		{
			if(regexMatcher.group().length() != 0)
				result.add(regexMatcher.group(1).trim());
		}
		return result;
	}
	
	public static ArrayList<String> getBetweenPara(String string)
	{
		ArrayList<String> result = new ArrayList<String>();
		Pattern checkRegex = Pattern.compile("\\((.*?)\\)");
		Matcher regexMatcher = checkRegex.matcher(string);
		
		while(regexMatcher.find())
		{
			if(regexMatcher.group().length() != 0)
				result.add(regexMatcher.group(1).trim());
		}
		return result;
	}
}