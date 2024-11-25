package cristmas.validator;

import cristmas.domain.Order;
import cristmas.enums.ProductType;
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
