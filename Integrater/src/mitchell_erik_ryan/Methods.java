package mitchell_erik_ryan;

import static mitchell_erik_ryan.DefIntegrator.*;
import static mitchell_erik_ryan.Listener.prepFunction;
import static mitchell_erik_ryan.Listener.width;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JTextArea;

public class Methods
{
	public static double simpsonsRule(String function, double lower, double upper) throws ScriptException
	{
		int total = 0;
		int counter = 1;

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		System.out.println(lower + "\t" + upper);

		function = prepFunction(function);
		engine.put("x" , lower);
		total += ((Number) engine.eval(function)).doubleValue();

		for(double x = lower + width; x < upper; x += width)
		{
			engine.put("x", x);
			if(counter % 2 == 1)
				total += (4 * ((Number) engine.eval(function)).doubleValue());
			else
				total += (2 * ((Number) engine.eval(function)).doubleValue());
			counter++;
		}

		engine.put("x", upper);
		total += ((Number) engine.eval(function)).doubleValue();

		return (total / 3) * width;
	}

	public static double leftRiemannSum(String function, double lower, double upper) throws ScriptException
	{
		int total = 0;

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
			
		function = prepFunction(function);
		for(double x = lower; x <= upper; x += width)
		{
			System.out.println(x);
			engine.put("x", x);
			total += ((Number) engine.eval(function)).doubleValue();
		}
		return total * width;
	}

	public static double rightRiemannSum(String function, double lower, double upper) throws ScriptException
	{
		int total = 0;

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		System.out.println(lower + "\t" + upper);	
		function = prepFunction(function);
		for(double x = lower + width; x <= upper; x += width)
		{
			engine.put("x", x);
			total += ((Number) engine.eval(function)).doubleValue();
		}
		return total * width;
	}

	public static double middleRiemannSum(String function, double lower, double upper) throws ScriptException
	{
		return (leftRiemannSum(function, lower, upper) + rightRiemannSum(function, lower, upper)) / 2;
	}
}