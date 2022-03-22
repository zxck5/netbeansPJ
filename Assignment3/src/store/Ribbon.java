package store;

public class Ribbon extends Item {
//	Ribbons – yellow, red, blue, purple, green, 20 m of each, 2 CAD/meter
    // all in meters as a default

    private String color;

    public Ribbon(double price, String color) {
        super(price);
        this.color = color;
    }

    public Ribbon(double price) {
        // TODO Auto-generated constructor stub
        super(price);

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
