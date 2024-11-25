package christmas.domain.promotion;

import christmas.domain.Order;
import christmas.domain.product.Product;
import christmas.enums.DayOfWeek;
import christmas.enums.ProductType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WeekendDiscountTest {

    @Test
    void 할인_테스트() {
        Product product = new Product("abc", 1000, ProductType.MAIN);
        Order order = new Order(product, 2);

        int discountAmount = WeekendDiscount.calculateDiscount(order, DayOfWeek.SATURDAY); // -2,023 * 2

        Assertions.assertThat(discountAmount).isEqualTo(2023 * 2);
    }


}