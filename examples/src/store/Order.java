package store;

public class Order {
    private String type;
    private String favour;
    private double qty;
    private String country;

    public Order(String type, String favour, double qty, String country) {
        this.type = type.toLowerCase();
        this.favour = favour;
        this.qty = qty;
        this.country = country;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public String getType() {
        return this.type;
    }

    public String getFavour() {
        return this.favour;
    }

    public double getQty() {
        return this.qty;
    }
}
