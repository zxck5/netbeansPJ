package store;

public class Candy extends Item {
    //Candy – lemon, strawberry, raspberry, 10 kg of each, 5 CAD/kilogram
    // kilo as default

    private String flavor;

    public Candy(double price) {
        super(price);
    }

    public Candy(double price, String type) {
        super(price);
        this.flavor = type;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String type) {
        this.flavor = type;
    }
}
