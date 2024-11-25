package domain.product;

public class Product {
    private final String name;
    private final int price;
    private final ProductType type;

    public Product(String name, int price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
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
