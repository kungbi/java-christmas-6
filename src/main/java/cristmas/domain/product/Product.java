package cristmas.domain.product;

import cristmas.enums.ProductType;

public class Product {
    private final String name;
    private final int price;
    private final ProductType type;

    public Product(String name, int price, ProductType type) {
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

    @Override
    public String toString() {
        return "Product{" +
               "name='" + name + '\'' +
               ", price=" + price +
               ", type=" + type +
               '}';
    }
}
