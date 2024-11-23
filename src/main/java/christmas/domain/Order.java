package christmas.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final Map<String, Integer> products = new HashMap<>();

    public void addProduct(String productName, int quantity) {
        products.put(productName, quantity);
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
