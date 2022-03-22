package store;

import Utility.Converter;
import Utility.Converter.Currency;
import Utility.Converter.Length;
import Utility.Converter.Volume;
import Utility.Converter.Weight;
import Utility.Converter.Distance;

import java.util.Scanner;
import store.Inventory;
import store.Order;

public class Store {

    private Inventory[] ribbon;
    private Inventory[] candy;
    private Inventory[] juice;

    public Store() {
        this.ribbon = new Inventory[5];
        this.candy = new Inventory[3];
        this.juice = new Inventory[3];

        String[] ribbonColour = {"yellow", "red", "blue", "purple", "green"};
        String[] candyFavour = {"lemon", "strawberry", "raspberry"};
        String[] juiceFavour = {"orange", "apple", "grape", "mango"};
        // init ribbon
        for (int i = 0; i < ribbon.length; i++) {
            ribbon[i] = new Inventory(ribbonColour[i], 20, 2);
        }
        // init candy
        for (int i = 0; i < candy.length; i++) {
            candy[i] = new Inventory(candyFavour[i], 10, 5);
        }
        // init juice
        for (int i = 0; i < juice.length; i++) {
            juice[i] = new Inventory(juiceFavour[i], 15, 3);
        }

    }

    public double convertQty(String type, double qty) {
        switch (type) {
            case "ribbons":
                return Converter.convert(qty, Length.feet);
            case "candy":
                return Converter.convert(qty, Weight.pounds);
            case "juice":
                return Converter.convert(qty, Volume.gallons);
        }
        return qty;
    }

    public double processOrder(Order order) {
        Inventory target = new Inventory();
        double price = 0;

        switch (order.getType()) {
            case "ribbons":
                for (int i = 0; i < ribbon.length; i++) {
                    if (ribbon[i].getFavour().equals(order.getFavour())) {
                        target = ribbon[i];
                    }
                }
                break;
            case "candy":
                for (int i = 0; i < candy.length; i++) {
                    if (candy[i].getFavour().equals(order.getFavour())) {
                        target = candy[i];
                    }
                }
                break;
            case "juice":
                for (int i = 0; i < candy.length; i++) {
                    if (juice[i].getFavour().equals(order.getFavour())) {
                        target = juice[i];
                    }
                }
                break;
        }

        // check storage
        // add conveter
        if (target.getQty() < order.getQty()) {

            if (order.getCountry().equalsIgnoreCase("canada")) {
                System.out.println("sorry, we only have " + target.getQty() + " left for " + order.getFavour() + " "
                        + order.getType() + " left for your order");
                price = target.getQty() * target.getPrice();
                target.setQty(0);
            } else if (order.getCountry().equalsIgnoreCase("usa")) {
                if (order.getType().equalsIgnoreCase("ribbons")) {
                    System.out.println("sorry, we only have " + Converter.convert(target.getQty(), Length.meters) + " meters left for " + order.getFavour() + " "
                            + order.getType() + " left for your order");
                    price = target.getQty() * target.getPrice();
                    target.setQty(0);
                } else if (order.getType().equalsIgnoreCase("candy")) {
                    System.out.println("sorry, we only have " + Converter.convert(target.getQty(), Weight.kilos) + " kilos left for " + order.getFavour() + " "
                            + order.getType() + " left for your order");
                    price = target.getQty() * target.getPrice();
                    target.setQty(0);

                } else if (order.getType().equalsIgnoreCase("juice")) {
                    System.out.println("sorry, we only have " + Converter.convert(target.getQty(), Volume.liters) + " liters left for " + order.getFavour() + " "
                            + order.getType() + " left for your order");
                    price = target.getQty() * target.getPrice();
                    target.setQty(0);

                }

            }

        } else {
            price = order.getQty() * target.getPrice();
            target.setQty(target.getQty() - order.getQty());
        }

        return price;
    }

    public static void main(String[] args) {

        Converter.setRateUsd(0.78022);
        
        Converter.setRateCad(1.28679);
        
        //Convert meters to feet
        Converter.setRatefeet(0.3048);
        
        //Convert feet to meters
        Converter.setRatemeters(3.28083399);
        
        Converter.setRatepounds(0.45359237);
        Converter.setRategallons(3.78541178);
        Converter.setRateliters(0.264172052);
        Converter.setRatemiles(1.609344);

        Scanner scanner = new Scanner(System.in);
        String decision = "";
        Store store = new Store();
        
        
        do {
            
            double distance = 0;
            double price = 0;
            System.out.println("Please enter the customer name");
            String name = scanner.next();
            System.out.println("Please enter country");
            String country = scanner.next();

            if (country.equalsIgnoreCase("canada")) {
                String buyFinish = "";
                do {
                    System.out.println("Please enter type of product: ribbons, candy, juice");
                    String type = scanner.next();
                    System.out.println("Please enter the favour/colour u want to buy");
                    String favour = scanner.next();
                    System.out.println("Please enter the quantity you want to buy");
                    double qty = scanner.nextDouble();
                    price += store.processOrder(new Order(type, favour, qty, country));
                    
                    System.out.println("Price for this product: " + price + " CCCAD");
                    
                    System.out.println("Do you want to continue ordering");
                    buyFinish = scanner.next();
                } while (buyFinish.toUpperCase().equals("Y"));

                System.out.println("Please enter the distance for delivery in miles");
                distance = scanner.nextDouble();
                price += Math.ceil(distance);
                System.out.println("Final Bill for customer - " + name + " - Total for all the orders: "  + price + " CAD");
            } else {
                String buyFinish = "";
                do {
                    System.out.println("Please enter type of product: ribbons, candy, juice");
                    String type = scanner.next();
                    System.out.println("Please enter the favour/colour u want to buy");
                    String favour = scanner.next();
                    System.out.println("Please enter the quantity you want to buy");
                    double qty = scanner.nextDouble();
                    qty = store.convertQty(type, qty);
                    price += store.processOrder(new Order(type, favour, qty, country));
                    
                    System.out.println("Do you want to continue ordering");
                    buyFinish = scanner.next();
                } while (buyFinish.toUpperCase().equals("Y"));

                System.out.println("Please enter the distance for delivery in miles");
                distance = scanner.nextDouble();
                distance = Converter.convert(distance, Distance.miles);
                
                
                 price += Math.ceil(distance);
                 price = Converter.convert(price, Currency.USD);
                 System.out.println("Final Bill for customer - " + name + " - Total for all the orders: " + price + " USD");

            }

            // todo: convert
            
            System.out.print("do you have next customer in the queue? Y/N / y/n: ");
            decision = scanner.next();
        } while (decision.toUpperCase().equals("Y"));

    }

}
