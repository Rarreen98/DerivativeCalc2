package mitchell_erik.calculus.function;

import java.util.ArrayList;
import java.util.Scanner;

public class FunctionTokens
{
	private ArrayList<String> tokens;
	
	public FunctionTokens(String numerator, String denominator)
	{
		Scanner split = new Scanner(numerator);
		
		split.close();
	}
	
	public FunctionTokens(String numerator)
	{
		
	}

	public ArrayList<String> getTokens()
	{
		return tokens;
	}
}