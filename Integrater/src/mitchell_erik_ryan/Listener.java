package mitchell_erik_ryan;

import static mitchell_erik_ryan.DefIntegrator.btnLeftRiemannSum;
import static mitchell_erik_ryan.DefIntegrator.btnMiddleRiemannSum;
import static mitchell_erik_ryan.DefIntegrator.btnRightRiemannSum;
import static mitchell_erik_ryan.DefIntegrator.btnSimpsonsRule;
import static mitchell_erik_ryan.DefIntegrator.deltaX;
import static mitchell_erik_ryan.Methods.leftRiemannSum;
import static mitchell_erik_ryan.Methods.middleRiemannSum;
import static mitchell_erik_ryan.Methods.rightRiemannSum;
import static mitchell_erik_ryan.Methods.simpsonsRule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptException;

public class Listener implements ActionListener
{
	public static double width;
	public void actionPerformed(ActionEvent e)
	{
		double lowerBound;
		double upperBound;
		width = Double.parseDouble(deltaX.getText());
		
		if(DefIntegrator.lowerBound.getText().equals(""))
			lowerBound = 0;
		else if(DefIntegrator.lowerBound.getText().equalsIgnoreCase("pi"))
			lowerBound = Math.PI;
		else if(DefIntegrator.lowerBound.getText().equalsIgnoreCase("e"))
			lowerBound = Math.E;
		else
			lowerBound = Double.parseDouble(DefIntegrator.lowerBound.getText());

		if(DefIntegrator.upperBound.getText().equals(""))
			upperBound = 1;
		else if(DefIntegrator.upperBound.getText().equalsIgnoreCase("pi"))
			upperBound = Math.PI;
		else if(DefIntegrator.upperBound.getText().equalsIgnoreCase("e"))
			upperBound = Math.E;
		else
			upperBound = Double.parseDouble(DefIntegrator.upperBound.getText());

		String inFunction = DefIntegrator.function.getText();
		try
		{
			if(btnLeftRiemannSum.isSelected())
			{
				DefIntegrator.result.setText(leftRiemannSum(inFunction, lowerBound, upperBound) + "");
				System.out.println("LRAM");
			}
			else if(btnRightRiemannSum.isSelected())	
			{
				DefIntegrator.result.setText(rightRiemannSum(inFunction, lowerBound, upperBound) + "");
				System.out.println("RRAM");
			}
			else if(btnMiddleRiemannSum.isSelected())
			{
				DefIntegrator.result.setText(middleRiemannSum(inFunction, lowerBound, upperBound) + "");
				System.out.println("MRAM");
			}
			else if(btnSimpsonsRule.isSelected())
			{
				DefIntegrator.result.setText(simpsonsRule(inFunction, lowerBound, upperBound) + "");
				System.out.println("Simpsons");
			}
		}
		catch (ScriptException e1)
		{
			e1.printStackTrace();
		}
	}

	public static String prepFunction(String function)
	{
		function = function.replaceAll("[c][o][s][(]", "Math.cos(");
		function = function.replaceAll("[s][i][n][(]", "Math.sin(");
		function = function.replaceAll("[t][a][n][(]", "Math.tan(");
		function = function.replaceAll("[s][e][c][(]", "1/Math.cos(");
		function = function.replaceAll("[c][s][c][(]", "1/Math.sin(");
		function = function.replaceAll("[c][o][t][(]", "1/Math.tan(");
		function = function.replaceAll("[e][u][l]", "Math.E");
		function = function.replaceAll("[p][i]", "Math.PI");
		System.out.println(function);
		return function;
	}
}