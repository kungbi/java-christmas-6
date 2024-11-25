package domain;

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
    }

    @Override
    public String toString() {
        return "Orders{" +
               "orders=" + orders +
               '}';
    }
}
