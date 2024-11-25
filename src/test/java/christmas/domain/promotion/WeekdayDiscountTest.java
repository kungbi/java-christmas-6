package christmas.domain.promotion;

import christmas.domain.Order;
import christmas.domain.product.Product;
import christmas.enums.DayOfWeek;
import christmas.enums.ProductType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WeekdayDiscountTest {

    @Test
    void 할인_테스트() {
        Product product = new Product("abc", 1000, ProductType.DESERT);
        Order order = new Order(product, 2);

        int discountAmount = WeekdayDiscount.calculateDiscount(order, DayOfWeek.MONDAY); // -2,023 * 2

        Assertions.assertThat(discountAmount).isEqualTo(2023 * 2);
    }

}