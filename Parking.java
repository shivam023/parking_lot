import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;

public class Parking{
    private int parkingCapacity;
    private List<Integer> availableSpots = null;
    private List<String> registrationNoList = null;
    private TreeMap<Integer, Car> parkingLot = null;
    private boolean parkingLotCreated = false;

    public boolean parkingLotCreated(){
        return parkingLotCreated;
    }

    public void createParkingLot(int parkingCapacity){
        try{
            if(parkingCapacity>0){
                this.parkingCapacity = parkingCapacity;
                availableSpots = new ArrayList<Integer>();
                parkingLot = new TreeMap<Integer, Car>();
                registrationNoList = new ArrayList<String>();
                for(int i = 1; i <= parkingCapacity; i++){
                    availableSpots.add(i);
                }
                System.out.println("Created a parking lot with "
                    + availableSpots.size() + " slots");
		parkingLotCreated = true;
            }
            else{
                System.out.println("Please provide a valid number of total" +
                    "parking spots");
            }
        }
        catch(Exception e){
            System.out.println("Parking Lot creation was unsuccessful");
        }
    }

    public void park(String regNo, String colour){
        if(!registrationNoList.contains(regNo)){
	    if(parkingLot.keySet().size() == parkingCapacity){
	        System.out.println("Sorry, parking lot is full");
	    }
	    else{
	        Car car = new Car(regNo, colour);
                int spot = availableSpots.get(0);
		parkingLot.put(spot, car);
		//remove the taken spot from the list of available spots
                availableSpots.remove(availableSpots.indexOf(spot));
		registrationNoList.add(regNo);
		System.out.println("Allocated slot number: " + spot);
	    }
	}
	else{
	    System.out.println("Car with reg no " + regNo +
	        " has been parked already");
	}
    }
    public void leave(int spotNo){
        if(parkingLot.containsKey(spotNo)){
	    String regNo = parkingLot.get(spotNo).getRegistrationNumber();
	    parkingLot.remove(spotNo);
	    registrationNoList.remove(registrationNoList.indexOf(regNo));
	    availableSpots.add(spotNo);
	    Collections.sort(availableSpots);
	    System.out.println("Slot number " + spotNo + " is free");
	}
	else if(spotNo > parkingCapacity){
	    System.out.println("No such parking slot");
	}
	else{
	    System.out.println("This spot is already vacant");
	}
    }

    public void parkingLotStatus(){
        Iterator<Integer> it = parkingLot.keySet().iterator();
	System.out.println("Slot No." + "    " + "Registration No" + "    " +
	    "Colour");
	while(it.hasNext()){
	    Integer spot = it.next();
	    Car car = parkingLot.get(spot);
	    System.out.println(spot.toString() + "           " +
	        car.getRegistrationNumber() + "      " +
		    car.getColour());
	}
    }

    public void registrationNoForCarsWithColour(String colour){
        Iterator<Integer> it = parkingLot.keySet().iterator();
	String registrationNos = "";
	while(it.hasNext()){
	    Integer spot = it.next();
	    Car car = parkingLot.get(spot);
	    if(car.getColour().equals(colour)){
	        registrationNos = registrationNos +
		    car.getRegistrationNumber().toString() + ", ";
	    }
	}
	int n = registrationNos.length();
        System.out.println(registrationNos.substring(0,n-2));
    }

    public void slotNosForCarsWithColour(String colour){
        Iterator<Integer> it = parkingLot.keySet().iterator();
	String slotNos = "";
	while(it.hasNext()){
	    Integer spot = it.next();
	    Car car = parkingLot.get(spot);
	    if(car.getColour().equals(colour)){
	        slotNos = slotNos + spot.toString() + ", ";
	    }
	}
	int n = slotNos.length();
	System.out.println(slotNos.substring(0,n-2));
    }

    public void slotNoForRegNo(String regNo){
        Iterator<Integer> it = parkingLot.keySet().iterator();
	boolean flag = false;
	while(it.hasNext()){
	    Integer spot = it.next();
	    Car car = parkingLot.get(spot);
	    if(car.getRegistrationNumber().equals(regNo)){
	        flag = true;
	        System.out.println(spot);
	        break;
	    }
	}
	if(flag == false){
	    System.out.println("Not found");
	}
    }
}
