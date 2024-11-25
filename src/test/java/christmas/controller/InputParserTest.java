package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.product.Product;
import christmas.enums.ProductType;
import christmas.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 주문_파싱_테스트() {
        ProductRepository productRepository = new ProductRepository();
        productRepository.add(new Product("콜라", 100, ProductType.DRINK));
        productRepository.add(new Product("피자", 100, ProductType.MAIN));

        InputParser inputParser = new InputParser(productRepository);
        Orders orders = inputParser.parseOrders("콜라-1,피자-1");
        Assertions.assertThat(orders.getOrders().size()).isEqualTo(2);
    }

}