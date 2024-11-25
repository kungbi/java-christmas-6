package christmas.domain;

import christmas.domain.product.Product;
import christmas.enums.ProductType;
import christmas.validator.OrderValidator;

public class Order {
    private final Product product;
    private final int quantity;

    public Order(Product product, int quantity) {
        OrderValidator.validate(product, quantity);
        this.product = product;
        this.quantity = quantity;
    }

    public String getProductName() {
        return this.product.getName();
    }

    public int getPrice() {
        return this.product.getPrice() * this.quantity;
    }

    public ProductType getProductType() {
        return this.product.getType();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
               "product=" + product +
               ", quantity=" + quantity +
               '}';
    }
}
