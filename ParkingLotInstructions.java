import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParkingLotInstructions{

    private static Parking parking = new Parking();

    public static void main(String[] args){
        String instructionsString;
        String[] instructions;
        BufferedReader bufferedReader = null;
        boolean exitProcess = false;
        try{
            if(args.length > 0)
                bufferedReader = new BufferedReader(new FileReader(args[0]));

            while(!exitProcess){
                if(args.length == 0){
                    bufferedReader = new BufferedReader(new InputStreamReader(
                                    System.in));
                }
                instructionsString = bufferedReader.readLine().trim();
                instructions = instructionsString.split("\\s+");

                if(!instructions[0].isEmpty()){
                    switch(instructions[0]){
                        case "create_parking_lot" : {
			    if (!parking.parkingLotCreated()) {
                                if(instructions.length == 2){
                                    try{
                                        parking.createParkingLot(
                                            Integer.parseInt(instructions[1]));
                                    }
                                    catch(Exception e){
                                        System.out.println("Please enter correct" +
                                            "inputs");
                                        System.out.println(e.getMessage());
                                    }
                                }
                                else{
                                    System.out.println("Please enter the number" +
                                        "of slots");
                                }
			    }
			    else{
			        System.out.println("Parking lot already created!");
			    }

                            break;
                        }

			case "park" : {
			    if (parking.parkingLotCreated()) {
			        if(instructions.length == 3){
			            try{
				        parking.park(instructions[1],
                                            instructions[2]);
				    }
				    catch(Exception e){
				        System.out.println("Please enter correct" +
                                            "inputs");
				    }
			        }
			        else{
                                    System.out.println("Please enter the" +
                                        "registration no and colur of the car");
			        }
			    }
			    else{
                                System.out.println("Parking lot already created!");
                            }

			    break;
			}

			case "leave" : {
			    if (parking.parkingLotCreated()) {
			        if(instructions.length == 2){
			            final String REGEX = "\\d+";
				    Pattern pattern = Pattern.compile(REGEX);
				    Matcher matcher = pattern.matcher(instructions[1]);
				    if(matcher.matches()){
				        try{
				            parking.leave(Integer.parseInt(instructions[1]));
				        }
				        catch(NumberFormatException e){
				            System.out.println("Invalid input");
					    System.out.println(e.getMessage());
				        }
				    }
				    else{
				        System.out.println("Invalid input");
				    }
			        }
			        else{
			            System.out.println("Invalid input");
			        }
			    }
			    else{
                                System.out.println("Parking lot already created!");
                            }

			    break;
			}

			case "status" : {
			    if (parking.parkingLotCreated()) {
			        if(instructions.length == 1)
				    parking.parkingLotStatus();
			        else
			            System.out.println("Invalid Input");
			    }
			    else{
                                System.out.println("Parking lot already created!");
                            }

			    break;
			}

			case "registration_numbers_for_cars_with_colour" : {
			    if (parking.parkingLotCreated()) {
			        if(instructions.length == 2)
                                    parking.registrationNoForCarsWithColour(
				        instructions[1]);
                                else
                                    System.out.println("Invalid Input");
			    }
			    else{
                                System.out.println("Parking lot already created!");
                            }

                            break;
			}

			case "slot_numbers_for_cars_with_colour" : {
			    if (parking.parkingLotCreated()) {
			        if(instructions.length == 2)
                                    parking.slotNosForCarsWithColour(
                                        instructions[1]);
                                else
                                    System.out.println("Invalid Input");    
			    }
			    else{
                                System.out.println("Parking lot already created!");
                            }

                            break;
			}

			case "slot_number_for_registration_number" : {
			    if (parking.parkingLotCreated()) {
			        if(instructions.length == 2)
                                    parking.slotNoForRegNo(
                                        instructions[1]);
                                else
                                    System.out.println("Invalid Input");
			    }
			    else{
                                System.out.println("Parking lot already created!");
                            }

                            break;
			}

			case "exit" : {
                            exitProcess = true;
                            break;
                        }

                        default : {
                            System.out.println("Unsupported instruction");
                        }
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Process exited");
        }
    }
}
