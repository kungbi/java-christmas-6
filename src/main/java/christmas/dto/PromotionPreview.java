package christmas.dto;

import christmas.enums.Badge;
import christmas.enums.PromotionType;
import java.util.List;

public record PromotionPreview(List<OrderItem> orderItems, int totalPrice, GiveWayProduct giveWayProduct,
                               List<PromotionHistory> promotionHistories, int totalDiscount, int expectedPaymentAmount,
                               Badge badge) {
    public record PromotionHistory(PromotionType promotionType, int discountAmount) {

    }

    public record GiveWayProduct(String productName, int quantity) {
    }
}
