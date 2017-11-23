package climbingClubHarnessRecordSystem;

public class ClubHarness {
	private final String make;
	private final int modelNumber;
	private int timesUsed;
	private String instructLstCheck;
	private boolean onLoan;
	private String onLoanName;
	
	
	 public ClubHarness (String harnessMake, int harnessModelNumber,
			 String harnessInstructLstCheck,){
		 make = harnessMake;
		 modelNumber =harnessModelNumber;
		 timesUsed = 0;
		 instructLstCheck =harnessInstructLstCheck;
		 onLoan = false;
		 onLoanName = null;
	 }
	 public boolean checkHarness (String instructorName){
		boolean harnessChecked=false;
		 if(onLoan!=false){
			 timesUsed=0;
			 instructLstCheck=instructorName;
			 harnessChecked=true;
		 }
		 return harnessChecked;
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
	 public boolean loanHarness (String climbingMember){
		 boolean loanHarness =false;
		 if(canHarnessBeLoaned()==true){
			 onLoan=true;
			 onLoanName =climbingMember;
			 timesUsed+=1;
		 }
		 return loanHarness;
	 }
	 public boolean returnHarness(){
		 boolean returnHarness=false;
		 if(onLoan==true){
			 onLoan=false;
			 returnHarness=true;
		 }
		 return returnHarness;
	 }
	 public String toString(){
		 String harness = make+" "+ modelNumber+" "+ timesUsed
				 + " " +instructLstCheck+ " "+onLoan+ " "+onLoanName;
		 return harness;
	 }
	public static void main(String[] args) {
		String niall = new String ("Ryan");
		String guchi = new String("Guchi");
		int model = 255;
		String conor = new String("Fulham");
		ClubHarness harness = new ClubHarness(guchi,model,conor);
		System.out.println(harness.canHarnessBeLoaned());
		System.out.println(harness.loanHarness(niall));
		System.out.println(harness.isHarnessOnLoan());
		System.out.println(harness.returnHarness());
		System.out.println(harness.checkHarness(conor));
		System.out.println(harness.toString());
	}

}
