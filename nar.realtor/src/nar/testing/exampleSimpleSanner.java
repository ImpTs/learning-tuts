package nar.testing;
import java.util.Scanner;

public class exampleSimpleSanner {
	private static Scanner fromStr;

	//https://www.youtube.com/watch?v=3RSXHVyzdmg

	public static void main (String args[])
	{
		fromStr = new Scanner("Josh 18 Phil 26 Sally 22 Molly 17");
		fromStr.useDelimiter("[^0-9]+");
		System.out.println("The words in the String are: ");

		while(fromStr.hasNext() )
		{
			String temp = fromStr.next();
			System.out.println(temp);
		}
	}
}
