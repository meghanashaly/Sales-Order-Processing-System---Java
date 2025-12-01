import java.util.*;

public class Invoice {
    private int invoiceID;
    private Order order;
    private Date date;
    private String paymentStatus;

    public Invoice(int invoiceID, Order order, Date date, String paymentStatus) {
        this.invoiceID = invoiceID;
        this.order = order;
        this.date = date;
        this.paymentStatus = paymentStatus;
    }

    public int getInvoiceID() { return invoiceID; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========== Invoice ==========
");
        sb.append("Invoice ID: ").append(invoiceID).append("\n");
        sb.append("Date: ").append(date).append("\n");
        sb.append("Customer: ").append(order.getCustomer().getName()).append("\n");
        sb.append("----------------------------\n");
        sb.append("Products:\n");

        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            sb.append(product.getName())
              .append(" x ").append(qty)
              .append(" = ₹").append(product.getPrice() * qty).append("\n");
        }

        sb.append("----------------------------\n");
        sb.append("Total: ₹").append(order.getTotal()).append("\n");
        sb.append("Payment Status: ").append(paymentStatus).append("\n");
        sb.append("Thank you for shopping with us!\n");
        sb.append("============================\n");
        return sb.toString();
    }
}
