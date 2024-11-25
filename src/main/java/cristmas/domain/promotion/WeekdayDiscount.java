package cristmas.domain.promotion;

import cristmas.dto.ItemDto;
import cristmas.enums.DayOfWeek;
import cristmas.enums.ProductType;
import java.util.List;

public class WeekdayDiscount {
    public static final int DISCOUNT_AMOUNT = 2_023;
    private static final List<DayOfWeek> APPLICABLE_DAYS_OF_WEEK = List.of(DayOfWeek.SUNDAY, DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.TUESDAY, DayOfWeek.SATURDAY);

    public static int calculateDiscount(ItemDto item, DayOfWeek dayOfWeek) {
        if (!isAvailable(item, dayOfWeek)) {
            return 0;
        }
        return item.quantity() * DISCOUNT_AMOUNT;
    }

    private static boolean isAvailable(ItemDto item, DayOfWeek dayOfWeek) {
        return APPLICABLE_DAYS_OF_WEEK.contains(dayOfWeek) && item.product().type() == ProductType.DESERT;
    }
}
