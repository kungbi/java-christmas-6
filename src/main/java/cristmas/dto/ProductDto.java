package cristmas.dto;

import cristmas.domain.product.Product;
import cristmas.enums.ProductType;

public record ProductDto(String name, int price, ProductType type) {

    public static ProductDto from(Product product) {
        return new ProductDto(product.getName(), product.getPrice(), product.getType());
    }
}
