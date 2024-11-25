package cristmas.domain.promotion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DDayDiscountTest {

    @Test
    void 할인_금액_계산() {
        DDayDiscount dDayDiscount = new DDayDiscount();
        int discountAmount = dDayDiscount.calculateDiscount(5);

        Assertions.assertThat(discountAmount).isEqualTo(1_400);
    }

    @Test
    void 할인_금액_계산_미적용() {
        DDayDiscount dDayDiscount = new DDayDiscount();
        int discountAmount = dDayDiscount.calculateDiscount(26);

        Assertions.assertThat(discountAmount).isEqualTo(0);
    }

}