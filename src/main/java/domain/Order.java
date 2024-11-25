package domain;

public class Order {
    private final String productName;
    private final int quantity;

    public Order(String productName, int quantity) {
        validate(productName, quantity);
        this.productName = productName;
        this.quantity = quantity;
    }

    private void validate(String productName, int quantity) {
        if (productName == null) {
            throw new IllegalArgumentException();
        }
        if (quantity < 1) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Order{" +
               "productName='" + productName + '\'' +
               ", quantity=" + quantity +
               '}';
    }
}
