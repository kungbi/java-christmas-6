package christmas.repository;

import christmas.domain.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OrderRepository implements Repository<Order> {
    private final List<Order> orders = new ArrayList<>();
    private boolean adding = true;

    @Override
    public void add(Order order) {
        if (!adding) {
            throw new IllegalArgumentException();
        }
        if (this.exists(order.getProductName())) {
            throw new IllegalArgumentException("Order already exists");
        }
        if (20 < this.getTotalQuantity() + order.getQuantity()) {
            throw new IllegalArgumentException("Too much quantity");
        }

        orders.add(order);
    }

    public void stopAdding() {
        this.adding = false;
    }

    public int getTotalQuantity() {
        return orders.stream().mapToInt(Order::getQuantity).sum();
    }

    @Override
    public void remove(Order data) {

    }

    @Override
    public int getSize() {
        return orders.size();
    }

    @Override
    public Optional<Order> findByName(String name) {
        if (adding) {
            throw new IllegalArgumentException();
        }
        return orders.stream().filter(order -> order.getProductName().equals(name)).findFirst();
    }

    @Override
    public List<Order> findAll() {
        if (adding) {
            throw new IllegalArgumentException();
        }
        return List.copyOf(orders);
    }

    @Override
    public void update(String name, Order newData) {

    }

    @Override
    public boolean exists(String name) {
        if (adding) {
            throw new IllegalArgumentException();
        }
        return this.findByName(name).isPresent();
    }

    @Override
    public List<Order> findByCondition(Predicate<Order> condition) {
        return List.of();
    }

    @Override
    public void clear() {
        this.orders.clear();
    }

}
