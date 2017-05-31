package mitchell_erik_ryan.com.math;

import static mitchell_erik_ryan.com.math.Tokens.*;

import java.util.ArrayList;
import java.util.Scanner;

import mitchell_erik_ryan.com.general.Wrapper;


public class Shunter
{
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String func = input.nextLine();
		input.close();
		ArrayList<Wrapper> result = (getTokens(func));
		for(Wrapper curr : result)
			System.out.print(curr + "  ");
	}
	
	public static ArrayList<Wrapper> getTokens(String func)
	{
		String unTokened[] = func.split("\\s");
		ArrayList<Wrapper> result = new ArrayList<Wrapper>();
		for(String curr : unTokened)
		{
			if(curr.matches("\\d+"))
				result.add(new Wrapper(Double.parseDouble(curr)));
			else if(curr.equals("+"))
				result.add(new Wrapper(add));
			else if(curr.equals("-"))
				result.add(new Wrapper(sub));
			else if(curr.equals("*"))
				result.add(new Wrapper(mul));
			else if(curr.equals("/"))
				result.add(new Wrapper(div));
			else if(curr.equals("^"))
				result.add(new Wrapper(pow));
			else if(curr.equals("e^"))
				result.add(new Wrapper(exp));
			else if(curr.equals("sin"))
				result.add(new Wrapper(sin));
			else if(curr.equals("cos"))
				result.add(new Wrapper(cos));
			else if(curr.equals("tan"))
				result.add(new Wrapper(tan));
			else if(curr.equals("sec"))
				result.add(new Wrapper(sec));
			else if(curr.equals("csc"))
				result.add(new Wrapper(csc));
			else if(curr.equals("cot"))
				result.add(new Wrapper(cot));
			else if(curr.equals("log"))
				result.add(new Wrapper(log));
			else if(curr.equals("x"))
				result.add(new Wrapper(x));
			else if(curr.equals("("))
				result.add(new Wrapper(sta));
			else if(curr.equals(")"))
				result.add(new Wrapper(end));
		}
		return result;
	}
}