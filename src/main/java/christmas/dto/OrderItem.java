package christmas.dto;

public record OrderItem(String name, int quantity) {
    public OrderItem {
        if (name == null) {
            throw new NullPointerException("name");
        }
        if (quantity < 1) {
            throw new IllegalArgumentException("quantity");
        }
    }
}
