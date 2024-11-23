package christmas.domain.promotion;

import christmas.enums.DayOfWeek;
import christmas.enums.ProductType;
import java.util.List;

public interface DayOfWeekDiscount {
    List<DayOfWeek> WEEKDAYS = List.of(DayOfWeek.SUNDAY, DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY);
    List<DayOfWeek> WEEKENDS = List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);

    static DayOfWeekDiscount of(DayOfWeek dayOfWeek) {
        if (WEEKDAYS.contains(dayOfWeek)) {
            return new WeekdaysDiscount();
        }
        if (WEEKENDS.contains(dayOfWeek)) {
            return new WeekendsDiscount();
        }
        throw new IllegalArgumentException("Unknown day of week: " + dayOfWeek);
    }

    int getDiscountAmount(ProductType type);
}
