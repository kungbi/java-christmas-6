package cristmas.domain.promotion;

import cristmas.domain.Order;
import cristmas.enums.DayOfWeek;
import cristmas.enums.ProductType;
import java.util.List;

public class WeekdayDiscount {
    public static final int DISCOUNT_AMOUNT = 2_023;
    private static final List<DayOfWeek> APPLICABLE_DAYS_OF_WEEK = List.of(DayOfWeek.SUNDAY, DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.TUESDAY, DayOfWeek.SATURDAY);

    public int calculateDiscount(Order order, DayOfWeek dayOfWeek) {
        if (!isAvailable(order, dayOfWeek)) {
            return 0;
        }
        return order.getQuantity() * DISCOUNT_AMOUNT;
    }

    private boolean isAvailable(Order order, DayOfWeek dayOfWeek) {
        return APPLICABLE_DAYS_OF_WEEK.contains(dayOfWeek) && order.getProductType() == ProductType.DESERT;
    }
}