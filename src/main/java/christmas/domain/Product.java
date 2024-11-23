package christmas.domain;

import christmas.enums.ProductType;

public class Product {
    private final String name;
    private final int price;
    private final ProductType type;

    public Product(String name, int price, ProductType type) {
        validate(name, price, type);
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ProductType getType() {
        return type;
    }

    private void validate(String name, int price, ProductType type) {
        if (name == null) {
            throw new IllegalArgumentException("Product name cannot be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Product price cannot be negative");
        }
        if (type == null) {
            throw new IllegalArgumentException("Product type cannot be null");
        }
    }
}
