package delivery;
public class Vehicle {
	// vehicle number
	int num;
	
	// distance variables
	int x;
	int y;
	// distance between set of coordinates and vehicle
	int distance;
	
	// constructor
	public Vehicle (int num) {
		this.num = num;
	}
	
	// current location
	public String curLocation() {
		return" x="+x + ", y="+ y;
	}
	
	//print current information
	public String toString () {
		return "x="+x + ", y="+y + ", vehicle number: "+ num;
	}
	public void update(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	

}
