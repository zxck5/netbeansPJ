package store;

public class Juice extends Item {
    //Juice – orange, apple, grape, mango, 15 l of each, 3 CAD/liter
    // default

    private String flavor;

    public Juice(double price) {
        super(price);
    }

    public Juice(double price, String flavor) {
        // TODO Auto-generated constructor stub
        super(price);
        this.flavor = flavor;
    }

    public String getType() {
        return flavor;
    }

    public void setType(String flavor) {
        this.flavor = flavor;
    }

}
