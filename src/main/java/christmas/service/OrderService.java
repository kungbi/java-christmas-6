package christmas.service;

import christmas.domain.Order;
import christmas.repository.OrderRepository;
import christmas.repository.ProductRepository;
import java.util.List;

public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public void addOrder(List<Order> order) {
        for (Order orderItem : order) {
            if (!productRepository.exists(orderItem.getProductName())) {
                throw new IllegalStateException("Product does not exist");
            }
            orderRepository.add(orderItem);
        }
        orderRepository.stopAdding();
    }
}
