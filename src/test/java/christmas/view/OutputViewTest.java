package christmas.view;

import christmas.dto.BenefitResultDto;
import christmas.dto.ItemDto;
import christmas.dto.ProductDto;
import christmas.enums.Badge;
import christmas.enums.BenefitType;
import christmas.enums.ProductType;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void 결과_출력_테스트() {
        ProductDto product1 = new ProductDto("피자", 8_000, ProductType.MAIN);
        ProductDto product2 = new ProductDto("콜라", 2_000, ProductType.DRINK);
        ProductDto product3 = new ProductDto("샴페인", 3_000, ProductType.DRINK);
        ItemDto giveaway = new ItemDto(product3, 1);

        BenefitResultDto result = new BenefitResultDto(
                15,
                List.of(new ItemDto(product1, 1), new ItemDto(product2, 2)),
                12_000,
                Optional.of(giveaway),
                Map.of(BenefitType.D_DAY, 1000, BenefitType.SPECIAL, 1000, BenefitType.WEEKDAY, 1000),
                3000,
                1000,
                Optional.of(Badge.SANTA)
        );

        OutputView.printBenefitResult(result);
    }

    @Test
    void 결과_출력_없음_테스트() {
        ProductDto product1 = new ProductDto("피자", 8_000, ProductType.MAIN);
        ProductDto product2 = new ProductDto("콜라", 2_000, ProductType.DRINK);
        ProductDto product3 = new ProductDto("샴페인", 3_000, ProductType.DRINK);
        ItemDto giveaway = new ItemDto(product3, 1);

        BenefitResultDto result = new BenefitResultDto(
                15,
                List.of(new ItemDto(product1, 1), new ItemDto(product2, 2)),
                12_000,
                Optional.empty(),
                Map.of(),
                0,
                12_000,
                Optional.empty()
        );

        OutputView.printBenefitResult(result);
    }

}