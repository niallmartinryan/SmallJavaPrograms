import java.util.Scanner;


public class eTestCorrection {

	public static void main(String[] args) {
		try{
		System.out.print("Please enter the percentages of the class(separated by a space)");
		Scanner scanner = new Scanner (System.in);
		double [] percentageArray = new double [5];
		for(int index=0;index<percentageArray.length;index++)
		{
			double nextPercentage = scanner.nextInt();
			percentageArray[index] = nextPercentage;
		}
		System.out.print("The average percentage was :");
		System.out.print(countAboveAverageStudents (percentageArray, averageMark (percentageArray)));
		scanner.close();
		}
		catch (ArrayIndexOutOfBoundsException exception)
		{
			System.out.print("Please enter only 5 percentages");
		}
	}

	public static double averageMark ( double [] percentageArray)
	{	
		double total = 0;
		double averageMarkInTotal = 0;
		for (int index=0;index<percentageArray.length;index++)
		{
			total = percentageArray [index] +total;
		}
		averageMarkInTotal = total/5;
		return	averageMarkInTotal;
	}

	public static int countAboveAverageStudents (double [] percentageArray ,double averageMark )
	{	
		double averageMarkInTotal = 0;
		averageMarkInTotal= averageMark (percentageArray) ; 
		System.out.println(averageMarkInTotal);
		int studentsAboveAverage = 0;
		for (int index=0; index<percentageArray.length;index++ )
		{
			if(percentageArray[index] > averageMarkInTotal)
			{
				studentsAboveAverage+= 1;
			}
		}
		System.out.println("The number of Students above the average was :");
		return studentsAboveAverage ;
	}
}
