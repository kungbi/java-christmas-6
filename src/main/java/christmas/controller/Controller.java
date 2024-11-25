package christmas.controller;

import christmas.domain.Orders;
import christmas.dto.ApplyPromotionDto;
import christmas.dto.BenefitResultDto;
import christmas.service.PromotionService;
import christmas.view.OutputView;

public class Controller {
    private final RetryInputUtil retryInputUtil;
    private final PromotionService promotionService;

    public Controller(RetryInputUtil retryInputUtil, PromotionService promotionService) {
        this.retryInputUtil = retryInputUtil;
        this.promotionService = promotionService;
    }

    public void run() {
        OutputView.printWelcomeMessage();
        int day = retryInputUtil.getDay();
        Orders orders = retryInputUtil.getOrders();

        BenefitResultDto benefitResult = promotionService.applyPromotion(new ApplyPromotionDto(orders, day));

        OutputView.printBenefitResult(benefitResult);
    }


}
