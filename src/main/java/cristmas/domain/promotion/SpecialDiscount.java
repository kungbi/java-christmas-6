package cristmas.domain.promotion;

import java.util.List;

public class SpecialDiscount {
    public static final int DISCOUNT_AMOUNT = 1_000;
    private static final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);

    public static int calculateDiscount(int day) {
        if (!isAvailable(day)) {
            return 0;
        }
        return DISCOUNT_AMOUNT;
    }

    private static boolean isAvailable(int day) {
        return SPECIAL_DAYS.contains(day);
    }

}
