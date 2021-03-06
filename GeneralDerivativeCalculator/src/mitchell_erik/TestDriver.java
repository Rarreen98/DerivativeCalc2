package mitchell_erik;

import static mitchell_erik.calculus.derivativecalc.Derivative.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TestDriver
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String func = input.nextLine();
		
		ArrayList<String> test = regexChecker(func,"/(\\d|\\))(\\+|\\-)\\d+\\x\\^(\\d+|[s][i][n][(]|[c][o][s][(]|[t][a][n][(])/g");
		System.out.println(test);
		
		input.close();
	}
}