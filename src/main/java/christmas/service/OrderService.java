package christmas.service;

import christmas.domain.Order;
import christmas.dto.MakeOrderInput;
import christmas.dto.OrderItem;
import christmas.repository.ProductRepository;

public class OrderService {
    private final ProductRepository productRepository;

    public OrderService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Order makeOrder(MakeOrderInput input) {
        Order order = new Order();
        validateItems(input);
        for (OrderItem item : input.items()) {
            order.addProduct(item.name(), item.quantity());
        }
        return order;
    }

    private void validateItems(MakeOrderInput input) {
        for (OrderItem item : input.items()) {
            if (!productRepository.exists(item.name())) {
                throw new IllegalStateException("Product with name " + item.name() + " does not exist");
            }
            if (item.quantity() < 1) {
                throw new IllegalStateException("Quantity must be greater than zero");
            }

        }
    }
}
