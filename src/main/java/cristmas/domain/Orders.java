package cristmas.domain;

import cristmas.enums.ProductType;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validate(orders);
        this.orders = orders;
    }

    private void validate(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (this.validateIsOnlyDrink(orders)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateIsOnlyDrink(List<Order> orders) {
        for (Order order : orders) {
            if (order.getProductType() != ProductType.DRINK) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orders{" +
               "orders=" + orders +
               '}';
    }
}
