package christmas.controller;

import christmas.dto.OrderItem;
import christmas.validator.InputValidator;
import christmas.view.InputView;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class RetryInputUtil {

    public static int getDay() {
        return retryLogics(InputView::getDay, InputParser::parseInt, InputValidator::dayValidate);
    }

    public static List<OrderItem> getOrderItems() {
        return retryLogics(InputView::getOrderItems, InputParser::parseOrderItems, InputValidator::orderItemsValidate);
    }

    public static <T> T retryLogics(Supplier<String> userInputReader, Function<String, T> parser,
                                    Consumer<T> validator) {
        while (true) {
            try {
                String userInput = userInputReader.get();
                T parsedInput = parser.apply(userInput);
                validator.accept(parsedInput);
                return parsedInput;
            } catch (IllegalArgumentException error) {
//                OutputView.printError(error.getMessage());
            }
        }
    }

    public static String retryLogics(Supplier<String> userInputReader, Consumer<String> validator) {
        while (true) {
            try {
                String userInput = userInputReader.get();
                validator.accept(userInput);
                return userInput;
            } catch (IllegalArgumentException error) {
//                OutputView.printError(error.getMessage());
            }

        }
    }
}
