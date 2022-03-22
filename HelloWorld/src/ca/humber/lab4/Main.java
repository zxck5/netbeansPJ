package ca.humber.lab4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner scanner = new Scanner(System.in);
        double totalPrice = 0;
        String name;
        while (!(name = scanner.next()).equalsIgnoreCase("End")) {
            double price = scanner.nextDouble();
            double quantity = scanner.nextDouble();
            Product p = new Product(price, name);
            totalPrice += p.getPrice() * quantity;
            
        }
        System.out.println("Your total price is: " + totalPrice);
    }
}
