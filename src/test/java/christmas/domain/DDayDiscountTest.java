package christmas.domain;

import christmas.domain.promotion.DDayDiscount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DDayDiscountTest {

    @Test
    void 할인_금액_계산_할인_적용() {
        DDayDiscount dDayDiscount = new DDayDiscount();
        Assertions.assertEquals(100, dDayDiscount.getDiscountAmount(1));
        Assertions.assertEquals(2_500, dDayDiscount.getDiscountAmount(25));
    }

    @Test
    void 할인_금액_계산_할인_미적용() {
        DDayDiscount dDayDiscount = new DDayDiscount();

        Assertions.assertEquals(0, dDayDiscount.getDiscountAmount(26));
    }

}