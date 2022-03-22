package delivery;
import java.util.Comparator;
import java.util.Scanner;

public class DeliveryCompany {
	
	
	
	public int [] setCoordinates(Scanner scan) {
		int arr[] = new int[2];
		arr[0] = scan.nextInt();
		arr[1] = scan.nextInt();
		
		return arr;
	}
	public Vehicle dispatcher(int coor[], Vehicle v1, Vehicle v2) {// coor[0] = x, coor[1] = y
		v1.distance = Math.abs(v1.x - coor[0]) + Math.abs(v1.y - coor[1]);
		v2.distance = Math.abs(v2.x - coor[0]) + Math.abs(v2.y - coor[1]);
		System.out.println(v1 + " distance=" + v1.distance);
                System.out.println(v2 + " distance=" + v2.distance);
		if (v1.distance > v2.distance) {
			return v2;
		} else if (v2.distance > v1.distance) {
			return v1;
		} else {
			// if they are same
			return null;
		}
		
//		if (distanceComp.compare(v1,v2) > 0) {
//			return v2;
//		} else if (distanceComp.compare(v1, v2) == 0) {
//			return null;
//		} else {
//			return v1;
//		}
		
	}
	
	public Vehicle checkVehicle (Vehicle shrtVehicle, Vehicle v1, Vehicle v2, Scanner scan) {
		if (shrtVehicle == null) {
			System.out.println("both distances are same.");
			System.out.println("which vehicle would you like to use?");
			System.out.println("1. first vehicle:" + v1);
			System.out.println("2. second vehicle:" +v2);
			int sel = scan.nextInt();
			switch (sel) {
				case 1 :
					return shrtVehicle = v1;
				case 2 :
					return shrtVehicle = v2;
				
					
			}
			return null;
		} else {
			return shrtVehicle;
		}
	}
	
	public static Comparator<Vehicle> distanceComp = new Comparator<Vehicle>() {

		@Override
		public int compare(Vehicle o1, Vehicle o2) {
			// TODO Auto-generated method stub
			return o1.distance - o2.distance;
		}
		
	};
	
	
}
