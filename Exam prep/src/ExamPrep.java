import java.util.Scanner;
public class ExamPrep {

	public static void main(String[] args) {
		//		      int result = fun(2,- Integer.MIN_VALUE);
		//		      System.out.println(result);
		//		   }
		//
		//		   private static int fun(int a, int b) {
		//		      System.out.println(b);
		//		      if (b == 1) return a;
		//		      else return a + fun(a, b - 1);
		//		   }
		//		double percentage = 90.0;
		//		Scanner input = new Scanner(System.in);
		//		String percents = input.nextLine();
		//		Scanner separate = new Scanner(percents);
		//		System.out.print(percents);
		//		String[] marks = percents.split(" ");
		//		Double[] percentages= new Double[marks.length];
		//		for(int i=0;i<marks.length;i++){
		//			percentages[i]=Double.parseDouble(marks[i]);
		//		}	
		System.out.print(ass(2,-4));


	}
	public static int ass(int a, int b){
		System.out.println(b);
		if (b==a){
			return a;
		}
		return a= a+ ass(a,b--); 
	}
}

