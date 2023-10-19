import java.util.ArrayList;

public class Car {
    private ArrayList<Passenger> passengers;
    private int maxCapacity;

    public Car(int maxCapacity){
        this.passengers = new ArrayList<>(maxCapacity);
        this.maxCapacity = maxCapacity;
    }

    /**
     * A method to get the total capacity of the car
     * @return Method returns an int of the max capacity of the car
     */
    public int getCapacity(){
        return this.maxCapacity;
    }

    /**
     * A method to get the remaining capacity of the car
     * @return
     */
    public int getRemainingSeats(){
        return this.maxCapacity - this.passengers.size();
    }

    /**
     * A method to add a new passenger to the car
     * Checks if there is space for a new passenger, then checks if the new passenger is already on board, then adds the passenger to the car
     * @param p Takes the passenger that will be added to the car
     */
    public void addPassenger(Passenger p){
        if(this.passengers.contains(p)){
            throw new RuntimeException("Tried to board "+p+" but they were already in this car");
        }
        if(this.passengers.size() >= this.maxCapacity){
            throw new RuntimeException("The car is full");
        }
        this.passengers.add(p);
        System.out.println(p+" boarded the train");
    }

    /**
     * A method to remove a passenger from a car
     * Checks if the passenger is on the car to begin with, then removes them
     * @param p Takes the passenger that will be removed from the car
     */
    public void removePassenger(Passenger p){
        if(!this.passengers.contains(p)){
            throw new RuntimeException("Tried to remove "+p+" but they weren't in this car");
        }
        this.passengers.remove(p);
        System.out.println(p+" left the train");
    }

    /**
     * A method to print all passengers on the car
     * Prints a special message if the car is empty
     */
    public void printManifest(){
        if(this.passengers.size() <= 0){
            System.out.println("This car is EMPTY");
        }
        else{
            System.out.println("Passengers: "+ this.passengers.toString());
        }
    }

    public static void main(String[] args) {
        Passenger passenger = new Passenger("Rose");
        Passenger passenger1 = new Passenger("Rose1");
        Car car = new Car(2);
        car.addPassenger(passenger);
        car.addPassenger(passenger1);
        car.printManifest();
        car.removePassenger(passenger);
        car.printManifest();
    }
}