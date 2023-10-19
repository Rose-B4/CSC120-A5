public class Passenger {
    
    private String name;

    /**
     * Constructor for the passenger class.
     * @param name takes a string for the name of the passenger and sets it to the name of that instance of a passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Overloads the toString method to return the name of passenger instead of the memory address.
     */
    public String toString(){
        return this.name;
    }

    /**
     * A method to add the passenger instance to any given car
     * @param c the car that the passenger will get added to
     */
    public void boardCar(Car c){
        try{
            c.addPassenger(this);
        }
        catch(Exception e){
            throw e;
        }
    }

    /**
     * A method to remove the passenger instance from any given car
     * @param c the car that the passenger will be removed from
     */
    public void getOffCar(Car c){
        try{
            c.removePassenger(this);
        }
        catch(Exception e){
            throw e;
        }
    }
}
