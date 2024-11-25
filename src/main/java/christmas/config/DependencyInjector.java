package christmas.config;

import christmas.controller.Controller;
import christmas.controller.InputParser;
import christmas.controller.RetryInputUtil;
import christmas.repository.ProductRepository;

public class DependencyInjector {
    public Controller createController() {
        ProductRepository productRepository = new ProductRepository();
        InputParser inputParser = new InputParser(productRepository);
        RetryInputUtil retryInputUtil = new RetryInputUtil(inputParser);

        return new Controller(productRepository, retryInputUtil);
    }
}
