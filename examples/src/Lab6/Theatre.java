package Lab6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Theatre {
	public static void main(String[] args) throws IOException {

		String seats2[][] = initMap2();
		boolean play = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		printSeats(seats2);
		while (play) {
			System.out.println("please enter your seat selection --> ex) A1");
			String a = br.readLine();
                        
			int y = a.charAt(0)-65;
                        int x = 0;
                        try {
                            x = Integer.parseInt(a.substring(1))-1;
                            
                        } catch(NumberFormatException e) {
                            System.out.println("try again");
                            continue;
                        } catch(Exception e) {
                            System.out.println("try again");
                            continue;
                        }
                        
			if (y >= 0 && y < 10 && x >= 0 && x < 20) {
				if (!seats2[y][x].equals("XX")) {
					seats2[y][x] = "XX";
					printSeats(seats2);
				} else {
					System.out.println("the seat is occupied. try again");
				}
			} else {
				System.out.println("try again");
			}
			System.out.println("-------------------------------------------");
			System.out.println("do you like to continue y/n");
			if (br.readLine().equalsIgnoreCase("n")) {
				break;
			}
		} 
		
		
	}
	
	public static String[][] initMap2(){
		String seats[][] = new String[10][20];
		char initChar = 'A';
		for (int row = 0; row < seats.length; row ++) {
			for (int col = 0; col < seats[row].length; col++ ) {
				seats[row][col] = String.valueOf(initChar)+(col+1);
			}
			initChar += 1;
		}
		return seats;
	}
	public static void printSeats(String seats[][]) {
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				System.out.print(seats[row][col]+"\t");
			}
			System.out.println();
		}
	}
	

}
