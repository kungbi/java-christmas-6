package christmas.dto;

import christmas.domain.product.Product;
import christmas.enums.ProductType;

public record ProductDto(String name, int price, ProductType type) {

    public static ProductDto from(Product product) {
        return new ProductDto(product.getName(), product.getPrice(), product.getType());
    }
}
