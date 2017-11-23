
public class errorSublime {

	public static void main(String[] args) {
		System.out.print(Prob3());

	}
	public static double Prob3(){
		 	final double PROB_NUM = 600851475143L ;
		 	double numm = PROB_NUM;
		 	double largestFact = 0;
		 	double i =2;
		 	while(i*i<PROB_NUM){
		 		if( numm%i ==0){
		 			numm = numm/i;
		 			largestFact = i;
		 		}	else{
		 			i++;
		 		}

		 	}
		 	if(numm>largestFact)
		 		largestFact = numm;

		 	return largestFact;
		 }

}
