package ca.humber.utilities;

public class Converter {
    private static double rateUsd;
    private static double rateEuro;
    private static double rateBp;  
    
    public static double convert(double amount, Currency currency) {
        switch (currency) {
            case USD:
                return amount / rateUsd;
            case EURO:
                return amount / rateEuro;
            case BP:
                return amount / rateBp;    
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
    
    public static void setRateEuro (double rateEuro) {
        Converter.rateEuro = rateEuro;
    }
    
    public static double getRateEuro() {
        return rateEuro;
    }    
    
    public static void setRateBp (double rateBp) {
        Converter.rateBp = rateBp;
    }
    
    public static double getRateBp() {
        return rateBp;
    }     
}
