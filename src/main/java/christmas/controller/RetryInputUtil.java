package christmas.controller;

import christmas.dto.OrderItem;
import christmas.validator.InputValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class RetryInputUtil {
    private final InputValidator inputValidator;

    public RetryInputUtil(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int getDay() {
        return retryLogics(InputView::getDay, InputParser::parseInt, inputValidator::dayValidate);
    }

    public List<OrderItem> getOrderItems() {
        return retryLogics(InputView::getOrderItems, InputParser::parseOrderItems, inputValidator::orderItemsValidate);
    }

    public <T> T retryLogics(Supplier<String> userInputReader, Function<String, T> parser,
                             Consumer<T> validator) {
        while (true) {
            try {
                String userInput = userInputReader.get();
                T parsedInput = parser.apply(userInput);
                validator.accept(parsedInput);
                return parsedInput;
            } catch (IllegalArgumentException error) {
                OutputView.printError(error.getMessage());
            }
        }
    }
}
