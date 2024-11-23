package christmas.service;

import christmas.domain.Order;
import christmas.dto.OrderItem;
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

    public void addOrder(List<OrderItem> orders) {
        for (OrderItem orderItem : orders) {
            if (!productRepository.exists(orderItem.name())) {
                throw new IllegalStateException("Product does not exist");
            }
            orderRepository.add(new Order(orderItem.name(), orderItem.quantity()));
        }
        if (!validateOrder(orders)) {
            throw new IllegalArgumentException("Invalid order");
        }
    }

    private boolean validateOrder(List<OrderItem> orders) {
        if (orderRepository.getTotalQuantity() == 0) {
            return false;
        }
        for (OrderItem orderItem : orders) {
            ProductType type = getProductType(orderItem);
            if (type != ProductType.DRINK) {
                return true;
            }
        }
        return false;
    }

    private ProductType getProductType(OrderItem orderItem) {
        return productRepository.findByName(orderItem.name()).get().getType();
    }
}
