package christmas.service;

import christmas.domain.Order;
import christmas.domain.Product;
import christmas.domain.promotion.DayOfWeekDiscount;
import christmas.domain.promotion.DdayDiscount;
import christmas.domain.promotion.GiveWayEvent;
import christmas.domain.promotion.SpecialDiscount;
import christmas.dto.PromotionPreview.GiveWayProduct;
import christmas.dto.PromotionPreview.PromotionHistory;
import christmas.enums.DayOfWeek;
import christmas.enums.ProductType;
import christmas.enums.PromotionType;
import christmas.repository.OrderRepository;
import christmas.repository.ProductRepository;
import java.util.Optional;

public class PromotionService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final DdayDiscount dDayDiscount;
    private final SpecialDiscount specialDiscount;
    private final GiveWayEvent giveWayEvent;

    public PromotionService(ProductRepository productRepository, OrderRepository orderRepository,
                            DdayDiscount dDayDiscount, SpecialDiscount specialDiscount,
                            GiveWayEvent giveWayEvent) {
        this.orderRepository = orderRepository;
        this.dDayDiscount = dDayDiscount;
        this.productRepository = productRepository;
        this.specialDiscount = specialDiscount;
        this.giveWayEvent = giveWayEvent;
    }

    public PromotionHistory getDdayDiscountAmount(int day) {
        return new PromotionHistory(PromotionType.D_DAY, dDayDiscount.getDiscountAmount(day));
    }

    public PromotionHistory getDayOfWeekDiscountAmount(DayOfWeek dayOfWeek) {
        DayOfWeekDiscount dayOfWeekDiscount = DayOfWeekDiscount.of(dayOfWeek);
        int discountAmount = 0;

        for (Order order : orderRepository.findAll()) {
            ProductType type = getProductType(order.getProductName());
            discountAmount += dayOfWeekDiscount.getDiscountAmount(type) * order.getQuantity();
        }

        return new PromotionHistory(DayOfWeekDiscount.getPromotionType(dayOfWeek), discountAmount);
    }

    public PromotionHistory specialDiscountAmount(int day) {
        return new PromotionHistory(PromotionType.SPECIAL, specialDiscount.getDiscountAmount(day));
    }

    public Optional<GiveWayProduct> getGiveWayProduct(int amountPurchased) {
        if (giveWayEvent.isAvailable(amountPurchased)) {
            Product product = getProduct(giveWayEvent.getGiveWayProductName());
            return Optional.of(new GiveWayProduct(product.getName(), product.getPrice(), 1));
        }
        return Optional.empty();
    }

    public boolean isApplicableAmount(int totalPrice) {
        return 10_000 <= totalPrice;
    }

    private Product getProduct(String productName) {
        Optional<Product> product = this.productRepository.findByName(giveWayEvent.getGiveWayProductName());
        if (product.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return product.get();
    }

    private ProductType getProductType(String productName) {
        Optional<Product> product = this.productRepository.findByName(productName);
        if (product.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }
        return product.get().getType();
    }

}
