import java.util.Scanner;
import java.util.Arrays;
public class wordLinks {
	
	public static void main(String[] args) {
		System.out.println("Welcome to word-links");
		boolean playing=true;
		do{
			System.out.println("Please enter the sequence of words you wish to check is a word-link, "
					+ "separated by '-' or type 'quit' to exit");
			Scanner inputScanner =new Scanner(System.in);
			String input = inputScanner.next();
			if(input.equals("quit")){
				playing =false;
				System.out.print("you will be missed, the cake is a lie!!!");
			}
			else{
				String []wordArray= readWords(input);
				System.out.println(isWordChain(wordArray));
				
			}
		}
		while(playing==true);
	}
	
	public static String[] readWords(String input){
		String[] wordArray = input.split("-");
		return wordArray;
	}
	
	public static boolean isUnique (String[] wordArray){
		boolean isUnique=true;
		for(int i=0;i<wordArray.length-1;i++){
			String currentWord= wordArray[i];
			for( int j=i+1;j<wordArray.length;j++){
				String checkWord = wordArray[j];
				if(currentWord.equals(checkWord)){
					isUnique=false;
				}
			}
		}
		return isUnique;
	}
	
	public static boolean isEnglishWord(String currentWord ){
		In in= new In("./words.txt");
		String[] dictionary = in.readAllStrings();
		int search= Arrays.binarySearch(dictionary, currentWord);
		return search>=0;
	}
	
	public static boolean isDifferentByOne(String currentWord,String comparisonWord){
		boolean isDifferentByOne =true;
		int count =0;
		if(currentWord.length()==comparisonWord.length()){
			for(int i=0;i< currentWord.length();i++){
				char currentChar=currentWord.charAt(i);
				char comparisonChar=comparisonWord.charAt(i);
				
				if(currentChar!=comparisonChar){
					count++;
				}
			}
			if (count!=1){
				isDifferentByOne=false;
		}
		}
		else{ 
			isDifferentByOne=false;
		}
		return isDifferentByOne;
	}
	
	public static boolean isWordChain (String[] wordArray){
		boolean isWordChain=true;
		boolean englishWord =true;
		if(isUnique(wordArray)){
			for(int i=0;i<wordArray.length;i++){
				String currentWord=wordArray[i];
				if(isEnglishWord(currentWord)==false){
					englishWord=false;
					System.out.println("The string at position "+ (i+1)+" "+ "is not a valid word, please enter another list of words");
				}
			}
			if(englishWord==true){
				for(int j=0;j<(wordArray.length-2);j++){
						String currentWord =wordArray[j];
						String comparisonWord =wordArray[j+1];
						if(isDifferentByOne( currentWord, comparisonWord)==false){
							isWordChain=false;
						}
					}
				}
				else{
					isWordChain=false;
				}
		}
		else{
			isWordChain=false;
			System.out.println("One of the words has been repeated in the sequence, please enter only unique words");
		}
		if(isWordChain==true){
			System.out.println("The sequence is a wordlink");
			for(int i=0;i<wordArray.length;i++){
				System.out.println(wordArray[i]);
			}
		}
		return isWordChain;
	}

}
