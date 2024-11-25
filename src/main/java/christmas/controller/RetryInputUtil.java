package christmas.controller;

import christmas.domain.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class RetryInputUtil {

    private final InputParser inputParser;

    public RetryInputUtil(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public int getDay() {
        return retryLogics(InputView::getDay, inputParser::parseInt, this::dayValidate);
    }

    public Orders getOrders() {
        return retryLogics(InputView::getOrders, inputParser::parseOrders);
    }

    private void dayValidate(int day) {
        if (!(1 <= day && day <= 31)) {
            throw new IllegalArgumentException();
        }
    }

    private <T> T retryLogics(Supplier<String> userInputReader, Function<String, T> parser, Consumer<T> validator) {
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

    private <T> T retryLogics(Supplier<String> userInputReader, Function<String, T> parser) {
        while (true) {
            try {
                String userInput = userInputReader.get();
                return parser.apply(userInput);
            } catch (IllegalArgumentException error) {
                OutputView.printError(error.getMessage());
            }

        }
    }
}
