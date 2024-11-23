package christmas.dto;

import java.util.List;

public record MakeOrderInput(List<OrderItem> items) {
}
