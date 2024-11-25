package cristmas.domain.promotion;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SpecialDiscountTest {

    @Test
    void 할인_테스트_적용() {
        SpecialDiscount specialDiscount = new SpecialDiscount();
        int discountAmount = specialDiscount.calculateDiscount(10);

        Assertions.assertThat(discountAmount).isEqualTo(1_000);
    }

    @Test
    void 할인_테스트_미적용() {
        SpecialDiscount specialDiscount = new SpecialDiscount();
        int discountAmount = specialDiscount.calculateDiscount(11);

        Assertions.assertThat(discountAmount).isEqualTo(0);
    }

}