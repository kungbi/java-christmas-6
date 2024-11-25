package cristmas.validator;

import cristmas.domain.product.Product;

public class OrderValidator {
    public static void validate(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        if (quantity < 1) {
            throw new IllegalArgumentException();
        }
    }

}
