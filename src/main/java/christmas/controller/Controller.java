package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.promotion.DDayDiscount;
import christmas.domain.promotion.SpecialDiscount;
import christmas.enums.BenefitType;
import christmas.enums.DayOfWeek;
import christmas.repository.ProductRepository;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final ProductRepository productRepository;
    private final RetryInputUtil retryInputUtil;

    public Controller(ProductRepository productRepository, RetryInputUtil retryInputUtil) {
        this.productRepository = productRepository;
        this.retryInputUtil = retryInputUtil;
    }

    public void run() {
        OutputView.printWelcomeMessage();
        int day = retryInputUtil.getDay();
        Orders orders = retryInputUtil.getOrders();

        int totalPrice = orders.calculateTotalPrice();
        if (10_000 <= totalPrice) {
//            applyPromotion(orders);
        }

        // 증정 행사 적용


//        총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
//        총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
//        할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액   ; 할인금액은 증정 메뉴가격과는 별도
    }

    private Map<BenefitType, Integer> applyPromotion(Orders orders, int day, DayOfWeek dayOfWeek) {
        Map<BenefitType, Integer> promotions = new HashMap<>();

        int dDayDiscountAmount = DDayDiscount.calculateDiscount(day);
        int specialDiscountAmount = SpecialDiscount.calculateDiscount(day);
        return null;
    }


}
