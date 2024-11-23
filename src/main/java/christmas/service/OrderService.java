package christmas.service;

import christmas.domain.Order;
import christmas.repository.OrderRepository;
import christmas.repository.ProductRepository;

public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public void addOrder(Order order) {
        if (!productRepository.exists(order.getProductName())) {
            throw new IllegalStateException("Product does not exist");
        }
        orderRepository.add(order);
    }
}
