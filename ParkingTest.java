import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;

public class ParkingTest {
    Parking parking = new Parking();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void createParkingLot() throws Exception {
        parking.createParkingLot("6");
        assertEquals(6, parking.parkingCapacity.size());
    }

    @Test
    public void park() throws Exception {
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        assertEquals("ParkingLotCreationUnsuccessful\n" +
                "\n" +
                "ParkingLotCreationUnsuccessful", outContent.toString().trim().replace(" ", ""));
        parking.createParkingLot("6");
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        assertEquals(4, parking.availableSpots.size());
    }

    @Tesut
    public void leave() throws Exception {
        parking.leave("2");
        assertEquals("ParkingLotCreationUnsuccessful", outContent.toString().trim().replace(" ", ""));
        parking.createParkingLot("6");
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        parking.leave("4");
        assertEquals("ParkingLotCreationUnsuccessful\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "Slotnumber4isalreadyempty", outContent.toString().trim().replace(" ", ""));
    }

    @Test
    public void status() throws Exception {
        parking.status();
        assertEquals("ParkingLotCreationUnsuccessful", outContent.toString().trim().replace(" ", ""));
        parking.createParkingLot("6");
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        parking.status();
        assertEquals("ParkingLotCreationUnsuccessful\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "SlotNo.\tRegistrationNo.\tColor\n" +
                "1\tKA-01-HH-1234\tWhite\n" +
                "2\tKA-01-HH-9999\tWhite", outContent.toString().trim().replace(" ", ""));
    }

    @Test
    public void registrationNoForCarsWithColour() throws Exception {
        parking.registrationNoForCarsWithColour("White");
        assertEquals("ParkingLotCreationUnsuccessful", outContent.toString().trim().replace(" ", ""));
        parking.createParkingLot("6");
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        parking.registrationNoForCarsWithColour("White");
        assertEquals("ParkingLotCreationUnsuccessful\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "KA-01-HH-1234,KA-01-HH-9999", outContent.toString().trim().replace(" ", ""));
        parking.registrationNoForCarsWithColour("Red");
        assertEquals("ParkingLotCreationUnsuccessful\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "KA-01-HH-1234,KA-01-HH-9999Notfound", outContent.toString().trim().replace(" ", ""));
    }

    @Test
    public void slotNosForCarsWithColour() throws Exception {
        parking.slotNosForCarsWithColour("White");
        assertEquals("ParkingLotCreationUnsuccessful", outContent.toString().trim().replace(" ", ""));
        parking.createParkingLot("6");
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        parking.slotNosForCarsWithColour("White");
        assertEquals("ParkingLotCreationUnsuccessful\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "1,2", outContent.toString().trim().replace(" ", ""));
        parking.slotNosForCarsWithColour("Red");
        assertEquals("ParkingLotCreationUnsuccessful\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "\n" +
                "1,2\n" +
                "Notfound", outContent.toString().trim().replace(" ", ""));
    }

    @Test
    public void slotNoForRegNo() throws Exception {
        parking.slotNoForRegNo("KA-01-HH-1234");
        assertEquals("ParkingLotCreationUnsuccessful", outContent.toString().trim().replace(" ", ""));
        parking.createParkingLot("6");
        parking.park("KA-01-HH-1234", "White");
        parking.park("KA-01-HH-9999", "White");
        parking.getSlotNumberFromRegNo("KA-01-HH-1234");
        assertEquals("Sorry,parkinglotisnotcreated\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "1", outContent.toString().trim().replace(" ", ""));
        parking.slotNoForRegNo("KA-01-HH-9999");
        assertEquals("ParkingLotCreationUnsuccessful\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "1\n" +
                "2", outContent.toString().trim().replace(" ", ""));
        parking.leave("1");
        parking.slotNoForRegNo("KA-01-HH-1234");
        assertEquals("ParkingLotCreationUnsuccessful\n" +
                "\n" +
                "Createdparkinglotwith6slots\n" +
                "\n" +
                "Allocatedslotnumber:1\n" +
                "\n" +
                "Allocatedslotnumber:2\n" +
                "\n" +
                "1\n" +
                "2\n" +
                "Slotnumber1isfree\n" +
                "\n" +
                "Notfound", outContent.toString().trim().replace(" ", ""));
    }

}
