	import java.util.ArrayList;
import java.util.ArrayList;
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
public class HarnessRecords {

		
		private ArrayList<Harness> clubHarnesses ;
		private String fileHarnesses = new String();
		boolean fileFound =false;
//		public HarnessRecords() {
//			ArrayList<Harness> clubHarnesses = new ArrayList<Harness>();
//			
//		}
		public HarnessRecords(String inputHarnesses){  //
			try{
				fileFound =false;
				clubHarnesses = new ArrayList<Harness>();
				In in = new In("./"+inputHarnesses);	//
				String []input = in.readAllStrings();
				fileFound=true;
				int numHarnesses = Integer.parseInt(input[0]);
				for(int i=1; i<input.length;i++){
				String make = input[i];
				i++;
				int model= Integer.parseInt(input[i]);
				i++;
				String instructor = input[i];
				Harness harness = new Harness(make,model,instructor);
				clubHarnesses.add(harness);
				}
	//			for(int i=0;i<clubHarnesses.size();i++){
	//				System.out.println(clubHarnesses.get(i).toString());				// get rid of this later plz.. JUST LOOP PRINTING STUFF
	//			}
			}
			catch(java.lang.NullPointerException exception){
				System.out.println("please enter the name of the file again please\n"
						+ "e.g. 'Example.txt'");
				fileFound=false;
			}
		}
		public HarnessRecords(){
			clubHarnesses = new ArrayList<Harness>();
		}
		public boolean isEmpty(){
			if(clubHarnesses.size()==0){
				return true;
			}
			else{
				return false;
			}
		}
		public void addHarness(Harness harness){
			clubHarnesses.add(harness);
		}
		public Harness findHarness (String harnessMake, int harnessModelNumber){
			boolean foundHarness= false;
			Harness currentHarness;
			Harness theHarness=null;
			for(int i=0;i<clubHarnesses.size()&&foundHarness==false;i++){
				currentHarness=clubHarnesses.get(i);
				String harness =currentHarness.toString();
				String modelNumber =Integer.toString(harnessModelNumber);
				if(harness.contains(harnessMake)&&harness.contains(modelNumber)){
					foundHarness=true;
					theHarness = currentHarness;
				}
			}
			if(foundHarness==true){
				System.out.println(harnessMake + " "+ harnessModelNumber); // for the moment, just print out.. unclear instructions
				return theHarness;
			}
			else{
				return null;
			}
		}
		public Harness removeHarness(String make,int model){
			
// 			String toStringHarness = harness.toString();
//			String[] harnessArray = toStringHarness.split(" ");
//			int harnessModel = Integer.parseInt(harnessArray[1]);
			Harness harness =findHarness(make,model);
			if(clubHarnesses.remove(harness)){
			System.out.println("The harness has been removed");
			return harness;
			}
//			if(ClubHarnesses.contains(harness)){
//				for(int i =0;i<ClubHarnesses.size()-1&& foundHarness==false;i++){
//					Harness currentHarness= ClubHarnesses.get(i);
//					if(cu rrentHarness.equals(harness)){
//						foundHarness=true;
//					}
//				}
//			}
			else{
				System.out.println("This harness does not exist");
				return null;
			}
		}
		public Harness checkHarness (String instructorName,String make, int model){
			Harness harnessToCheck= findHarness(make,model);
			if(harnessToCheck!=null){
				harnessToCheck.checkHarness(instructorName);
				return harnessToCheck;
			}
			else{
				System.out.println("This harness does not exist");
				return null;
			}
		}
		public Harness loanHarness(String clubMember){
			boolean justLoaned= false;
			for(int i =0; i<clubHarnesses.size()&&justLoaned==false;i++){
				if(clubHarnesses.get(i).canHarnessBeLoaned()){
					clubHarnesses.get(i).loanHarness(clubMember);
					return clubHarnesses.get(i);	
				}
			}
			System.out.println("no harnesses are available");
			return null;
		}
		public Harness returnHarness (String make ,int model){
			Harness currentHarness =findHarness(make,model);
			if(currentHarness!=null){
				currentHarness.returnHarness();
				return currentHarness;
			}
			return null;
		}
		public void toList (){
			for(int i=0;i<clubHarnesses.size();i++){
				System.out.println(clubHarnesses.get(i).toString());
			}
		}
		public static void main(String[] args) {
		HarnessRecords record = new HarnessRecords("Test.txt");
		System.out.println(record.isEmpty());
		Harness harness = new Harness("nitro",1995,"squidward");
		record.addHarness( harness);
		record.findHarness("nitro",1995);
		String loanedHarness = (record.loanHarness("billy").toString());
		String[] loan = loanedHarness.split(" ");
		String make = loan[0];
		int model = Integer.parseInt(loan[1]);
		System.out.println(record.returnHarness(make, model));
		///need to parse information here... as i dont know the name and model of a harness which needs to be returned.
		//System.out.print(record.returnHarness(, model))
		
		
		
		}
	}


