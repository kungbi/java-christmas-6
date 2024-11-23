package christmas.domain.promotion;

import java.util.List;

public class SpecialDiscount {
    private static final List<Integer> starDays = List.of(3, 10, 17, 24, 25, 31);
    private static final int DISCOUNT_AMOUNT = 1_000;

    public int getDiscountAmount(int day) {
        if (!this.isAvailable(day)) {
            return 0;
        }

        return DISCOUNT_AMOUNT;
    }

    private boolean isAvailable(int day) {
        if (starDays.contains(day)) {
            return true;
        }
        return false;
    }
}
