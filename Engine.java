public class Engine {
    private FuelType fuelType;
    private double maxFuel;
    private double currentFuel;

    /**
     * 
     * @param fuelType takes a fuel type to be used by the engine, this is an enum object defined by FuelType.java
     * @param maxFuel takes a double that sets the maximum fuel of the engine as well as the current fuel of the train (we are assuming all engines are fully fueled when created)
     */
    public Engine(FuelType fuelType, double maxFuel){
        this.fuelType = fuelType;
        this.maxFuel = maxFuel;
        this.currentFuel = maxFuel;
    }
    /**
     * Refuels the engine
     * If the engine is already full, throw an exception
     */
    public void refuel(){
        if(this.currentFuel == this.maxFuel){
            throw new RuntimeException("Engine is already fully fueled!");
        }
        this.currentFuel = this.maxFuel;
        System.out.println("Refueling Finished");
    }

    /**
     * Moves the train forward and decreases current fuel in the engine
     * If the engine doesn't have enough fuel to move, it throws an exception
     */
    public void go(){
        int fuelCost = 10;
        if(this.currentFuel-fuelCost < 0){
            throw new RuntimeException("Engine doesn't have enough fuel to go anywhere!");
        }
        this.currentFuel -= fuelCost;
        System.out.println("The train moved forward, current fuel is " + this.currentFuel);
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        // myEngine.refuel();
        try {
           while (true) {
               myEngine.go();
           }
       } catch (Exception e) {
           System.err.println(e.getMessage()); // Out of fuel
       }
       myEngine.refuel();
       myEngine.go();
    }
}