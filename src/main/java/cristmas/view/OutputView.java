package cristmas.view;

public class OutputView {

    public static void printWelcomeMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printBenefits() {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

        /**
         * <주문 메뉴>
         * 타파스 1개
         * 제로콜라 1개
         *
         * <할인 전 총주문 금액>
         * 8,500원
         *
         * <증정 메뉴>
         * 없음
         *
         * <혜택 내역>
         * 없음
         *
         * <총혜택 금액>
         * 0원
         *
         * <할인 후 예상 결제 금액>
         * 8,500원
         *
         * <12월 이벤트 배지>
         * 없음
         */
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
        System.out.println();
    }
}
