package mitchell_erik_ryan.com.general;

import mitchell_erik_ryan.com.math.Tokens;

public class Wrapper
{

	public final double num;
	public final Tokens token;
	
	public Wrapper(Tokens token)
	{
		this.token = token;
		num = Double.NEGATIVE_INFINITY;
	}
	
	public Wrapper(double num)
	{
		this.num = num;
		token = null;
	}
	
	public String toString()
	{
		if(num == Double.NEGATIVE_INFINITY)
			return token + "";
		return num + "";
	}
}