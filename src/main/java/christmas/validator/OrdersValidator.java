package christmas.validator;

import christmas.domain.Order;
import christmas.enums.ProductType;
import java.util.List;

public class OrdersValidator {
    public static void validate(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (validateIsOnlyDrink(orders)) {
            throw new IllegalArgumentException();
        }
        if (20 < orders.stream().mapToInt(Order::getQuantity).sum()) {
            throw new IllegalArgumentException();
        }
        if (orders.stream().map(Order::getProductName).distinct().count() != orders.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean validateIsOnlyDrink(List<Order> orders) {
        for (Order order : orders) {
            if (order.getProductType() != ProductType.DRINK) {
                return false;
            }
        }
        return true;
    }
}
