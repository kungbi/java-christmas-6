package christmas.domain.promotion;

import christmas.enums.DayOfWeek;
import christmas.enums.ProductType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeekendsDiscountTest {
    WeekendsDiscount discount = new WeekendsDiscount();

    @Test
    void 평일_할인_일() {
        Assertions.assertEquals(0, discount.getDiscountAmount(DayOfWeek.SUNDAY, ProductType.MAIN));
    }

    @Test
    void 평일_할인_월() {
        Assertions.assertEquals(0, discount.getDiscountAmount(DayOfWeek.MONDAY, ProductType.MAIN));
    }

    @Test
    void 평일_할인_화() {
        Assertions.assertEquals(0, discount.getDiscountAmount(DayOfWeek.TUESDAY, ProductType.MAIN));
    }

    @Test
    void 평일_할인_수() {
        Assertions.assertEquals(0, discount.getDiscountAmount(DayOfWeek.WEDNESDAY, ProductType.MAIN));
    }

    @Test
    void 평일_할인_목() {
        Assertions.assertEquals(0, discount.getDiscountAmount(DayOfWeek.THURSDAY, ProductType.MAIN));
    }

    @Test
    void 평일_할인_금() {
        Assertions.assertEquals(2_023, discount.getDiscountAmount(DayOfWeek.FRIDAY, ProductType.MAIN));
    }

    @Test
    void 평일_할인_토() {
        Assertions.assertEquals(2_023, discount.getDiscountAmount(DayOfWeek.SATURDAY, ProductType.MAIN));
    }

}