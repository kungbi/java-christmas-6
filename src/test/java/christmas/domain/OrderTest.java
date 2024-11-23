package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void 주문_정상() {
        Order order = new Order();

        order.addProduct("콜라", 5);
        order.addProduct("바나나", 3);

        Assertions.assertEquals(8, order.getTotalQuantity());
    }

    @Test
    void 중복된_아이템_추가() {
        Order order = new Order();

        order.addProduct("콜라", 5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> order.addProduct("콜라", 5));
    }

    @Test
    void 개수가_0개인_경우() {
        Order order = new Order();

        Assertions.assertThrows(IllegalArgumentException.class, () -> order.addProduct("콜라", 0));
    }

    @Test
    void 주문_상품의_수가_20를_초과할_때() {
        Order order = new Order();

        order.addProduct("콜라", 20);
        Assertions.assertThrows(IllegalArgumentException.class, () -> order.addProduct("바나나", 1));
    }


}