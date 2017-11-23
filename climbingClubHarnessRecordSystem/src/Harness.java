
public class Harness {

	private final String make;
	private final int modelNumber;
	private int timesUsed;
	private String instructLstCheck;
	private boolean onLoan;
	private String onLoanName;
	
	
	 public Harness (String harnessMake, int harnessModelNumber,
			 String harnessInstructLstCheck){
		 make = harnessMake;
		 modelNumber =harnessModelNumber;
		 timesUsed = 0;
		 instructLstCheck =harnessInstructLstCheck;
		 onLoan = false;
		 onLoanName = null;
	 }
	 public Harness(String harnessMake, int harnessModelNumber,	String harnessInstructLstCheck,int harnessTimesUsed,
			 boolean harnessOnLoan, String harnessOnLoanName){	//just give null as harnessOnLoanName "null" if not on loan.
		 make = harnessMake;
		 modelNumber =harnessModelNumber;
		 timesUsed = harnessTimesUsed;
		 instructLstCheck =harnessInstructLstCheck;
		 onLoan = harnessOnLoan;
		 onLoanName = harnessOnLoanName;
	 }
	 public void checkHarness (String instructorName){
		 if(onLoan==false){					// check this
			 timesUsed=0;
			 instructLstCheck=instructorName;
			 System.out.println("The harness has been checked");
		 }
		 
	 }
	 public boolean isHarnessOnLoan (){
		 return onLoan==true;
	 }
	 public boolean canHarnessBeLoaned(){
		boolean canHarnessBeLoaned = false;
		if(isHarnessOnLoan()==false && timesUsed<25){
			canHarnessBeLoaned=true;
		}
		 return canHarnessBeLoaned;
	 }
	 public void loanHarness (String climbingMember){
		 if(canHarnessBeLoaned()==true){
			 onLoan=true;
			 onLoanName =climbingMember;
			 timesUsed+=1;
		 }
	 }
	 public void returnHarness(){
		 if(onLoan==true){
			 onLoan=false;
			 onLoanName=null;
		 }
	 }
	 public String toString(){
//		 String harness = "make: "+ make+ ","+" "+"model: "+ modelNumber+","+" "+"times used: "+ timesUsed+","
//				 + " "+ "instructor who last checked this harness: "
//				 +instructLstCheck+","+ " "+"on loan: "+onLoan+","+ " "+"on loan to: "+ onLoanName;
		 String harness =  make +" "+ modelNumber+" "+ timesUsed+
				  " " +instructLstCheck+ " "+onLoan+ " "+ onLoanName;
		 return harness;
	 }
	 public static void main(String[] args) {
		String niall = new String ("Ryan");
		String guchi = new String("Guchi");
		int model = 255;
		String conor = new String("Fulham");
		Harness harness = new Harness(guchi,model,conor);
		System.out.println(harness.canHarnessBeLoaned());
		harness.loanHarness(niall);
		System.out.println(harness.isHarnessOnLoan());
		harness.returnHarness();
		harness.checkHarness(conor);
		System.out.println(harness.toString());
	}

}
