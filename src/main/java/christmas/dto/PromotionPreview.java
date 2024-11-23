package christmas.dto;

import christmas.enums.Badge;
import christmas.enums.PromotionType;
import java.util.List;
import java.util.Optional;

public record PromotionPreview(List<OrderItem> orderItems, int totalPrice, Optional<GiveWayProduct> giveWayProduct,
                               List<PromotionHistory> promotionHistories, int totalDiscount, int expectedPaymentAmount,
                               Optional<Badge> badge) {
    public record PromotionHistory(PromotionType promotionType, int discountAmount) {

    }

    public record GiveWayProduct(String productName, int totalPrice, int quantity) {
    }
}
