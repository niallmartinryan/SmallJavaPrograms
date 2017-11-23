import java.util.Scanner;
public class sieveGraphic {
	public static final int HEIGHT_CANVAS = 512;
	public static final int WIDTH_CANVAS = 512;
	public static void main(String[] args) {
		try{
	
			int n;
			System.out.print("please enter the maximum integer that primes are to be found");
			Scanner input = new Scanner(System.in);
			n = input.nextInt();
			int numberEntries =2;
			int count = 0;
			int[] primeArray = new int [n-1];										// 
			while (count<=n-2){														// starting primes at 2 
				if(numberEntries<=n){
					primeArray[count]=numberEntries;
				}
				count++;
				numberEntries++;
			}
			createSquares(gridCalculator(n),n);
			findPrimes(n,primeArray);
			printNumbers(primeArray);
			//gridCalculator(n);
			
		}
		catch(java.util.InputMismatchException exception)
		{
			System.out.println("please enter a valid integer");
			main(args);
		}
	}
	public static void findPrimes(int n,int []primeArray)
	{	int currentPrime =2;
	int counter =0;
	boolean NextPrime = false;
	while(currentPrime*currentPrime<=n){
		while(NextPrime==false){
			if (counter==0 && currentPrime==2){
				currentPrime=2;
				NextPrime=true;
			}
			else if (currentPrime!=primeArray[counter]&&primeArray[counter]!=0){
				currentPrime=primeArray[counter];
				NextPrime=true;
			}
			counter++;
		}
		NextPrime=false;
		if (currentPrime*currentPrime>n){

		}
		else{markOffMultiples(primeArray,n, currentPrime);}
	}
	//printNumbers(primeArray);
	}
	public static void markOffMultiples(int[]primeArray,int n,int currentPrime)
	{ 	int currentMultiples=0;
	int counterMultiplier=2;
	while (currentMultiples<=(n-currentPrime)){
		currentMultiples= counterMultiplier*currentPrime;
		primeArray[currentMultiples-2]=0;	// -2 because we skip 0 and 1 in the array of primes
		
		counterMultiplier++;
	}
	counterMultiplier =2;
	}
	
	
	
	
	
	public static void createSquares( int gridCalculator, int n){
		StdDraw.setCanvasSize(HEIGHT_CANVAS,WIDTH_CANVAS);
		StdDraw.setScale(0, HEIGHT_CANVAS);
		int sizeGrid = gridCalculator(n);
		double lengthSquare=(HEIGHT_CANVAS/sizeGrid);
		StdDraw.square(lengthSquare/2, HEIGHT_CANVAS-(lengthSquare/2), lengthSquare/2);
		//int sizeGrid = gridCalculator(n);
		/*double setStartingPoint = 100/(sizeGrid+1);
		double gridXPoint=setStartingPoint/100;
		double gridYPoint=(setStartingPoint/100);
		StdDraw.setCanvasSize(512,512);
		double offset = (1*.20)/(sizeGrid+1);
		int columnCounter =1;
		double xCoord=gridXPoint;
		double yCoord=1-(gridYPoint);
		//double lengthSquare=(1/sizeGrid);
		xCoord+=gridXPoint;
		for(int count=0;count<=n-2;count++){
			if ((columnCounter)>=sizeGrid){
				yCoord=yCoord-(gridYPoint);
				xCoord=gridXPoint;
				columnCounter =0;
			}
			StdDraw.square(xCoord, yCoord, lengthSquare/2);
			columnCounter++;
			xCoord+=(gridXPoint);
			
		}	
	*/}

	
	public static int gridCalculator(int n) {
		double numberOfSquares = n;
		double squareWidth;
		double squareHeight;
		int numCols;
		int numRows;
		int addOn = 0;
		int sizeGrid=0;
		int squareRootNum =  (int) (Math.round(Math.sqrt(numberOfSquares)));
		if (Math.sqrt(numberOfSquares)==squareRootNum){
			sizeGrid=squareRootNum;
		}
		else{
			
			double tempSquares= numberOfSquares;
			int count=0;
			while(Math.sqrt(tempSquares)!= (int) (Math.round(Math.sqrt(tempSquares)))){
				count++;
				tempSquares+=1;
			}
			sizeGrid = (int) Math.sqrt(numberOfSquares+count);
			
		}
		System.out.println((sizeGrid)+" ");
		
		return sizeGrid;
		
		//do{
		//addOn+=1;
	
	//}while()
	}
	public static void printNumbers(int[]PrimeArray)
	{ 
		int numberOfPrimes = 0;
		for(int count=0;count<=PrimeArray.length-1;count++,numberOfPrimes++)
		{
		if(PrimeArray[count]!=0){
			if(count!=0){
				System.out.print(",");
			}
			System.out.print(PrimeArray[count]);													
			if(numberOfPrimes>100){System.out.println(" ");								// separate results
			numberOfPrimes = 0;
			}
		}
	}
	}
}


