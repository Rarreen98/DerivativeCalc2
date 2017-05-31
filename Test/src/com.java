import java.io.File;
import java.io.IOException;

public class com
{
	public static void main(String[] args)
	{
		File test = new File("test.txt");
		try
		{
			test.createNewFile();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
