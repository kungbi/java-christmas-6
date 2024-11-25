package cristmas.domain.product;


import cristmas.enums.ProductType;

public record ProductField(String name, int price, ProductType type) {
}