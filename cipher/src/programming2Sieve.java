import javax.swing.JOptionPane;
import java.util.Scanner;

public class programming2Sieve {

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
			findPrimes(n,primeArray);
		}
		catch(java.util.InputMismatchException exception)
			{
				System.out.print("please enter a valid integer");
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
		printNumbers(primeArray);
	}
	public static void markOffMultiples(int[]primeArray,int n,int currentPrime)
	{ 	int currentMultiples=0;
		int counterMultiplier=2;
		while (currentMultiples<=(n-currentPrime)){
			currentMultiples= counterMultiplier*currentPrime;
			primeArray[currentMultiples-2]=0;												// -2 because we skip 0 and 1 in the array of primes
			counterMultiplier++;
		}
		counterMultiplier =2;
	}
	public static void printNumbers(int[]PrimeArray)
	{ int numberOfPrimes = 0;
		for(int count=0;count<=PrimeArray.length-1;count++,numberOfPrimes++){
			if(PrimeArray[count]!=0){
				System.out.print(PrimeArray[count]);
				System.out.print(",");														
				if(numberOfPrimes>100){System.out.println(" ");								// separate results
				numberOfPrimes = 0;
				}
			}
		}
	}
}
