
package onlineshopping;

import java.util.Scanner;

public class OnlineShopping {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Inventory inventory = new Inventory();
        
        System.out.println("Please enter your number of points");
        int points = scanner.nextInt();
 
        points = takeOrder(points, scanner, inventory);
        points = takeOrder(points, scanner, inventory);
        points = takeOrder(points, scanner, inventory);   
    }
    
    public static int takeOrder(int points, Scanner scanner, Inventory inventory) {
        System.out.println("Please enter type of product: 1 for shampoo, 2 for conditioner, 3 for gel");
        int type = scanner.nextInt();
        System.out.println("Please enter the quantity");
        int quantity = scanner.nextInt();     
        return inventory.processOrder(points, quantity, type);
    }
    
}
