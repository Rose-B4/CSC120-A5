import java.util.ArrayList;

public class Train {
    private final Engine engine;
    private ArrayList<Car> cars;
    
    /**
     * Constructor for the train class. Instantiates the engine and cars that make up the train
     * @param fuelType takes a FuelType that the engine will use
     * @param fuelCapacity takes a double that will be passed to the engine to be used as its "maxFuel" attribute
     * @param nCars takes an int for the number of passenger cars that will be on the train
     * @param passengerCapacity takes an int for the number of passengers that can fit on each car, this is passed to the Car constructor for each car created
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity);

        cars = new ArrayList<>(nCars);
        for(int i=0; i<nCars; i++){
            cars.add(i, new Car(passengerCapacity));
        }
    }

    /**
     * A method to get the engine of the train since the engine attribute is private
     * @return Returns the instance's engine
     */
    public Engine getEngine(){
        return this.engine;
    }
    /**
     * A method to get the car at a given index in the train
     * @param i the method takes an int to determine which car to return
     * @return returns the car at said index
     */
    public Car getCar(int i){
        return this.cars.get(i);
    }

    /**
     * A method to get the total number of seats on the train
     * @return returns an int of the max capacity of all cars added together
     */
    public int getMaxCapacity(){
        if(cars.size() <= 0){
            throw new RuntimeException("There are no cars on the train");
        }
        int toReturn = 0;
        for(int i=0; i<cars.size(); i++){
            toReturn+= cars.get(i).getCapacity();
        }
        return toReturn;
    }

    /**
     * A method to get the total number of available seats on the train
     * @return returns an int of the remaining capacity of all cars added together
     */
    public int seatsRemaining(){
        int toReturn = 0;
        for(int i=0; i<cars.size(); i++){
            toReturn+= cars.get(i).getRemainingSeats();
        }
        return toReturn;
    }

    /**
     * A method to print all passengers on all cars
     * This method utilizes the printManifest method from the car class
     */
    public void printManifest(){
        if(this.cars.size() == 0){
            throw new RuntimeException("There are no cars on the train");
        }
        for(int i=0; i<cars.size(); i++){
            cars.get(i).printManifest();
        }
    }

    public static void main(String[] args) {
        Train train = new Train(null, 20, 2, 2);
        train.printManifest();

    }

}
