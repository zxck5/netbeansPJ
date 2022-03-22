package ca.humber.college;

public class DeliveryCompany {

    public static void main(String[] args) {
        // At home - Add Scanner class to read input from the user
        
        Truck truck = new Truck();
        
        truck.deliver(200, 400);
        truck.printInfo();
        truck.updateFuel(50);
    }
    
}