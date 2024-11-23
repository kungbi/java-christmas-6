package christmas.validator;

import christmas.dto.OrderItem;
import christmas.repository.ProductRepository;
import java.util.List;

public class InputValidator {
    private final ProductRepository productRepository;

    public InputValidator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void dayValidate(int day) {
        if (!(1 <= day && day <= 31)) {
            throw new IllegalArgumentException();
        }
    }

    public void orderItemsValidate(List<OrderItem> orderItems) {
        if (orderItems.stream().map(OrderItem::name).distinct().count() != orderItems.size()) {
            throw new IllegalArgumentException();
        }
        for (OrderItem orderItem : orderItems) {
            if (orderItem.quantity() < 1) {
                throw new IllegalArgumentException();
            }
            if (orderItem.name().isBlank()) {
                throw new IllegalArgumentException();
            }
            if (!productRepository.exists(orderItem.name())) {
                throw new IllegalArgumentException();
            }
        }
    }
}
