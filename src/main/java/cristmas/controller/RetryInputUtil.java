package cristmas.controller;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import cristmas.view.OutputView;

public class RetryInputUtil {

    public static <T> T retryLogics(Supplier<String> userInputReader, Function<String, T> parser,
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

    public static String retryLogics(Supplier<String> userInputReader, Consumer<String> validator) {
        while (true) {
            try {
                String userInput = userInputReader.get();
                validator.accept(userInput);
                return userInput;
            } catch (IllegalArgumentException error) {
                OutputView.printError(error.getMessage());
            }

        }
    }
}
