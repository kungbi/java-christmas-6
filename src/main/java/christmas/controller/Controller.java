package christmas.controller;

import christmas.dto.OrderItem;
import christmas.dto.PromotionPreview;
import christmas.dto.PromotionPreview.GiveWayProduct;
import christmas.dto.PromotionPreview.PromotionHistory;
import christmas.enums.Badge;
import christmas.enums.DayOfWeek;
import christmas.enums.PromotionType;
import christmas.service.OrderService;
import christmas.service.PriceService;
import christmas.service.PromotionService;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {
    private final RetryInputUtil retryInputUtil;
    private final OrderService orderService;
    private final PromotionService promotionService;
    private final PriceService priceService;

    public Controller(RetryInputUtil retryInputUtil, OrderService orderService, PromotionService promotionService,
                      PriceService priceService) {
        this.retryInputUtil = retryInputUtil;
        this.orderService = orderService;
        this.promotionService = promotionService;
        this.priceService = priceService;
    }

    public void run() {
        int day = retryInputUtil.getDay();
        List<OrderItem> orderItems = retryInputUtil.getOrderItems();

        orderService.addOrder(orderItems);
        int totalPrice = priceService.getTotalPrice();

        PromotionPreview promotionPreview = new PromotionPreview(orderItems, totalPrice, Optional.empty(), List.of(), 0,
                totalPrice, Optional.empty());
        if (promotionService.isApplicableAmount(totalPrice)) {
            promotionPreview = getPromotionPreview(day, totalPrice, orderItems);
        }

        OutputView.printPromotionPreview(promotionPreview);

    }

    private PromotionPreview getPromotionPreview(int day, int totalPrice, List<OrderItem> orderItems) {
        List<PromotionHistory> promotionHistories = new ArrayList<>();
        promotionHistories.add(promotionService.getDdayDiscountAmount(day));
        promotionHistories.add(promotionService.getDayOfWeekDiscountAmount(DayOfWeek.fromDay(day)));
        promotionHistories.add(promotionService.specialDiscountAmount(day));

        Optional<GiveWayProduct> giveWayProduct = promotionService.getGiveWayProduct(totalPrice);
        if (giveWayProduct.isPresent()) {
            promotionHistories.add(new PromotionHistory(PromotionType.GIVE_WAY, giveWayProduct.get().totalPrice()));
        }

        int totalDiscount = promotionHistories.stream().mapToInt(PromotionHistory::discountAmount).sum();

        Optional<Badge> badge = Badge.getBadgeByDiscountAmount(totalDiscount);

        PromotionPreview promotionPreview = new PromotionPreview(orderItems, totalPrice, giveWayProduct,
                promotionHistories, totalDiscount,
                totalPrice - totalDiscount, badge);
        return promotionPreview;
    }
}
