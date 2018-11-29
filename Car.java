public class Car{
    private String registrationNumber, colour;

    public Car(String registrationNumber, String colour){
        super();
        this.registrationNumber = registrationNumber;
        this.colour = colour;
    }
    public String getColour(){
        return colour;
    }
    public String getRegistrationNumber(){
        return registrationNumber;
    }
}
