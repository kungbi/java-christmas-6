package christmas.domain;

public class Order {
    private final String productName;
    private final int quantity;

    public Order(String productName, int quantity) {
        validate(productName, quantity);
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    private void validate(String productName, int quantity) {
        if (productName == null) {
            throw new IllegalArgumentException("Product name cannot be null");
        }
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity cannot be less than 1");
        }
    }
}
