package store;

import utilities.Converter;
import java.util.Scanner;

public class Order {

    // order info
    private String clientName;
    private String country;
    private String ribColor;
    private double ribLength;
    private String candyType;
    private double candyWeight;
    private String juiceType;
    private double juiceVol;
    private double delDistance;

    private String ribbonUnit;
    private String candyUnit;
    private String juiceUnit;
    private String distanceUnit;

//	private ArrayList<Item> Basket bas ;
    Scanner scan = new Scanner(System.in);

    public void getOrders() {
        // TODO Auto-generated method stub
        while (true) {
            System.out.println("cilent name:");
            setClientName(scan.next());
            System.out.println("country: canada/usa");

            String country = scan.next();
            while (!validateCountry(country)) {
                System.out.println("invalid country");
                System.out.println("try again");
                country = scan.next();
            }
            this.country = country;
            //yellow, red, blue, purple, green
            System.out.println("ribbon color: yellow/red/blue/purple/green");

            String color = scan.next();
            while (!Store.getRib().containsKey(color.toLowerCase())) {
                System.out.println("invalid color");
                System.out.println("try again");
                color = scan.next();
            }
            this.ribColor = color;

            System.out.println("ribbon length in " + ribbonUnit);
            double ribLength = scan.nextDouble();
            double remaining = Converter.convertToImperial(Store.getRib().get(this.ribColor), country, "feet");
            if (remaining == 0) {
                System.out.println("no stock avaialble");
            } else {
                if (remaining < ribLength) {
                    remaining = (double)Math.round(remaining*100)/100;
                    System.out.println("We have only" + remaining + this.ribbonUnit + " of " + this.ribColor + " ribbon left for you order");
                }
            }
            this.ribLength = ribLength;

            System.out.println("candy type: lemon/strawberry/raspberry");
            String flavor = scan.next();
            while (!Store.getCan().containsKey(flavor.toLowerCase())) {
                System.out.println("invalid flavor");
                System.out.println("try again");
                flavor = scan.next();
            }
            this.candyType = flavor;

            System.out.println("candy weight in " + candyUnit);
            double candyWeight = scan.nextDouble();
            remaining = Converter.convertToImperial(Store.getCan().get(this.candyType), country, "lbs");
            if (remaining == 0) {
                System.out.println("no stock available");
            } else {
                if (remaining < candyWeight) {
                    // converting if country is usa, if not it doesn't convert
                    remaining = (double)Math.round(remaining*100)/100;
                    System.out.println("We have only" + remaining + this.candyUnit + " of " + this.candyType + " candy left for you order");
                }
                this.candyWeight = candyWeight;
            }

            System.out.println("type of juice: orange/apple/grape/mango");
            String juiceFlavor = scan.next();
            while (!Store.getJui().containsKey(juiceFlavor.toLowerCase())) {
                System.out.println("invalid juice");
                System.out.println("try again");
                juiceFlavor = scan.next();
            }
            setJuiceType(juiceFlavor);

            System.out.println("volume of juice in " + juiceUnit);
            double juiceVol = scan.nextDouble();
            remaining = Converter.convertToImperial(Store.getJui().get(this.juiceType), country, "gal");
            if (remaining == 0) {
                System.out.println("no stock available");
            } else {
                if (remaining < juiceVol) { // cad to usd
                    remaining = (double)Math.round(remaining*100)/100;
                    System.out.println("We have only" + remaining + this.juiceUnit + " of " + this.juiceType + " juice left for you order");
                }
                this.juiceVol = juiceVol;
            }

            System.out.println("distance for delivery in " + this.distanceUnit);
            
            this.delDistance = Converter.convertToImperial(scan.nextDouble(), country, "miles");
            break;

        }
    }

    public boolean validateCountry(String country) {
        // TODO Auto-generated method stub
        if (country.equalsIgnoreCase("usa")) {
            ribbonUnit = "feet";
            candyUnit = "pounds";
            juiceUnit = "gallons";
            setDistanceUnit("miles");
            return true;
        } else if (country.equalsIgnoreCase("canada")) {
            ribbonUnit = "meter";
            candyUnit = "kg";
            juiceUnit = "litre";
            setDistanceUnit("kilometers");
            return true;

        }
        return false;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRibColor() {
        return ribColor;
    }

    public void setRibColor(String ribColor) {
        this.ribColor = ribColor;
    }

    public double getRibLength() {
        return ribLength;
    }

    public void setRibLength(double ribLength) {
        this.ribLength = ribLength;
    }

    public String getCandyType() {
        return candyType;
    }

    public void setCandyType(String candyType) {
        this.candyType = candyType;
    }

    public double getCandyWeight() {
        return candyWeight;
    }

    public void setCandyWeight(double candyWeight) {
        this.candyWeight = candyWeight;
    }

    public String getJuiceType() {
        return juiceType;
    }

    public void setJuiceType(String juiceType) {
        this.juiceType = juiceType;
    }

    public double getJuiceVol() {
        return juiceVol;
    }

    public void setJuiceVol(double juiceVol) {
        this.juiceVol = juiceVol;
    }

    public double getDelDistance() {
        return delDistance;
    }

    public void setDelDistance(double delDistance) {
        this.delDistance = delDistance;
    }

    public String getRibbonUnit() {
        return this.ribbonUnit;
    }

    public String getCandyUnit() {
        return this.ribbonUnit;
    }

    public String getJuiceUnit() {
        return this.ribbonUnit;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

}
