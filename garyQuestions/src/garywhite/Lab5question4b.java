package garywhite;

public class Lab5question4b 
{

	public static void main(String[] args) 
	{	
		int outputNumber = 0;
		int currentNumber = 0;
		int firstDivider = 5;
		int secondDivider = 7;
		int count =200;
		while (count<=500)
		{
			currentNumber =count%firstDivider ;
			if (currentNumber ==0)
			{	
				System.out.println(count);
			}
			else 
			{
				currentNumber=count%secondDivider;
				if (currentNumber==0)
				{
					System.out.println(count);
				}
			}
			count++;	
		}
	}
	
}

			
			
	
