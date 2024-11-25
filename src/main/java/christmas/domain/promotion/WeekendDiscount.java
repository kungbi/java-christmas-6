package christmas.domain.promotion;

import christmas.dto.ItemDto;
import christmas.enums.DayOfWeek;
import christmas.enums.ProductType;
import java.util.List;

public class WeekendDiscount {
    private static final int DISCOUNT_AMOUNT = 2_023;
    private static final List<DayOfWeek> APPLICABLE_DAYS_OF_WEEK = List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);

    public static int calculateDiscount(ItemDto item, DayOfWeek dayOfWeek) {
        if (!isAvailable(item, dayOfWeek)) {
            return 0;
        }
        return item.quantity() * DISCOUNT_AMOUNT;
    }

    private static boolean isAvailable(ItemDto item, DayOfWeek dayOfWeek) {
        return APPLICABLE_DAYS_OF_WEEK.contains(dayOfWeek) && item.product().type() == ProductType.MAIN;
    }
}
