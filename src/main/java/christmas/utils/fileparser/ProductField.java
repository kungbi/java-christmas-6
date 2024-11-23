package christmas.utils.fileparser;


import christmas.enums.ProductType;

public record ProductField(String name, int price, ProductType type) {
}