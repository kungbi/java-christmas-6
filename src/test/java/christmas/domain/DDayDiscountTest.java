package christmas.domain;

import christmas.domain.promotion.DdayDiscount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DDayDiscountTest {

    @Test
    void 할인_금액_계산_할인_적용() {
        DdayDiscount dDayDiscount = new DdayDiscount();
        Assertions.assertEquals(1_000, dDayDiscount.getDiscountAmount(1));
        Assertions.assertEquals(3_400, dDayDiscount.getDiscountAmount(25));
    }

    @Test
    void 할인_금액_계산_할인_미적용() {
        DdayDiscount dDayDiscount = new DdayDiscount();

        Assertions.assertEquals(0, dDayDiscount.getDiscountAmount(26));
    }

}