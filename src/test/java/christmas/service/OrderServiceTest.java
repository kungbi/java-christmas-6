package christmas.service;

import christmas.domain.Order;
import christmas.domain.Product;
import christmas.enums.ProductType;
import christmas.repository.OrderRepository;
import christmas.repository.ProductRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    OrderService orderService;


    @BeforeEach
    void setUp() {
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();

        productRepository.add(new Product("음료", 10_000, ProductType.DRINK));
        productRepository.add(new Product("메인음식1", 20_000, ProductType.MAIN));
        productRepository.add(new Product("메인음식2", 20_000, ProductType.MAIN));
        productRepository.add(new Product("에피타이저", 10_000, ProductType.APPETIZER));

        orderService = new OrderService(productRepository, orderRepository);
    }

    @Test
    void 정상() {
        List<Order> orders = List.of(new Order("음료", 5), new Order("메인음식1", 2));

        orderService.addOrder(orders);
    }

    @Test
    void 음료만_담았을_경우() {
        List<Order> orders = List.of(new Order("음료", 5));

        Assertions.assertThrows(IllegalArgumentException.class, () -> orderService.addOrder(orders));
    }

    @Test
    void 개수가_20개_초과_일_경우() {
        List<Order> orders = List.of(new Order("음료", 20), new Order("메인음식1", 1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> orderService.addOrder(orders));
    }

    @Test
    void 개수가_20개() {
        List<Order> orders = List.of(new Order("음료", 19), new Order("메인음식1", 1));

        orderService.addOrder(orders);
    }

    @Test
    void 중복된_상품_주문() {
        List<Order> orders = List.of(new Order("메인음식1", 3), new Order("메인음식1", 1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> orderService.addOrder(orders));
    }


}