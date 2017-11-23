import java.util.Scanner;


public class Rational {
	private final int numerator;
	private final int denominator;
	
	public Rational(int numer, int denom){
		numerator =numer;
		denominator = denom;
		
	}
	public Rational(int integer){
		numerator = integer;
		denominator =1;
	}
	public Rational add( Rational add){
		Rational rational = new Rational(numerator, denominator);
		int LCM =rational.lowestCommonMultiple();
		int numeratorA = add.numerator*(LCM/add.denominator);
		int numeratorB = numerator*(LCM/denominator);
		int numeratorResult= numeratorA+numeratorB;
		Rational result = new Rational(numeratorResult, LCM);
		return result;
	}
	public Rational subtract( Rational sub){
		Rational rational = new Rational(numerator, denominator);
		int LCM =rational.lowestCommonMultiple();
		int numeratorA = sub.numerator*(LCM/sub.denominator);
		int numeratorB = numerator*(LCM/denominator);
		int numeratorResult= numeratorB-numeratorA;
		Rational result = new Rational(numeratorResult, LCM);
		return result;
	}
	public Rational multiply(Rational mul){
		int numeratorResult = numerator*(mul.numerator);
		int denominatorResult = denominator*(mul.denominator);
		return( new Rational(numeratorResult,denominatorResult));
	}
	public Rational divide( Rational div){
		int numeratorResult = numerator*(div.denominator);
		int denominatorResult = denominator*(div.numerator);
		return( new Rational( numeratorResult, denominatorResult));
	}
	public boolean equals( Rational equal){
		Rational firstRational = new Rational(numerator, denominator);
		firstRational =firstRational.simplify();
		equal = equal.simplify();
			return (firstRational.numerator == equal.numerator && firstRational.denominator==equal.denominator);
	}
	public boolean isLessThan( Rational b){
		Rational a = new Rational(numerator,denominator);
//		a.simplify();
//		b.simplify();
		int checkRational =a.numerator*b.denominator;
		int lessRational =a.denominator*b.numerator;
		
		return lessRational>checkRational;
	}
	public Rational simplify (){
		boolean simplified =false;
		boolean divided = false;
		int currentInt;
		Rational rational = new Rational(numerator,denominator);
		int GCD =rational.greatestCommonDivisor();
		int newNumerator = numerator/GCD;
		int newDenominator = denominator/GCD;
		
//		if(currentNumerator>currentDenominator){
//			currentInt =currentNumerator;
//		}
//		else{
//			currentInt=currentDenominator;
//		}
//		while(simplified==false){
//			divided=false;
//			for(int i=2;i<=currentInt;i++){
//				if(numerator%i==0 && denominator%i==0){
//					currentNumerator/=i ;
//					currentDenominator /=i;
//					divided =true;
//				}
//			}
//			if(divided==false){
//				simplified=true;
//			}
//		}
		return (new Rational(newNumerator,newDenominator));
		
	}
	public String toString(){
		String numeratorString = Integer.toString(numerator);
		String over = "/" ;
		String denonminatorString =Integer.toString(denominator);
		return(numeratorString + over+denonminatorString);
		
	}
	private int lowestCommonMultiple(){				// could just multiple both denominators to find new denominator.
		int currentNum=0;
		//boolean found=false;
		if(numerator>=denominator){
		 currentNum =numerator;
		}
		else{
		 currentNum =denominator;
		}
		for(int i=currentNum;i<=numerator*denominator;i++){
			if(i%numerator==0&&i%denominator==0){
				return i;
			}
		}
		return 0;
		//while(found==false){
//			if(currentNum%a==0&&currentNum%b==0){
//				found=true;
//			}
//			if(found==false){
//			currentNum++;
//			}
//		}
//		return currentNum;
	}
	private int greatestCommonDivisor(){
		int greatestCommonDivisor=1;
		int lowerValue;
		if(numerator>denominator){
			lowerValue =denominator;
		}
		else{
			lowerValue =numerator;
		}
		for(int i=1; i<=lowerValue;i++){
			if(numerator%i==0&&denominator%i==0){
				greatestCommonDivisor=i;
			}
		}
		return greatestCommonDivisor;
	}
	public static void main(String[] args) {
		Rational firstRational;
		Rational secondRational;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Arithmetic Calculator(rational)");
		boolean using = true;
		while(using==true){
			System.out.println("what operation would you like to complete, 'exit' to end");
			System.out.println("Addition 'add'\nSubtraction 'sub'\nMultiplication 'mul'"
					+ "\nDivision 'div'\nEquals 'equal'\nLess than 'less'\nSimplify 'simp'");
			String answer =scanner.next();
			if(answer.equals("add")){
				System.out.println("Please enter your first and second rational separated by a space");
				String input = scanner.next();
				String input1 = scanner.next();
				String [] firstNumber = input.split("/");
				String [] secondNumber = input1.split("/");
				if( firstNumber.length<2){
					firstRational = new Rational(Integer.parseInt( firstNumber[0]));
				}
				else{
					firstRational = new Rational(Integer.parseInt( firstNumber[0]),Integer.parseInt(firstNumber[1]));
				}
				if(secondNumber.length<2){
					secondRational = new Rational(Integer.parseInt( secondNumber[0]));
				}
				else{
					secondRational = new Rational(Integer.parseInt( secondNumber[0]),Integer.parseInt(secondNumber[1]));
				}
				System.out.print(firstRational.toString()+" + "+ secondRational.toString()+" = ");
				System.out.println(firstRational.add(secondRational).simplify().toString());
			}
			if(answer.equals("sub")){
				System.out.print("Please enter your first and second rational separated by a space");
				String input = scanner.next();
				String input1 = scanner.next();
				String [] firstNumber = input.split("/");
				String [] secondNumber = input1.split("/");
				if( firstNumber.length<2){
					firstRational = new Rational(Integer.parseInt( firstNumber[0]));
				}
				else{
					firstRational = new Rational(Integer.parseInt( firstNumber[0]),Integer.parseInt(firstNumber[1]));
				}
				if(secondNumber.length<2){
					secondRational = new Rational(Integer.parseInt( secondNumber[0]));
				}
				else{
					secondRational = new Rational(Integer.parseInt( secondNumber[0]),Integer.parseInt(secondNumber[1]));
				}
				System.out.print(firstRational.toString()+" - "+ secondRational.toString()+" = ");
				System.out.println(firstRational.subtract(secondRational).simplify().toString());
			}
			if(answer.equals("mul")){
				System.out.println("Please enter your first and second rational separated by a space");
				String input = scanner.next();
				String input1 = scanner.next();
				String [] firstNumber = input.split("/");
				String [] secondNumber = input1.split("/");
				if( firstNumber.length<2){
					firstRational = new Rational(Integer.parseInt( firstNumber[0]));
				}
				else{
					firstRational = new Rational(Integer.parseInt( firstNumber[0]),Integer.parseInt(firstNumber[1]));
				}
				if(secondNumber.length<2){
					secondRational = new Rational(Integer.parseInt( secondNumber[0]));
				}
				else{
					secondRational = new Rational(Integer.parseInt( secondNumber[0]),Integer.parseInt(secondNumber[1]));
				}
				System.out.print(firstRational.toString()+" * "+ secondRational.toString()+" = ");
				System.out.print(firstRational.multiply(secondRational).simplify().toString());
				
			}
			if(answer.equals("div")){
				System.out.print("Please enter your first and second rational that is dividing separated by a space");
				String input = scanner.next();
				String input1 = scanner.next();
				String [] firstNumber = input.split("/");
				String [] secondNumber = input1.split("/");
				if( firstNumber.length<2){
					firstRational = new Rational(Integer.parseInt( firstNumber[0]));
				}
				else{
					firstRational = new Rational(Integer.parseInt( firstNumber[0]),Integer.parseInt(firstNumber[1]));
				}
				if(secondNumber.length<2){
					secondRational = new Rational(Integer.parseInt( secondNumber[0]));
				}
				else{
					secondRational = new Rational(Integer.parseInt( secondNumber[0]),Integer.parseInt(secondNumber[1]));
				}
				System.out.print(firstRational.toString()+" / "+ secondRational.toString()+" = ");
				System.out.print(firstRational.divide(secondRational).simplify().toString());
				
			}
			if(answer.equals("equal")){
				System.out.print("Please enter your first and second rational separated by a space");
				String input = scanner.next();
				String input1 = scanner.next();
				String [] firstNumber = input.split("/");
				String [] secondNumber = input1.split("/");
				if( firstNumber.length<2){
					firstRational = new Rational(Integer.parseInt( firstNumber[0]));
				}
				else{
					firstRational = new Rational(Integer.parseInt( firstNumber[0]),Integer.parseInt(firstNumber[1]));
				}
				if(secondNumber.length<2){
					secondRational = new Rational(Integer.parseInt( secondNumber[0]));
				}
				else{
					secondRational = new Rational(Integer.parseInt( secondNumber[0]),Integer.parseInt(secondNumber[1]));
				}
				System.out.print(firstRational.toString()+" = "+ secondRational.toString());
				System.out.println(firstRational.equals(secondRational));
				
				
			}
			if(answer.equals("less")){
				System.out.print("Please enter your first and second rational separated by a space");
				String input = scanner.next();
				String input1 = scanner.next();
				String [] firstNumber = input.split("/");
				String [] secondNumber = input1.split("/");
				if( firstNumber.length<2){
					firstRational = new Rational(Integer.parseInt( firstNumber[0]));
				}
				else{
					firstRational = new Rational(Integer.parseInt( firstNumber[0]),Integer.parseInt(firstNumber[1]));
				}
				if(secondNumber.length<2){
					secondRational = new Rational(Integer.parseInt( secondNumber[0]));
				}
				else{
					secondRational = new Rational(Integer.parseInt( secondNumber[0]),Integer.parseInt(secondNumber[1]));
				}
				System.out.print(firstRational.toString()+" < "+ secondRational.toString());
				System.out.println(firstRational.isLessThan(secondRational));
				
			}
			if(answer.equals("simp")){
				System.out.print("Please enter the rational you wish to simplify");
				String input = scanner.next();
				
				String [] firstNumber = input.split("/");
				
				if( firstNumber.length<2){
					firstRational = new Rational(Integer.parseInt( firstNumber[0]));
				}
				else{
					firstRational = new Rational(Integer.parseInt( firstNumber[0]),Integer.parseInt(firstNumber[1]));
				}
				
				System.out.print(firstRational.toString());
				System.out.println(firstRational.simplify());
				
			}
			if(answer.equals("quit")){
				System.out.print("thanks for using the calculator");
				using=false;
			}
		}
		//tests
//		Rational a = new Rational (17,6);
//		Rational b = new Rational (6,2);
//		Rational c = new Rational (25,50);
//		Rational d = new Rational (3);
//		System.out.println(a.add(b).toString());
//		System.out.println(a.subtract(b).toString());
//		System.out.println(a.multiply(b).toString());
//		System.out.println(b.divide(c).toString());
//		System.out.println(b.equals(d));
//		System.out.println(a.isLessThan(b));
//		System.out.println(a.simplify().toString());
		
		
		

	}

}
