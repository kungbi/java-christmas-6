package christmas.controller;

import christmas.dto.OrderItem;
import christmas.exception.GlobalErrorMessage;
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
            OrderItem orderItem = parseOrderItem(oneItem.strip());
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    private static OrderItem parseOrderItem(String oneItem) {
        List<String> splitItem = Arrays.stream(oneItem.split("-")).toList();
        if (splitItem.size() != 2) {
            throw new IllegalArgumentException(GlobalErrorMessage.INVALID_ORDER.getMessage());
        }
        String productName = splitItem.get(0).strip();
        int quantity = parseInt(splitItem.get(1).strip());
        return new OrderItem(productName, quantity);
    }

}
