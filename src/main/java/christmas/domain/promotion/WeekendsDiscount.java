package christmas.domain.promotion;

import christmas.enums.ProductType;
import java.util.List;

public class WeekendsDiscount implements DayOfWeekDiscount {
    private static final List<ProductType> APPLICABLE_PRODUCT_TYPES = List.of(ProductType.MAIN);
    private static final int DISCOUNT_PER_PRODUCT = 2_023;

    @Override
    public int getDiscountAmount(ProductType type) {
        if (!APPLICABLE_PRODUCT_TYPES.contains(type)) {
            return 0;
        }
        return DISCOUNT_PER_PRODUCT;
    }
}
