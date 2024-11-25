package cristmas.domain;

import cristmas.domain.product.Product;
import cristmas.enums.ProductType;
import cristmas.validator.OrderValidator;

public class Order {
    private final Product product;
    private final int quantity;

    public Order(Product product, int quantity) {
        OrderValidator.validate(product, quantity);
        this.product = product;
        this.quantity = quantity;
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
