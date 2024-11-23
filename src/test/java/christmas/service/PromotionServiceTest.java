package christmas.service;

import christmas.domain.Order;
import christmas.domain.Product;
import christmas.domain.promotion.DdayDiscount;
import christmas.domain.promotion.GiveWayEvent;
import christmas.domain.promotion.SpecialDiscount;
import christmas.enums.DayOfWeek;
import christmas.enums.ProductType;
import christmas.repository.OrderRepository;
import christmas.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PromotionServiceTest {
    ProductRepository productRepository;
    DdayDiscount ddayDiscount = new DdayDiscount();
    SpecialDiscount specialDiscount = new SpecialDiscount();
    GiveWayEvent giveWayEvent = new GiveWayEvent();


    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();

        productRepository.add(new Product("음료", 10_000, ProductType.DRINK));
        productRepository.add(new Product("메인음식1", 20_000, ProductType.MAIN));
        productRepository.add(new Product("메인음식2", 20_000, ProductType.MAIN));
        productRepository.add(new Product("에피타이저", 10_000, ProductType.APPETIZER));
        productRepository.add(new Product("디저트", 10_000, ProductType.DESERT));
        productRepository.add(new Product("샴페인", 25_000, ProductType.DRINK));
    }


    @Test
    void getDdayDiscountAmount() {
        OrderRepository orderRepository = new OrderRepository();

        PromotionService service = new PromotionService(productRepository, orderRepository, ddayDiscount,
                specialDiscount,
                giveWayEvent);

        Assertions.assertEquals(500, service.getDdayDiscountAmount(5));
    }

    @Test
    void getDayOfWeekDiscountAmount_평일() {
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.add(new Order("메인음식1", 2)); // 60,000원
        orderRepository.add(new Order("디저트", 3)); // 30,000원

        PromotionService service = new PromotionService(productRepository, orderRepository, ddayDiscount,
                specialDiscount,
                giveWayEvent);

        // 디저트에 개수만큼 2023 할인
        Assertions.assertEquals(3 * 2023, service.getDayOfWeekDiscountAmount(DayOfWeek.WEDNESDAY));
    }

    @Test
    void getDayOfWeekDiscountAmount_주말() {
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.add(new Order("메인음식1", 2)); // 40,000원
        orderRepository.add(new Order("디저트", 3)); // 30,000원

        PromotionService service = new PromotionService(productRepository, orderRepository, ddayDiscount,
                specialDiscount,
                giveWayEvent);

        // 디저트에 개수만큼 2023 할인
        Assertions.assertEquals(2 * 2023, service.getDayOfWeekDiscountAmount(DayOfWeek.FRIDAY));
    }

    @Test
    void specialDiscountAmount_적용() {
        OrderRepository orderRepository = new OrderRepository();

        PromotionService service = new PromotionService(productRepository, orderRepository, ddayDiscount,
                specialDiscount,
                giveWayEvent);

        Assertions.assertEquals(1000, service.specialDiscountAmount(10));
    }

    @Test
    void specialDiscountAmount_미적용() {
        OrderRepository orderRepository = new OrderRepository();

        PromotionService service = new PromotionService(productRepository, orderRepository, ddayDiscount,
                specialDiscount,
                giveWayEvent);

        Assertions.assertEquals(0, service.specialDiscountAmount(11));
    }


    @Test
    void getGiveWayProduct_적용() {
        OrderRepository orderRepository = new OrderRepository();
        PromotionService service = new PromotionService(productRepository, orderRepository, ddayDiscount,
                specialDiscount,
                giveWayEvent);

        Assertions.assertTrue(service.getGiveWayProduct(120_000).isPresent());
    }

    @Test
    void getGiveWayProduct_미적용() {
        OrderRepository orderRepository = new OrderRepository();
        PromotionService service = new PromotionService(productRepository, orderRepository, ddayDiscount,
                specialDiscount,
                giveWayEvent);

        Assertions.assertTrue(service.getGiveWayProduct(119_999).isEmpty());
    }
}