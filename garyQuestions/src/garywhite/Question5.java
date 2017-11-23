package garywhite;

public class Question5 
{
	public static final int CONSTANT_ADDITION = 3;
	public static void main(String[] args) 
	{	
		int currentNumber = 50;
		System.out.println(currentNumber);
		while (currentNumber<150)
		{
			currentNumber = currentNumber+ CONSTANT_ADDITION;
			if (currentNumber<150)
			{
				System.out.println (" "+ currentNumber);
			}
		}
	}
}
