package christmas.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final Map<String, Integer> products = new HashMap<>();

    public void addProduct(String productName, int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (products.containsKey(productName)) {
            throw new IllegalArgumentException("Duplicate product name: " + productName);
        }
        if (20 < this.getTotalQuantity() + quantity) {
            throw new IllegalArgumentException("Too much products");
        }
        products.put(productName, quantity);
    }

    public int getTotalQuantity() {
        return products.values().stream().mapToInt(i -> i).sum();
    }

    public List<String> getProductsNames() {
        return new ArrayList<>(products.keySet());
    }

    public int getQuantity(String productName) {
        if (!products.containsKey(productName)) {
            throw new IllegalArgumentException("Product " + productName + " does not exist");
        }
        return products.get(productName);
    }
}
