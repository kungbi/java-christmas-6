package christmas.service;

import christmas.domain.Order;
import christmas.domain.Product;
import christmas.repository.OrderRepository;
import christmas.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

public class PriceService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public PriceService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public int getTotalPrice() {
        List<Order> all = orderRepository.findAll();
        int totalPrice = 0;

        for (Order order : all) {
            Product product = getProduct(order);
            totalPrice += product.getPrice() * order.getQuantity();
        }
        return totalPrice;
    }

    private Product getProduct(Order order) {
        Optional<Product> product = productRepository.findByName(order.getProductName());
        if (product.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return product.get();
    }
}
