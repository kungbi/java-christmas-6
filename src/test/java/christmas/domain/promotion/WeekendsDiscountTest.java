package christmas.domain.promotion;

import christmas.enums.DayOfWeek;
import christmas.enums.ProductType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeekendsDiscountTest {
    WeekendsDiscount discount = new WeekendsDiscount();

    @Test
    void 주말_할인_디저트() {
        Assertions.assertEquals(0, discount.getDiscountAmount(ProductType.DESERT));
    }

    @Test
    void 주말_할인_메인() {
        Assertions.assertEquals(2_023, discount.getDiscountAmount(ProductType.MAIN));
    }

    @Test
    void 주말_할인_음료() {
        Assertions.assertEquals(0, discount.getDiscountAmount(ProductType.DRINK));
    }

    @Test
    void 주말_할인_에피타이저() {
        Assertions.assertEquals(0, discount.getDiscountAmount(ProductType.APPETIZER));
    }
}