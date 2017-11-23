import java.util.NoSuchElementException;
import java.util.Scanner; 
import javax.swing.JOptionPane ;
import java.lang.Math;
	/*	This program calculates the day that it is for a inputed date
	 * and outputs that day and date.
	*/
public class DayOutputDate 
{	public static final int	NUM_OF_DAYS_IN_APR_SEP_NOV_JUN = 30;
	public static final int NUM_OF_DAYS_FEB_NORMAL = 28;
	public static final int NUM_OF_DAYS_FEB_IN_LEAP_YEAR = 29;
	public static final int NUM_OF_DAYS_IN_MOST_MONTHS = 31;
	public static final int NUM_OF_MONTHS = 12;
	public static final String DAY_SEVEN = "Sunday";
	public static final String DAY_SIX = "Saturday";
	public static final String DAY_FIVE = "Friday";
	public static final String DAY_FOUR = "Thursday";
	public static final String DAY_THREE = "Wednesday";
	public static final String DAY_TWO = "Tuesday";
	public static final String DAY_ONE = "Monday";
	public static final String MONTH_TWELVE = "December";
	public static final String MONTH_ELEVEN = "November";
	public static final String MONTH_TEN = "October";
	public static final String MONTH_NINE = "September";
	public static final String MONTH_EIGHT = "August";
	public static final String MONTH_SEVEN = "July";
	public static final String MONTH_SIX = "June";
	public static final String MONTH_FIVE = "May";
	public static final String MONTH_FOUR = "April";
	public static final String MONTH_THREE= "March";
	public static final String MONTH_TWO = "February";
	public static final String MONTH_ONE = "January";
	public static void main(String[] args) 
	{	
		try {
				boolean isValidDate = true;
				String input = JOptionPane.showInputDialog("Enter date (day/month/year):");
				Scanner scanner = new Scanner(input);
				scanner.useDelimiter("/");
				int day = scanner.nextInt();
				int month = scanner.nextInt();
				int year = scanner.nextInt();
				if (validDate(day,month,year))
				{
				}
				else
				{
					JOptionPane.showMessageDialog(null,"This date is not valid" ," error" , JOptionPane.ERROR_MESSAGE);
					isValidDate = false ; 
				}
				if(isValidDate == true)
				{
					JOptionPane.showMessageDialog(null, dayOfTheWeek(day,month,year) + ", "
							+ day+ numberEnding(day)+ " " + monthName(month) + " "+ year);
				}
				scanner.close();
			}
		catch (NullPointerException exception)
		{
		}
		catch (NoSuchElementException exception)
		{
			
		}
	}
	public static boolean validDate (int day, int month, int year)
	{
		return ((year >= 0) && (month >= 1) && (month <= NUM_OF_MONTHS) &&
				(day >= 1) && (day <= daysInMonth( month, year )));
	}
	public static int daysInMonth( int month, int year )
	{
		int days_in_month = NUM_OF_DAYS_IN_MOST_MONTHS;
		switch (month)
		{
		case 2:
			days_in_month = isLeapYear( year ) ? NUM_OF_DAYS_FEB_IN_LEAP_YEAR :
														NUM_OF_DAYS_FEB_NORMAL;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days_in_month = NUM_OF_DAYS_IN_APR_SEP_NOV_JUN;
			break;
		default:
			days_in_month = NUM_OF_DAYS_IN_MOST_MONTHS;
			break;
		}
		return days_in_month;
	}
	public static boolean isLeapYear( int year )
	{
		return (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0));
	}
	public static String dayOfTheWeek (int day,int month, int year)
	{	int Y = year;
		String nameOfDay = " ";
		if(month==1||month==2)
		{
			Y=year-1;
		}
		
		int c = (Y/100);		//Algorithm 
		int y = (Y%100);
		int dayInNumber = (int)((day + Math.floor(2.6*(((month+9)%12)+1)-0.2)+(y)+Math.floor
				(y/4)+Math.floor((c)/4)-(2*(c)))%7);
		if ( dayInNumber<0)
		{
			dayInNumber= dayInNumber+7;
		}
		switch (dayInNumber)
		{
			case 0:	nameOfDay = DAY_SEVEN;
					break;
			case 1: nameOfDay = DAY_ONE;
					break;
			case 2: nameOfDay = DAY_TWO;
					break;
			case 3: nameOfDay = DAY_THREE;
					break;
			case 4: nameOfDay = DAY_FOUR;
					break;
			case 5: nameOfDay = DAY_FIVE;
					break;
			case 6: nameOfDay = DAY_SIX;
					break;
		}
		return nameOfDay ;
	}
	public static String numberEnding(int day)
	{	String outputString = " ";
		if (((day%100)/10)==1)
		{
			outputString= "th";
		}
		else
		{
			switch (day%10)
			{
			case 1:
					outputString = "st";
					break;
			case 2: 
					outputString = "nd";
					break;
			case 3: 
					outputString = "rd";
					break;
			default:
					outputString = "th";
					break;
			}
		}
		return	(outputString);
	}
	public static String monthName (int month)
	{	String monthOutput=" ";
		if(month<13&&month>0){
			switch (month)
			{
			case 1: 
					monthOutput= MONTH_ONE;
					break;
			case 2: 
					monthOutput= MONTH_TWO;
					break;
			case 3:
					monthOutput= MONTH_THREE;
					break;
			case 4:
					monthOutput = MONTH_FOUR;
					break;
			case 5:
					monthOutput = MONTH_FIVE;
					break;
			case 6:
					monthOutput =MONTH_SIX;
					break;
			case 7:
					monthOutput= MONTH_SEVEN;
					break;
			case 8:
					monthOutput= MONTH_EIGHT;
					break;
			case 9: 
					monthOutput = MONTH_NINE;
					break;
			case 10:
					monthOutput = MONTH_TEN;
					break;
			case 11:
					monthOutput= MONTH_ELEVEN;
					break;
			case 12:
					monthOutput = MONTH_TWELVE;
					break;
			}
		}
		return monthOutput;
	}

}
