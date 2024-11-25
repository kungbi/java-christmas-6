package christmas.service;

import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.product.Product;
import christmas.domain.promotion.DDayDiscount;
import christmas.domain.promotion.GiveawayPromotion;
import christmas.domain.promotion.SpecialDiscount;
import christmas.domain.promotion.WeekdayDiscount;
import christmas.domain.promotion.WeekendDiscount;
import christmas.dto.ApplyPromotionDto;
import christmas.dto.BenefitResultDto;
import christmas.dto.BenefitResultDto.Builder;
import christmas.dto.ItemDto;
import christmas.dto.ProductDto;
import christmas.enums.Badge;
import christmas.enums.BenefitType;
import christmas.enums.DayOfWeek;
import christmas.repository.ProductRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PromotionService {
    private final ProductRepository productRepository;

    public PromotionService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public BenefitResultDto applyPromotion(ApplyPromotionDto input) {
        int day = input.day();
        Orders orders = input.orders();

        int totalPrice = orders.calculateTotalPrice();
        Map<BenefitType, Integer> benefits = new HashMap<>();
        if (10_000 <= totalPrice) {
            benefits = applyPromotion(orders, day,
                    DayOfWeek.getDayOfWeekAsDate(day));
        }
        ItemDto giveaway = null;
        if (GiveawayPromotion.isAvailable(totalPrice)) {
            Optional<Product> product = productRepository.findByName(GiveawayPromotion.getGiveawayProductName());
            if (product.isEmpty()) {
                throw new IllegalArgumentException("Giveaway product not found");
            }
            giveaway = new ItemDto(ProductDto.from(product.get()), GiveawayPromotion.getGiveawayProductQuantity());
            benefits.put(BenefitType.GIVEAWAY, giveaway.product().price() * giveaway.quantity());
        }
        int totalBenefit = benefits.values().stream().mapToInt(Integer::intValue).sum();
        int totalDiscount = benefits.entrySet().stream().filter(entry -> entry.getKey() != BenefitType.GIVEAWAY)
                .mapToInt(entry -> entry.getValue()).sum();

        return new Builder()
                .day(day)
                .orderedItems(orders.toDto())
                .benefits(benefits)
                .giveaway(Optional.ofNullable(giveaway))
                .totalPrice(totalPrice)
                .totalBenefitAmount(totalBenefit)
                .expectedPaymentAmount(totalPrice - totalDiscount)
                .badge(Badge.getBadgeByPaymentAmount(totalDiscount))
                .build();
    }

    private Map<BenefitType, Integer> applyPromotion(Orders orders, int day, DayOfWeek dayOfWeek) {
        Map<BenefitType, Integer> promotions = new HashMap<>();

        promotions.put(BenefitType.D_DAY, DDayDiscount.calculateDiscount(day));
        promotions.put(BenefitType.SPECIAL, SpecialDiscount.calculateDiscount(day));
        for (Order order : orders.getOrders()) {
            promotions.putIfAbsent(BenefitType.WEEKEND, 0);
            promotions.putIfAbsent(BenefitType.WEEKDAY, 0);
            promotions.put(BenefitType.WEEKDAY,
                    promotions.get(BenefitType.WEEKDAY) + WeekdayDiscount.calculateDiscount(order, dayOfWeek));
            promotions.put(BenefitType.WEEKEND,
                    promotions.get(BenefitType.WEEKEND) + WeekendDiscount.calculateDiscount(order, dayOfWeek));
        }

        return promotions;
    }
}
