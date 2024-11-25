package cristmas.domain.promotion;

import cristmas.domain.Order;
import cristmas.domain.product.Product;
import cristmas.enums.DayOfWeek;
import cristmas.enums.ProductType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WeekendDiscountTest {

    @Test
    void 할인_테스트() {
        WeekendDiscount weekendDiscount = new WeekendDiscount();
        Product product = new Product("abc", 1000, ProductType.MAIN);
        Order order = new Order(product, 2);

        int discountAmount = weekendDiscount.calculateDiscount(order, DayOfWeek.SATURDAY); // -2,023 * 2

        Assertions.assertThat(discountAmount).isEqualTo(2023 * 2);
    }


}