package Utility;

public class Converter {

    private static double rateUsd;
    private static double rateCad;

    private static double ratefeet;
    private static double ratemeters;

    private static double ratepounds;
    private static double ratekilos;

    private static double rategallons;
    private static double rateliters;

    private static double ratemiles;
//    private static double ratekilometers;


    //Convert USD to CAD
    public enum Currency {
        USD,
        CAD
    }

    public static double convert(double amount, Currency currency) {
        switch (currency) {
            case USD:
                return amount * rateUsd;
            case CAD:
                return amount * rateCad;
            default:
                return amount;
        }
    }

    public static void setRateUsd(double rate) {
        rateUsd = rate;
    }

    public static double getRateUsd() {
        return rateUsd;
    }
public static void setRateCad(double rate) {
        rateCad = rate;
    }

    public static double getRateCad() {
        return rateCad;
    }
    //Convert feet to meters
    public enum Length {
        feet,
        meters
    }

    public static double convert(double amount, Length length) {
        switch (length) {
            case feet:
                return amount * ratefeet;
            case meters:
                return amount * ratemeters;
            default:
                return amount;
        }
    }

    public static void setRatefeet(double rate) {
        ratefeet = rate;
    }

    public static double getRatefeet() {
        return ratefeet;
    }

    public static void setRatemeters(double rate) {
        ratemeters = rate;
    }

    public static double getRatemeters() {
        return ratemeters;
    }

    //Convert pounds to kilos
    public enum Weight {
        pounds,
        kilos
    }

    public static double convert(double amount, Weight weight) {
        switch (weight) {
            case pounds:
                return amount * ratepounds;
            case kilos:
                return amount * ratekilos;
            default:
                return amount;
        }
    }

    public static void setRatepounds(double rate) {
        ratepounds = rate;
    }

    public static double getRatepounds() {
        return ratepounds;
    }

    public static void setRatekilos(double rate) {
        ratepounds = rate;
    }

    public static double getRatekilos() {
        return ratepounds;
    }

    //Convert gallons to liters
    public enum Volume {
        gallons,
        liters
    }

    public static double convert(double amount, Volume volume) {
        switch (volume) {
            case gallons:
                return amount * rategallons;
            case liters:
                return amount * rateliters;
            default:
                return amount;
        }
    }

    public static void setRategallons(double rate) {
        rategallons = rate;
    }

    public static double getRategallons() {
        return rategallons;
    }

    public static void setRateliters(double rate) {
        rateliters = rate;
    }

    public static double getRateliters() {
        return rateliters;
    }

    //Convert miles to kilometers
    public static double convert(double amount, Distance distance) {
        switch (distance) {
            case miles:
                return amount * ratemiles;
            default:
                return amount;
        }
    }

    public enum Distance {
        miles
    }

    public static void setRatemiles(double rate) {
        ratemiles = rate;
    }

    public static double getRatemiles() {
        return ratemiles;
    }

}
