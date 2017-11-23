import java.awt.Color;
import java.util.Random;
import java.util.Scanner;
public class declansVersion {
	public static final int HEIGHT_CANVAS = 512;
	public static final int WIDTH_CANVAS = 512;
	public static void main(String[] args) {
		try{
			int currentPrime=2;
			boolean markingOff =false;
			int red=0;
			int blue=0;
			int green=0;
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
			StdDraw.setCanvasSize(HEIGHT_CANVAS,WIDTH_CANVAS);
			StdDraw.setScale(0, HEIGHT_CANVAS);
			createSquares(gridCalculator(n),n,primeArray,red,blue,green,markingOff,currentPrime);
			findPrimes(n,primeArray,markingOff, red, blue, green);
		}
		catch(java.util.InputMismatchException exception){
			System.out.println("please enter a valid integer");
			main(args);
		}
	}
	public static void findPrimes(int n,int []primeArray,boolean markingOff, int red,int blue, int green)
	{	
		int currentPrime =2;
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
			else{markOffMultiples(primeArray,n, currentPrime,markingOff,red, blue, green);
			}
		}
	}
	public static void markOffMultiples(int[]primeArray,int n,int currentPrime,boolean markingOff,int red, int green,int blue)
	{ 	
		markingOff=true;
		red = 255;
		green= 0;
		blue = 0;
		int currentMultiples=0;
		int counterMultiplier=2;
		while (currentMultiples<=(n-currentPrime)){
			currentMultiples= counterMultiplier*currentPrime;
			primeArray[currentMultiples-2]=0;	// -2 because we skip 0 and 1 in the array of primes
			counterMultiplier++;
		}
		counterMultiplier =2;
		StdDraw.setPenColor(red,blue,green);
		createSquares(gridCalculator(n),n,primeArray,red,blue,green,markingOff,currentPrime);
	}
	public static void createSquares( int gridCalculator, int n,int []primeArray,int red,
			int green,int blue,boolean markingOff,int currentPrime){
		Random generator = new Random();
		StdDraw.setFont();
		int sizeGrid = gridCalculator(n);
		double offset = (HEIGHT_CANVAS*.20)/(sizeGrid+1);
		int columnCounter =1;
		double lengthSquare=(HEIGHT_CANVAS*.80)/sizeGrid;
		double yCoord=HEIGHT_CANVAS-(offset+(lengthSquare/2));
		double startingXCo = 0+(lengthSquare/2);
		double xCoord=startingXCo;
		xCoord+=(lengthSquare+offset);
		red=generator.nextInt(254);
		green=generator.nextInt(254);
		blue= generator.nextInt(254);
		for(int count=0;count<=n-2;count++){
			if ((columnCounter)>=sizeGrid){
				yCoord=yCoord-(offset+lengthSquare);
				xCoord=startingXCo;
				columnCounter =0;
			}
			if(primeArray[count]==0 && ((count+2)%currentPrime==0)){
				StdDraw.setPenColor(red, green, blue);
				StdDraw.filledSquare(xCoord, yCoord, (lengthSquare/2));
			}
			else{
				if(markingOff==false){
					StdDraw.setPenColor(0,0,0);
					StdDraw.square(xCoord, yCoord, lengthSquare/2);
				}
			}
			StdDraw.setPenColor(0,0,0);
			int currentNumber = count+2;
			String text = Integer.toString(currentNumber);
			StdDraw.text(xCoord, yCoord, text);
			columnCounter++;
			xCoord+=((lengthSquare)+offset);
		}
	}
	public static int gridCalculator(int n) {
		double numberOfSquares = n;
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
				tempSquares++;
			}
			sizeGrid = (int) Math.sqrt(numberOfSquares+count);
		}
		return sizeGrid;
	}
}