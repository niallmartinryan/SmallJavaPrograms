import java.util.Scanner;
/*	use your own file.. or use my sample file.. Test.txt which is submitted on blackboard
 * 	
 * 
 * 
 * 
 */
public class InterFaceClimbingHarness {

	public static void main(String[] args) {
		HarnessRecords record = new HarnessRecords();
		boolean action = true;
		boolean usingGUI = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Climbing Club Interface");
		System.out.println("Choose one of the following options");
		while(usingGUI ==false){


			System.out.println("Do you have a record of all harnesses ('yes'), or are you creating a new record('no')");

			String input = scanner.next();
			if(input.equals("yes")){
				while(record.fileFound==false){
					System.out.println("Please enter the name of the file containing the details of the harnesses");
					String fileName = scanner.next();
					record = new HarnessRecords(fileName);
					usingGUI =true;
				}
			}
			else if(input.equals("no")){
				usingGUI =true;
			}
			else{
				System.out.println("Please enter either 'yes' or 'no'");
			}
		}
		while (action==true){
			try{
				System.out.println("\nPlease choose one of the following actions or type 'quit' to exit");
				System.out.println("Add harness- 'add'\nReturn harness- 'return'\nLoan harness-"
						+ " 'loan'\nRemove harness- 'remove'\nCheck harness- 'check'\nList harnesses- "
						+ "'list'\nCheck if the record is empty 'empty");
				String options = scanner.next();
				if(options.equals("add")){
					boolean added =false;
					while(added==false){
						System.out.println("Would you like to enter 3 details '3' or 6 details '6'?");
						String	option =scanner.next();
						

						if(option.equals("3")){
							System.out.print("Please enter the harness details: make, model and name of instructor that last checked");
							String make = scanner.next();
							int model= scanner.nextInt();
							String instructor = scanner.next();
							Harness harness = new Harness(make, model,instructor);
							record.addHarness(harness);
							added=true;
						}
						else if(option.equals("6")){
							System.out.print("Please enter the harness details: make, model, name of instructor that last checked,\n"
									+ " times used, is the harness on loan?:'true' or 'false',"
									+ " if on loan: the members name, not on loan: 'null' ");
							String make = scanner.next();
							int model= scanner.nextInt();
							String instructor = scanner.next();
							int timesUsed = scanner.nextInt();
							boolean onLoan = scanner.nextBoolean();
							String member = scanner.next();
							Harness harness =new Harness(make,model,instructor,timesUsed,onLoan,member);
							record.addHarness(harness);
							added=true;
						}
						else{
							System.out.println("'3' or '6' please");
						}
						if(added==true){
							System.out.println("The harness has been added");
						}
					}
				}

				else if(options.equals("return")){
					System.out.println("Please enter the make and model of the harness ");
					String make = scanner.next();
					int model = scanner.nextInt();
					if(record.returnHarness(make, model)!=null){
						System.out.println("The harness has been returned");
					}
					else{
						System.out.println("There is no harness of this description in our records");
					}
				}
				else if(options.equals("loan")){
					System.out.println("Please enter the name of the club member attempting to loan out a harness");
					String member = scanner.next();
					Harness harness =record.loanHarness(member);
					if(harness!=null){
						System.out.println("The harness has been loaned: "+ harness.toString());
					}
					else{
						//System.out.println("There are no harnesses available to be loaned");
					}	
				}
				else if(options.equals("remove")){
					System.out.println("Please enter the make and model of the harness");
					String make  = scanner.next();
					int model = scanner.nextInt();
					record.removeHarness(make, model);
				}
				else if(options.equals("check")){
					System.out.println("Please enter the make, model and instructor checking the harness");
					String make = scanner.next();
					int model = scanner.nextInt();
					String instruct = scanner.next();
					record.checkHarness(instruct, make, model);

				}
				else if(options.equals("list")){
					System.out.println("\nMake: Model: times used: instructor: on loan: member loaned to");
					record.toList();
				}
				else if(options.equals("empty")){
					System.out.println(record.isEmpty());
				}
				else if(options.equals("quit")){
					action=false;
				}


				//			ClubHarnesses StPatricks = new ClubHarnesses();
				//			Harness harness = new Harness(make,model); 							//bleh
				//			StPatricks.addHarness();



				
			}
			catch(java.util.InputMismatchException exception){
				System.out.println("Please enter the specified information");
			}
			
		}//catch(java.util.)
		scanner.close();
	}

}
