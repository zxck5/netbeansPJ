package utilities;

public class Converter {

    private static double rateUsd;

    private static double rateFt;

    private static double rateLbs;

    private static double rateGal;

    private static double rateMiles;

    public static double convertToDefault(double amount, String country, String type) {
        // if check is false, it means convert to not default ex) cad-> usd 
//		if it is true, usd -> cad
        if (country.equalsIgnoreCase("usa")) { // if it is usa, foot is changed to meter ....
            switch (type) {
                // 1 meter --> 3.28084 foot , 1 foot --> 1/(3.28084 ) meter
                case "meter":
                    return amount /= rateFt;
                case "kg":
                    return amount /= rateLbs;
                case "liter":
                    return amount /= rateGal;
                case "distance":
                    return amount /= rateMiles;
            }
        }
        return amount;

    }

    public static double convertToImperial(double amount, String country, String type) {
        if (country.equalsIgnoreCase("usa")) {
            switch (type) {
                // 1 meter --> 3.28084 foot , 1 foot --> 1/(3.28084 ) meter
                case "feet":
                    return amount *= rateFt;
                case "lbs":
                    return amount *= rateLbs;
                case "gal":
                    return amount *= rateGal;
                case "miles":
                    return amount *= rateMiles;
            }
        }
        return amount;
    }

    public static double convertCurrency(double amount, Currency currency) {
        switch (currency) {
            case USD:
                return amount * rateUsd;
            default:
                return amount;
        }
    }

    public static double getRateUsd() {
        return rateUsd;
    }

    public static void setRateUsd(double rateUsd) {
        Converter.rateUsd = rateUsd;
    }

    public static double getRateFt() {
        return rateFt;
    }

    public static void setRateFt(double rateFt) {
        Converter.rateFt = rateFt;
    }

    public static double getRateLbs() {
        return rateLbs;
    }

    public static void setRateLbs(double rateLbs) {
        Converter.rateLbs = rateLbs;
    }

    public static double getRateGal() {
        return rateGal;
    }

    public static void setRateGal(double rateGal) {
        Converter.rateGal = rateGal;
    }

    public static double getRateMiles() {
        return rateMiles;
    }

    public static void setRateMiles(double rateMiles) {
        Converter.rateMiles = rateMiles;
    }

}
