package delivery;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//v1
		// vehicle number 
		System.out.println("input first vehicle number");
		Vehicle v1 = new Vehicle(scan.nextInt());
		System.out.println(v1);
		
		//v2
		System.out.println("input second vehicle number");
		Vehicle v2 = new Vehicle(scan.nextInt());
		System.out.println(v2);
		
		// Vehicle manager
		DeliveryCompany man = new DeliveryCompany();
		
		//scan 5 sets of coordinates for 5 different deliveries
		for (int i = 0; i < 5 ; i ++) {
			System.out.println("\ncurrent location of vehicle"+v1.num+v1.curLocation());
			System.out.println("current location of vehicle"+v2.num+v2.curLocation());
			int coordinates[] = new int[2]; // set of x,y
			System.out.println("\ntype set of coordinates");
			coordinates = man.setCoordinates(scan);
                        // dispatcher
			Vehicle shrtVehicle = man.dispatcher(coordinates,v1,v2); 
			// check vehicle if it is v1 or v2
			shrtVehicle = man.checkVehicle(shrtVehicle,v1,v2,scan);
			
			// update values in the chosen vehicle
			shrtVehicle.update(coordinates[0], coordinates[1]);
			System.out.println("-----------------------------------------------------------");
			System.out.println("chosen vehicle : "+ shrtVehicle);
                        System.out.println("------------------------------------------------------------");
		}
	
	}
}
