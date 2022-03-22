
package ca.humber.college;

public class Truck {
    private double x;
    private double y;
    private double fuelAmount;
    private double fuelConsumption;
    
    public Truck() {
        x = 70;
        y = 40;
        fuelAmount = 75;
        fuelConsumption = 15;
    }
    
    public void deliver(double xDest, double yDest) {
        // Calculate the double xDest, double yDestdistance
        double distance = calculateDistance(xDest, yDest);
        
        // Calculate the fuelAmount
        double litres = calculateFuel(distance);
        
        // Drive - consume number of litres of gas
        updateFuel(-litres);
        
        // Deliver - update current location
        updateLocation(xDest, yDest);
    }
    
    public void updateLocation(double xDest, double yDest) {
        x = xDest;
        y = yDest;
    }
    
    public double calculateDistance(double xDest, double yDest) {
        // truck drives distance in the east/west, then adding north/south distance
        return Math.abs(x - xDest) + Math.abs(y - yDest);
    }
    
    public double calculateFuel(double distance) {
        return distance * fuelConsumption / 100;
    }
    
    public void updateFuel(double litres) {
        fuelAmount += litres;
    }
    public void printInfo() {
        System.out.println("Fuel left: " + fuelAmount);
    }
}