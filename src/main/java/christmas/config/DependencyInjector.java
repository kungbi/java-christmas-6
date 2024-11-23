package christmas.config;

import christmas.controller.Controller;
import christmas.controller.RetryInputUtil;
import christmas.domain.promotion.DdayDiscount;
import christmas.domain.promotion.GiveWayEvent;
import christmas.domain.promotion.SpecialDiscount;
import christmas.repository.OrderRepository;
import christmas.repository.ProductRepository;
import christmas.service.OrderService;
import christmas.service.PriceService;
import christmas.service.ProductInitializer;
import christmas.service.PromotionService;
import christmas.utils.fileparser.CsvReader;
import christmas.utils.fileparser.ProductParser;
import christmas.validator.InputValidator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class DependencyInjector {
    public Controller createController() {
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();

        InputValidator inputValidator = new InputValidator(productRepository);
        RetryInputUtil retryInputUtil = new RetryInputUtil(inputValidator);

        OrderService orderService = new OrderService(productRepository, orderRepository);
        PriceService priceService = new PriceService(productRepository, orderRepository);
        PromotionService promotionService = new PromotionService(productRepository, orderRepository, new DdayDiscount(),
                new SpecialDiscount(), new GiveWayEvent());

        productRepositoryInitialize(productRepository);

        return new Controller(retryInputUtil, orderService, promotionService, priceService);
    }

    private void productRepositoryInitialize(ProductRepository productRepository) {
        ProductParser productParser = new ProductParser(
                new CsvReader(this.createBufferedReader("products.md"), false)
        );
        ProductInitializer productInitializer = new ProductInitializer(productRepository, productParser);
        productInitializer.init();
    }

    private BufferedReader createBufferedReader(String fileName) {
        return new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(DependencyInjector.class.getClassLoader().getResourceAsStream(fileName))));
    }
}
