package christmas.initializer;

import christmas.domain.product.Product;
import christmas.domain.product.ProductField;
import christmas.file.parser.GenericParser;
import christmas.repository.Repository;

public class ProductInitializer extends AbstractInitializer<Product, ProductField> {

    public ProductInitializer(Repository<Product> repository, GenericParser<ProductField> parser) {
        super(repository, parser);
    }

    @Override
    protected Product mapToDomain(ProductField field) {
        return new Product(field.name(), field.price(), field.type());
    }

}
