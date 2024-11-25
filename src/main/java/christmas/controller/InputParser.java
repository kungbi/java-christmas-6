package christmas.controller;

import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.product.Product;
import christmas.repository.ProductRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InputParser {
    public static final int ITEM_NAME_INDEX = 0;
    public static final int ITEM_QUANTITY_INDEX = 1;
    private final ProductRepository productRepository;

    public InputParser(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Orders parseOrders(String input) {
        List<Order> orders = new ArrayList<>();

        List<String> splitInput = Arrays.stream(input.split(",")).toList();
        for (String itemInput : splitInput) {
            List<String> field = Arrays.stream(itemInput.split("-")).toList();

            Optional<Product> product = this.productRepository.findByName(field.get(ITEM_NAME_INDEX));
            if (product.isEmpty()) {
                throw new IllegalArgumentException();
            }
            orders.add(new Order(product.get(), parseInt(field.get(ITEM_QUANTITY_INDEX))));
        }
        return new Orders(orders);
    }

}
