package christmas.config;

import christmas.controller.Controller;
import christmas.controller.InputParser;
import christmas.controller.RetryInputUtil;
import christmas.file.parser.ProductParser;
import christmas.file.reader.CsvReader;
import christmas.initializer.ProductInitializer;
import christmas.repository.ProductRepository;
import christmas.service.PromotionService;

public class DependencyInjector {
    public Controller createController() {
        ProductRepository productRepository = getProductRepository();
        InputParser inputParser = getInputParser(productRepository);
        RetryInputUtil retryInputUtil = getRetryInputUtil(inputParser);
        PromotionService promotionService = new PromotionService(productRepository);

        ProductParser productParser = new ProductParser(CsvReader.of("products.md", false));
        ProductInitializer initializer = new ProductInitializer(productRepository, productParser);
        initializer.init();

        return new Controller(retryInputUtil, promotionService);
    }

    private static ProductRepository getProductRepository() {
        return new ProductRepository();
    }

    private static InputParser getInputParser(ProductRepository productRepository) {
        return new InputParser(productRepository);
    }

    private static RetryInputUtil getRetryInputUtil(InputParser inputParser) {
        return new RetryInputUtil(inputParser);
    }
}
