package store;

import utilities.Converter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean play = true;
        Scanner scan = new Scanner(System.in);

        Converter.setRateFt(3.28084);
        Converter.setRateGal(0.264172);
        Converter.setRateLbs(2.20462);
        Converter.setRateUsd(0.78);
        Converter.setRateMiles(1.60934);

        Store storeManager = new Store();
        Store.initInventory();
        while (play) {
            // every order is newed for each customer
            Order orderManager = new Order();
            // for each order,
            // client's info and inventory info
            orderManager.getOrders();
            double bill = storeManager.processOrders(orderManager);
            System.out.println("final bill: " + bill);

            System.out.println("would you like to continue? Y/N");

            if (scan.next().equalsIgnoreCase("n")) {
                break;
            }

        }

    }
}
