package cristmas.domain;

import cristmas.validator.OrdersValidator;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        OrdersValidator.validate(orders);
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Orders{" +
               "orders=" + orders +
               '}';
    }
}
