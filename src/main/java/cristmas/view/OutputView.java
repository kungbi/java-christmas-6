package cristmas.view;

import cristmas.dto.BenefitResultDto;
import cristmas.dto.ItemDto;
import cristmas.enums.BenefitType;
import java.util.Map;

public class OutputView {

    public static final String NOTHING = "없음";

    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printBenefitResult(BenefitResultDto result) {
        printBeginMessage(result);
        printOrderedItems(result);
        printTotalPrice(result);
        printGiveaway(result);
        printBenefits(result);
        printTotalBenefitAmount(result);
        printExpectedPaymentAmount(result);
        printBadge(result);
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
        System.out.println();
    }

    // private methods

    private static void printBeginMessage(BenefitResultDto result) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n", result.day());
        System.out.println();
    }

    private static void printOrderedItems(BenefitResultDto result) {
        System.out.println("<주문 메뉴>");
        for (ItemDto item : result.orderedItems()) {
            System.out.printf("%s %d개\n", item.product().name(), item.quantity());
        }
        System.out.println();
    }

    private static void printTotalPrice(BenefitResultDto result) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", result.totalPrice());
        System.out.println();
    }

    private static void printGiveaway(BenefitResultDto result) {
        System.out.println("<증정 메뉴>");
        result.giveaway().ifPresentOrElse(
                giveaway -> System.out.printf("%s %d개\n", giveaway.product().name(), giveaway.quantity()),
                () -> System.out.println(NOTHING)
        );
        System.out.println();
    }

    private static void printBenefits(BenefitResultDto result) {
        System.out.println("<혜택 내역>");
        if (result.benefits().isEmpty()) {
            System.out.println(NOTHING);
            System.out.println();
            return;
        }
        for (Map.Entry<BenefitType, Integer> entry : result.benefits().entrySet()) {
            System.out.printf("%s: -%,d원\n", entry.getKey().getName(), entry.getValue());
        }
        System.out.println();
    }

    private static void printBadge(BenefitResultDto result) {
        System.out.println("<12월 이벤트 배지>");
        result.badge().ifPresentOrElse(
                badge -> System.out.println(badge.getName()),
                () -> System.out.println(NOTHING)
        );
        System.out.println();
    }

    private static void printExpectedPaymentAmount(BenefitResultDto result) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원\n", result.expectedPaymentAmount());
        System.out.println();
    }

    private static void printTotalBenefitAmount(BenefitResultDto result) {
        System.out.println("<총혜택 금액>");
        if (0 < result.totalBenefitAmount()) {
            System.out.printf("-%,d원\n", result.totalBenefitAmount());
            System.out.println();
            return;
        }
        System.out.println("0원");
        System.out.println();
    }

}
