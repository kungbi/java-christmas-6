package christmas.domain.promotion;

import christmas.enums.DayOfWeek;
import christmas.enums.ProductType;
import java.util.List;

public class WeekdaysDiscount {
    private static final List<DayOfWeek> APPLICABLE_DAY_OF_WEEK = List.of(DayOfWeek.SUNDAY, DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY);
    private static final List<ProductType> APPLICABLE_PRODUCT_TYPES = List.of(ProductType.DESERT);
    private static final int DISCOUNT_PER_PRODUCT = 2_023;

    public int getDiscountAmount(DayOfWeek dayOfWeek, ProductType type) {
        if (!APPLICABLE_DAY_OF_WEEK.contains(dayOfWeek)) {
            return 0;
        }
        if (!APPLICABLE_PRODUCT_TYPES.contains(type)) {
            return 0;
        }
        return DISCOUNT_PER_PRODUCT;
    }
}
