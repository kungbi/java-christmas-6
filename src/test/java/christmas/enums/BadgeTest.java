package christmas.enums;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BadgeTest {

    @Test
    void 뱃지_없음_테스트() {
        int amountPurchased = 4_999;
        Assertions.assertTrue(Badge.getBadgeByAmountPurchased(amountPurchased).isEmpty());
    }

    @Test
    void 별_테스트() {
        int amountPurchased = 5_000;
        Assertions.assertTrue(Badge.getBadgeByAmountPurchased(amountPurchased).isPresent());
        Assertions.assertEquals(Badge.STAR, Badge.getBadgeByAmountPurchased(amountPurchased).get());
    }

    @Test
    void 트리_테스트() {
        int amountPurchased = 10_000;
        Assertions.assertTrue(Badge.getBadgeByAmountPurchased(amountPurchased).isPresent());
        Assertions.assertEquals(Badge.TREE, Badge.getBadgeByAmountPurchased(amountPurchased).get());
    }

    @Test
    void 산타_테스트() {
        int amountPurchased = 20_000;
        Assertions.assertTrue(Badge.getBadgeByAmountPurchased(amountPurchased).isPresent());
        Assertions.assertEquals(Badge.SANTA, Badge.getBadgeByAmountPurchased(amountPurchased).get());
    }

}