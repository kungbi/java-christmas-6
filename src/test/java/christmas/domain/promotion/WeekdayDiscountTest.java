package christmas.domain.promotion;

import christmas.domain.product.Product;
import christmas.dto.ItemDto;
import christmas.dto.ProductDto;
import christmas.enums.DayOfWeek;
import christmas.enums.ProductType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WeekdayDiscountTest {

    @Test
    void 할인_테스트() {
        WeekdayDiscount weekdayDiscount = new WeekdayDiscount();
        Product product = new Product("abc", 1000, ProductType.DESERT);
        ItemDto item = new ItemDto(ProductDto.from(product), 2);

        int discountAmount = weekdayDiscount.calculateDiscount(item, DayOfWeek.MONDAY); // -2,023 * 2

        Assertions.assertThat(discountAmount).isEqualTo(2023 * 2);
    }

}