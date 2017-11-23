
public class StarNumAndTriNum 
{	//	calculates when triangle numbers are equal to star numbers.
	
	public static void main(String[] args) 
	{
		int indexStarNumber = 1;
		int indexTriangleNumber= 1;
		System.out.println("These are both triangle and star numbers ");
		int starNumber = starNumberFunc (indexStarNumber);
		int triangleNumber =  triangleNumber (indexTriangleNumber);
		while (starNumber>0 )
		{
			if (starNumber == triangleNumber)
			{
				System.out.println(starNumber);
			}
			if (starNumber>triangleNumber)
			{
				indexTriangleNumber++;
				triangleNumber =  triangleNumber (indexTriangleNumber);
			}
			else
			{
				indexStarNumber++;
				 starNumber = starNumberFunc (indexStarNumber);
			}	
		}
	}
	
	public static int starNumberFunc (int indexStarNumber)
	{	
		int result = 0;
		result= 6*indexStarNumber*(indexStarNumber-1)+1;
		return result ;
	}
	public static int triangleNumber (int indexTriangleNumber)
	{ 	
		int result = indexTriangleNumber;
		while (indexTriangleNumber>1)
		{
			result= result+(indexTriangleNumber-1);
			indexTriangleNumber--;
			
		}
		return (result);
	}
}
