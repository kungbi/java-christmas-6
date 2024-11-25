package christmas.dto;

import christmas.domain.Orders;

public record ApplyPromotionDto(Orders orders, int day) {
}
