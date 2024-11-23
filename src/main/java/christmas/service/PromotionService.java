package christmas.service;

import christmas.domain.Order;
import christmas.domain.Product;
import christmas.domain.promotion.DayOfWeekDiscount;
import christmas.domain.promotion.DdayDiscount;
import christmas.domain.promotion.GiveWayEvent;
import christmas.domain.promotion.SpecialDiscount;
import christmas.enums.DayOfWeek;
import christmas.enums.ProductType;
import christmas.repository.OrderRepository;
import christmas.repository.ProductRepository;
import java.util.Optional;

public class PromotionService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final DdayDiscount dDayDiscount;
    private final SpecialDiscount specialDiscount;
    private final GiveWayEvent giveWayEvent;

    public PromotionService(OrderRepository orderRepository, DdayDiscount dDayDiscount,
                            ProductRepository productRepository, SpecialDiscount specialDiscount,
                            GiveWayEvent giveWayEvent) {
        this.orderRepository = orderRepository;
        this.dDayDiscount = dDayDiscount;
        this.productRepository = productRepository;
        this.specialDiscount = specialDiscount;
        this.giveWayEvent = giveWayEvent;
    }

    public int getDdayDiscountAmount(int day) {
        return dDayDiscount.getDiscountAmount(day);
    }

    public int getDayOfWeekDiscountAmount(DayOfWeek dayOfWeek) {
        DayOfWeekDiscount dayOfWeekDiscount = DayOfWeekDiscount.of(dayOfWeek);
        int discountAmount = 0;

        for (Order order : orderRepository.findAll()) {
            ProductType type = getProductType(order.getProductName());
            discountAmount += dayOfWeekDiscount.getDiscountAmount(type) * order.getQuantity();
        }

        return discountAmount;
    }

    public int specialDiscountAmount(int day) {
        return specialDiscount.getDiscountAmount(day);
    }

    public Optional<Product> getGiveWayProduct(int amountPurchased) {
        if (giveWayEvent.isAvailable(amountPurchased)) {
            return this.productRepository.findByName(giveWayEvent.getGiveWayProductName());
        }
        return Optional.empty();
    }

    private ProductType getProductType(String productName) {
        Optional<Product> product = this.productRepository.findByName(productName);
        if (product.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }
        return product.get().getType();
    }

}
