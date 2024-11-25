package christmas.domain.product;


import christmas.enums.ProductType;

public record ProductField(String name, int price, ProductType type) {
}