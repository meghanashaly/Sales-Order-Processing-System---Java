import java.util.*;

public class Order {
    private Customer customer;
    private Map<Product, Integer> products = new HashMap<>();
    private double total;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
        total += product.getPrice() * quantity;
    }

    public Customer getCustomer() { return customer; }
    public Map<Product, Integer> getProducts() { return products; }
    public double getTotal() { return total; }
}
