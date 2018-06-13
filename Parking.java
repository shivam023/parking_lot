import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

public class Parking{
    private int parkingCapacity;
    private List<Integer> availableSpots = null;
    private List<String> registrationNoList = null;
    private TreeMap<Integer, Car> parkingLots = null;

    public void createParkingLot(int parkingCapacity){
        try{
            if(parkingCapacity>0){
                this.parkingCapacity = parkingCapacity;
                availableSpots = new ArrayList<Integer>();
                parkingLots = new TreeMap<Integer, Car>();
                registrationNoList = new ArrayList<String>();
                for(int i = 1; i <= parkingCapacity; i++){
                    availableSpots.add(i);
                }
                System.out.println("Parking lot created with available spots:"
                    + availableSpots.size());
            }
            else{
                System.out.println("Please provide a valid number of total" +
                    "parking spots");
            }
        }
        catch(Exception e){
            System.out.println("Parking Lot creation was unsuccessfull");
        }
    }
}