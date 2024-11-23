package christmas.repository;

import christmas.domain.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderRepositoryTest {


    @Test
    void 주문_정상() {
        OrderRepository repository = new OrderRepository();
        Order coke = new Order("콜라", 5);
        Order banana = new Order("바나나", 5);

        repository.add(coke);
        repository.add(banana);
    }

    @Test
    void 중복된_아이템_추가() {
        OrderRepository repository = new OrderRepository();
        Order coke = new Order("콜라", 5);

        repository.add(coke);
        Assertions.assertThrows(IllegalArgumentException.class, () -> repository.add(coke));
    }

    @Test
    void 주문_상품의_수가_20를_초과할_때() {
        OrderRepository repository = new OrderRepository();
        Order coke = new Order("콜라", 20);
        Order banana = new Order("바나나", 1);


        repository.add(coke);
        Assertions.assertThrows(IllegalArgumentException.class, () -> repository.add(banana));
    }


}