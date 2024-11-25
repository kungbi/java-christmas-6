package christmas.domain;

import christmas.dto.ItemDto;
import christmas.validator.OrdersValidator;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        OrdersValidator.validate(orders);
        this.orders = orders;
    }

    public int calculateTotalPrice() {
        return orders.stream().mapToInt(Order::getPrice).sum();
    }

    public List<Order> getOrders() {
        return List.copyOf(orders);
    }

    public List<ItemDto> toDto() {
        List<ItemDto> items = new ArrayList<>();
        for (Order order : orders) {
            items.add(new ItemDto(order.getProduct(), order.getQuantity()));
        }
        return items;
    }

    @Override
    public String toString() {
        return "Orders{" +
               "orders=" + orders +
               '}';
    }
}
