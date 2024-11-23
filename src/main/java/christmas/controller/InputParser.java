package christmas.controller;

import christmas.dto.OrderItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static List<OrderItem> parseOrderItems(String input) {
        List<OrderItem> orderItems = new ArrayList<>();
        List<String> splitInput = Arrays.stream(input.split(",")).toList();

        for (String oneItem : splitInput) {
            OrderItem orderItem = parseOrderItem(oneItem);
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    private static OrderItem parseOrderItem(String oneItem) {
        List<String> splitItem = Arrays.stream(oneItem.split(",")).toList();
        String productName = splitItem.get(0);
        int quantity = parseInt(splitItem.get(1));
        return new OrderItem(productName, quantity);
    }

}
