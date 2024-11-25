package christmas.domain.promotion;

import christmas.domain.Order;
import christmas.enums.DayOfWeek;
import christmas.enums.ProductType;
import java.util.List;

public class WeekendDiscount {
    private static final int DISCOUNT_AMOUNT = 2_023;
    private static final List<DayOfWeek> APPLICABLE_DAYS_OF_WEEK = List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);

    public static int calculateDiscount(Order order, DayOfWeek dayOfWeek) {
        if (!isAvailable(order, dayOfWeek)) {
            return 0;
        }
        return order.getQuantity() * DISCOUNT_AMOUNT;
    }

    private static boolean isAvailable(Order order, DayOfWeek dayOfWeek) {
        return APPLICABLE_DAYS_OF_WEEK.contains(dayOfWeek) && order.getProductType() == ProductType.MAIN;
    }
}
