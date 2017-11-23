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
public class ClubHarnesses {
	
	
	private ArrayList<Harness> ClubHarnesses = new ArrayList<Harness>();
	private int numberOfHarnesses=ClubHarnesses.size();
	private String fileHarnesses = new String();
	public ClubHarnesses() {
		
		
	}
	public ClubHarnesses(String inputHarnesses){
		
	}
	public void addHarness(Harness harness){
		ClubHarnesses.add(harness);
	}
	public Harness findHarness (String harnessMake, int harnessModelNumber){
		boolean foundHarness= false;
		Harness currentHarness;
		Harness theHarness=null;
		for(int i=0;i<ClubHarnesses.size()-1&&foundHarness==false;i++){
			currentHarness=ClubHarnesses.get(i);
			String harness =currentHarness.toString();
			String modelNumber =Integer.toString(harnessModelNumber);
			if(harness.contains(harnessMake)&&harness.contains(modelNumber)){
				foundHarness=true;
				theHarness = currentHarness;
			}
		}
		if(foundHarness==true){
			System.out.print(harnessMake + harnessModelNumber); // for the moment, just print out.. unclear instructions
			return theHarness;
		}
		else{
			return null;
		}
	}
	public Harness removeHarness(Harness harness){
		
		String toStringHarness = harness.toString();
		String[] harnessArray = toStringHarness.split(" ");
		int harnessModel = Integer.parseInt(harnessArray[1]);
		if(ClubHarnesses.remove(findHarness(harnessArray[0],harnessModel))){
		return harness;
		}
//		if(ClubHarnesses.contains(harness)){
//			for(int i =0;i<ClubHarnesses.size()-1&& foundHarness==false;i++){
//				Harness currentHarness= ClubHarnesses.get(i);
//				if(cu rrentHarness.equals(harness)){
//					foundHarness=true;
//				}
//			}
//		}
		else{
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
			return null;
		}
	}
	public Harness loanHarness(String clubMember){
		boolean justLoaned= false;
		for(int i =0; i<ClubHarnesses.size()-1&&justLoaned==false;i++){
			if(ClubHarnesses.get(i).canHarnessBeLoaned()){
				ClubHarnesses.get(i).loanHarness(clubMember);
				return ClubHarnesses.get(i);	
			}
		}
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
	public static void main(String[] args) {
	
	
	}
}
