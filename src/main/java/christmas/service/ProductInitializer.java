package christmas.service;

import christmas.domain.Product;
import christmas.repository.ProductRepository;
import christmas.utils.fileparser.ProductField;
import christmas.utils.fileparser.ProductParser;
import java.io.IOException;

public class ProductInitializer {
    private final ProductRepository productRepository;
    private final ProductParser productParser;

    public ProductInitializer(ProductRepository productRepository, ProductParser productParser) {
        this.productRepository = productRepository;
        this.productParser = productParser;
    }

    public void init() {
        try {
            parse();
        } catch (IOException error) {
            throw new IllegalArgumentException(error);
        }
    }

    private void parse() throws IOException {
        while (true) {
            ProductField productField = productParser.nextLine();
            if (productField == null) {
                break;
            }
            productRepository.add(new Product(productField.name(), productField.price(), productField.type()));
        }
    }
}
