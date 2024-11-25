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
        return retryLogics(InputView::getDay, inputParser::parseInt, this::dayValidate, "유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    public Orders getOrders() {
        return retryLogics(InputView::getOrders, inputParser::parseOrders, "유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private void dayValidate(int day) {
        if (!(1 <= day && day <= 31)) {
            throw new IllegalArgumentException();
        }
    }

    private <T> T retryLogics(Supplier<String> userInputReader, Function<String, T> parser, Consumer<T> validator, String errorMessage) {
        while (true) {
            try {
                String userInput = userInputReader.get();
                T parsedInput = parser.apply(userInput);
                validator.accept(parsedInput);
                return parsedInput;
            } catch (IllegalArgumentException error) {
                OutputView.printError(errorMessage);
            }
        }
    }

    private <T> T retryLogics(Supplier<String> userInputReader, Function<String, T> parser, String errorMessage) {
        while (true) {
            try {
                String userInput = userInputReader.get();
                return parser.apply(userInput);
            } catch (IllegalArgumentException error) {
                OutputView.printError(errorMessage);
            }

        }
    }
}
