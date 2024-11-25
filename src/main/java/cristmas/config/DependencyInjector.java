package cristmas.config;

import cristmas.controller.Controller;
import cristmas.controller.InputParser;
import cristmas.controller.RetryInputUtil;
import cristmas.repository.ProductRepository;

public class DependencyInjector {
    public Controller createController() {
        ProductRepository productRepository = new ProductRepository();
        InputParser inputParser = new InputParser(productRepository);
        RetryInputUtil retryInputUtil = new RetryInputUtil(inputParser);

        return new Controller(productRepository, retryInputUtil);
    }
}
