package christmas.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void 개수가_0개인_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Order("콜라", 0));
    }

}