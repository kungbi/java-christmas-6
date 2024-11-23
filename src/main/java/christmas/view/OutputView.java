package christmas.view;

import christmas.dto.OrderItem;
import christmas.dto.PromotionPreview;
import christmas.dto.PromotionPreview.GiveWayProduct;
import christmas.dto.PromotionPreview.PromotionHistory;
import christmas.enums.Badge;
import java.util.List;
import java.util.Optional;

public class OutputView {

    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printPromotionPreview(PromotionPreview preview) {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        printOrderedMenu(preview.orderItems());
        printTotalPrice(preview.totalPrice());
        printGiveWayProduct(preview.giveWayProduct());
        printPromotionHistory(preview.promotionHistories());
        printTotalDiscount(preview.totalDiscount());
        printExpectedPaymentAmount(preview.expectedPaymentAmount());
        printBadge(preview.badge());
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
        System.out.println();
    }

    private static void printBadge(Optional<Badge> badge) {
        System.out.println("<12월 이벤트 배지>");
        if (badge.isPresent()) {
            System.out.println(badge.get().getKorean());
        }
        if (badge.isEmpty()) {
            printNothingMessage();
        }
        System.out.println();
    }

    private static void printExpectedPaymentAmount(int price) {
        System.out.println("<할인 후 예상 결제 금액>");
        printMoney(price);
        System.out.println();
    }

    private static void printTotalDiscount(int dicount) {
        System.out.println("<총혜택 금액>");
        if (dicount > 0) {
            printMoney(dicount);
            System.out.println();
            return;
        }
        printNothingMessage();
        System.out.println();
    }

    private static void printPromotionHistory(List<PromotionHistory> promotionHistories) {
        System.out.println("<혜택 내역>");
        if (promotionHistories.isEmpty()) {
            printNothingMessage();
            System.out.println();
            return;
        }
        for (PromotionHistory promotionHistory : promotionHistories) {
            System.out.printf("%s: -%,d원\n", promotionHistory.promotionType().getDescription(),
                    promotionHistory.discountAmount());
        }
        System.out.println();
    }

    private static void printGiveWayProduct(Optional<GiveWayProduct> giveWayProduct) {
        System.out.println("<증정 메뉴>");
        if (giveWayProduct.isPresent()) {
            System.out.printf("%s %d개\n", giveWayProduct.get().productName(), giveWayProduct.get().quantity());
        }
        if (giveWayProduct.isEmpty()) {
            printNothingMessage();
        }
        System.out.println();
    }

    private static void printTotalPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        printMoney(totalPrice);
        System.out.println();
    }

    private static void printOrderedMenu(List<OrderItem> orderItems) {
        System.out.println("<주문 메뉴>");
        for (OrderItem orderItem : orderItems) {
            System.out.printf("%s %d개\n", orderItem.name(), orderItem.quantity());
        }
        System.out.println();

    }

    private static void printMoney(int price) {
        System.out.printf("%,d원\n", price);
    }

    private static void printNothingMessage() {
        System.out.println("없음");
    }
}
