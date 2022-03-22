package store;

public class Inventory {

    private String favour;
    private double qty;
    private double price;

    public Inventory(String favour, double qty, double price) {
        this.favour = favour;
        this.qty = qty;
        this.price = price;
    }

    public Inventory() {
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getQty() {
        return this.qty;
    }

    public String getFavour() {
        return this.favour;
    }

    public double getPrice() {
        return this.price;
    }


}
