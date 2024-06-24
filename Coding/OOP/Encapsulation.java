package OOP;

/**
 * description: Encapsulation
 * date: 6/17/24 3:47 PM
 * author: jinhao_pang
 * version: 1.0
 */
public class Encapsulation {
    private String string;
    public static final int integer = 3;
    protected double price = 3;

    public Encapsulation(String string, double aDouble) {
        this.string = string;
        this.price = aDouble;
    }

    public String getNamePrice(){
        return null;
    }


    public void setString(String string) {
        this.string = string;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getString() {
        return string;
    }

    public double getPrice() {
        return price;
    }

}
