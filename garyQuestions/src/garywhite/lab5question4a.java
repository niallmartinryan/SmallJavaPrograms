package garywhite;

public class lab5question4a 
{
	public static void main(String[] args) 
	{	int outputNumber = 0;
		int currentNumber = 0;
		int firstDivider = 5;
		int secondDivider = 7;
		int count =200;
		while (count<=500)
		{
			currentNumber =count%firstDivider ;
			if (currentNumber ==0)
			{
				currentNumber = count;
				currentNumber = currentNumber%secondDivider;
				if (currentNumber==0)
				{
					System.out.println(count+ " is a multiple by 5 and 7");
				}
			}
			count++;	
		}
	}
}
