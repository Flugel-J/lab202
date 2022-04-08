package J1.S.H201;
public class item{
    double price;
    double discount;
    public item(double price, double discount) {
        this.price = price;
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "item{" + "price=" + price + ", discount=" + discount + '}';
    }
    
   
}
