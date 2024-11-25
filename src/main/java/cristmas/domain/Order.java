package cristmas.domain;

import cristmas.domain.product.Product;
import cristmas.enums.ProductType;

public class Order {
    private final Product product;
    private final int quantity;

    public Order(Product product, int quantity) {
        validate(product, quantity);
        this.product = product;
        this.quantity = quantity;
    }

    public ProductType getProductType() {
        return this.product.getType();
    }

    public int getQuantity() {
        return quantity;
    }

    private void validate(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        if (quantity < 1) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Order{" +
               "product=" + product +
               ", quantity=" + quantity +
               '}';
    }
}
