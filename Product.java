public class Product {
    private int productID;
    private String name;
    private double price;
    private int stock;

    public Product(int productID, String name, double price, int stock) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public void reduceStock(int qty) { stock -= qty; }

    @Override
    public String toString() {
        return name + " (₹" + price + ")";
    }
}
