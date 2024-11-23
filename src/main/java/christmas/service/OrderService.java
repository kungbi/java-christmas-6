package christmas.service;

import christmas.domain.Order;
import christmas.enums.ProductType;
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
        if (!validateOrder(order)) {
            throw new IllegalStateException("Invalid order");
        }
    }

    private boolean validateOrder(List<Order> order) {
        for (Order orderItem : order) {
            ProductType type = getProductType(orderItem);
            if (type != ProductType.DRINK) {
                return true;
            }
        }
        return false;
    }

    private ProductType getProductType(Order orderItem) {
        return productRepository.findByName(orderItem.getProductName()).get().getType();
    }
}
