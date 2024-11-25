package cristmas.dto;

import cristmas.enums.Badge;
import cristmas.enums.BenefitType;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public record BenefitResultDto(
        int day,
        List<ItemDto> orderedItems,
        int totalPrice,
        Optional<ItemDto> giveaway,
        Map<BenefitType, Integer> benefits,
        int totalBenefitAmount,
        int expectedPaymentAmount,
        Optional<Badge> badge
) {

    /**
     * <주문 메뉴>
     * 티본스테이크 1개
     * 바비큐립 1개
     * 초코케이크 2개
     * 제로콜라 1개
     *
     * <할인 전 총주문 금액>
     * 142,000원
     *
     * <증정 메뉴>
     * 샴페인 1개
     *
     * <혜택 내역>
     * 크리스마스 디데이 할인: -1,200원
     * 평일 할인: -4,046원
     * 특별 할인: -1,000원
     * 증정 이벤트: -25,000원
     *
     * <총혜택 금액>
     * -31,246원
     *
     * <할인 후 예상 결제 금액>
     * 135,754원
     *
     * <12월 이벤트 배지>
     * 산타
     */
}
