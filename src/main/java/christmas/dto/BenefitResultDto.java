package christmas.dto;

import christmas.enums.Badge;
import christmas.enums.BenefitType;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public record BenefitResultDto(
        int day,
        List<ItemDto> orderedItems,
        int totalPrice,
        Optional<ItemDto> giveaway,
        Map<BenefitType, Integer> benefits,
        int totalBenefitAmount,
        int expectedPaymentAmount,
        Optional<Badge> badge
) {

    public static class Builder {
        int day;
        List<ItemDto> orderedItems;
        int totalPrice;
        Optional<ItemDto> giveaway;
        Map<BenefitType, Integer> benefits;
        int totalBenefitAmount;
        int expectedPaymentAmount;
        Optional<Badge> badge;

        public Builder day(int day) {
            this.day = day;
            return this;
        }

        public Builder orderedItems(List<ItemDto> orderedItems) {
            this.orderedItems = orderedItems;
            return this;
        }

        public Builder totalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder giveaway(Optional<ItemDto> giveaway) {
            this.giveaway = giveaway;
            return this;
        }

        public Builder benefits(Map<BenefitType, Integer> benefits) {
            this.benefits = benefits;
            return this;
        }

        public Builder totalBenefitAmount(int totalBenefitAmount) {
            this.totalBenefitAmount = totalBenefitAmount;
            return this;
        }

        public Builder expectedPaymentAmount(int expectedPaymentAmount) {
            this.expectedPaymentAmount = expectedPaymentAmount;
            return this;
        }

        public Builder badge(Optional<Badge> badge) {
            this.badge = badge;
            return this;
        }

        public BenefitResultDto build() {
            return new BenefitResultDto(day, orderedItems, totalPrice, giveaway, benefits,
                    totalBenefitAmount,
                    expectedPaymentAmount, badge);
        }
    }
}
