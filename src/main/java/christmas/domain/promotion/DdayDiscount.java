package christmas.domain.promotion;

public class DdayDiscount {
    private static final int DEFAULT_DISCOUNT = 1_000;
    private static final int DISCOUNT_PER_DAY = 100;
    private static final int START_DAY = 1;
    private static final int END_DAY = 25;

    public int getDiscountAmount(int day) {
        if (!this.isAvailable(day)) {
            return 0;
        }

        return DEFAULT_DISCOUNT + (day - START_DAY) * DISCOUNT_PER_DAY;
    }

    private boolean isAvailable(int day) {
        return START_DAY <= day && day <= END_DAY;
    }
}
