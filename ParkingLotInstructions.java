import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

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