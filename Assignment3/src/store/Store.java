package store;

import utilities.Converter;
import utilities.Currency;
import java.util.HashMap;

//
//import utilities.Converter;
//import utilities.Currency;
public class Store {

    // inventory info
//	•	Ribbons – yellow, red, blue, purple, green, 20 m of each, 2 CAD/meter
//	•	Candy – lemon, strawberry, raspberry, 10 kg of each, 5 CAD/kilogram
//	•	Juice – orange, apple, grape, mango, 15 l of each, 3 CAD/liter
    private static Ribbon ribbon;
    private static Candy candy;
    private static Juice juice;
//	static ArrayList<Items> inventory;
    private static HashMap<String, Double> rib;
    private static HashMap<String, Double> can;
    private static HashMap<String, Double> jui;

    public static void initInventory() {
        setRibbon(new Ribbon(2)); // 2 for each meter
        setCandy(new Candy(5)); // 5 for each kilos
        setJuice(new Juice(3)); // 3 for each litre
//		inventory.addAll(ribbon, candy, juice);
        rib = new HashMap<String, Double>(5);
        rib.put("yellow", 20.0);
        rib.put("red", 20.0);
        rib.put("blue", 20.0);
        rib.put("purple", 20.0);
        rib.put("green", 20.0);

        can = new HashMap<String, Double>(3);
        can.put("lemon", 10.0);
        can.put("strawberry", 10.0);
        can.put("raspberry", 10.0);

        jui = new HashMap<String, Double>(4);
        jui.put("orange", 15.0);
        jui.put("apple", 15.0);
        jui.put("grape", 15.0);
        jui.put("mango", 15.0);

        System.out.println("--------------inventory--------------");
        System.out.println(rib);
        System.out.println(can);
        System.out.println(jui);
        System.out.println("-----------------------------------");
    }

    public double processOrders(Order o) {

        double bill = 0;

        double curRibLength = (double) Math.round(Converter.convertToDefault(o.getRibLength(), o.getCountry(), "meter") * 100) / 100;
        double curCandyWeight = (double) Math.round(Converter.convertToDefault(o.getCandyWeight(), o.getCountry(), "kg") * 100) / 100;
        double curJuiceVol = (double) Math.round(Converter.convertToDefault(o.getJuiceVol(), o.getCountry(), "liter") * 100) / 100;
        // ribbon inventory
        double remaining = rib.get(o.getRibColor());
        if (rib.containsKey(o.getRibColor())) {
            if (remaining < curRibLength) {
                curRibLength = remaining;
                rib.put(o.getRibColor(), 0.0);
            } else {
                rib.put(o.getRibColor(), (double)Math.round((remaining - curRibLength)*100)/100);
            }

        }
        // candy
        remaining = can.get(o.getCandyType());
        if (can.containsKey(o.getCandyType())) {
            if (remaining < curCandyWeight) {
                curCandyWeight = remaining;
                can.put(o.getCandyType(), 0.0);
            } else {
                can.put(o.getCandyType(), (double)Math.round((remaining - curCandyWeight)*100)/100);
            }
        }
        // juice
        remaining = jui.get(o.getJuiceType());
        if (jui.containsKey(o.getJuiceType())) {
            if (remaining < curJuiceVol) {
                curJuiceVol = remaining;
                jui.put(o.getJuiceType(), 0.0);
            } else {
                jui.put(o.getJuiceType(), (double)Math.round((remaining - curJuiceVol)*100)/100);
            }
        }

        bill += curRibLength * ribbon.getPrice() + curCandyWeight * candy.getPrice() + curJuiceVol * juice.getPrice() + o.getDelDistance() * 1;
        bill = (double) Math.round(bill * 100) / 100;

        System.out.println("ribLength=" + curRibLength);
        System.out.println("curCandyWeight=" + curCandyWeight);
        System.out.println("curJuiceVol=" + curJuiceVol);
        System.out.println("o.getDelDistance()=" + o.getDelDistance());
        
        System.out.println("bill=" + bill);

        System.out.println("-------------------------------");
        System.out.println(rib);
        System.out.println(can);
        System.out.println(jui);
        System.out.println("-------------------------------");

        if (o.getCountry().equalsIgnoreCase("usa")) {
            bill = (double) Math.round(Converter.convertCurrency(bill, Currency.USD) * 100) / 100;
        }
        if (curRibLength == 0 && curCandyWeight == 0 && curJuiceVol == 0) {
            return bill = 0;
        }

        return bill;
    }

    //yellow, red, blue, purple, green
    public static Ribbon getRibbon() {
        return ribbon;
    }

    public static void setRibbon(Ribbon ribbon) {
        Store.ribbon = ribbon;
    }

    public static Candy getCandy() {
        return candy;
    }

    public static void setCandy(Candy candy) {
        Store.candy = candy;
    }

    public static Juice getJuice() {
        return juice;
    }

    public static void setJuice(Juice juice) {
        Store.juice = juice;
    }

    public static HashMap<String, Double> getRib() {
        return rib;
    }

    public static HashMap<String, Double> getCan() {
        return can;
    }

    public static HashMap<String, Double> getJui() {
        return jui;
    }
}
