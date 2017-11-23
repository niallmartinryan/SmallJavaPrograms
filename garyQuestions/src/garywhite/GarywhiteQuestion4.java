package garywhite;

public class GarywhiteQuestion4 
{

	public static void main(String[] args) 
	{	int thousand = 1000;
		int remainder =0;
		int numberEntered = 436;
		int ifZero = numberEntered/ thousand;
		if (ifZero!=0)
		{	int numberOutput = 0;
			remainder = numberEntered ;
			int divider = thousand ;
			while (remainder>0 )
			{
				numberOutput = remainder/divider;
				remainder = remainder%divider ;
				divider = divider/10 ;
				System.out.print( numberOutput);
			}
		}
		else 
		{
			int numberOutput =0;
			remainder = numberEntered;
			int divider = thousand/10;
			while (remainder>0)
			{
				numberOutput = remainder/divider ;
				remainder =remainder%divider;
				divider = divider/10 ;
				System.out.print( numberOutput);
			}
		}

	}

}
