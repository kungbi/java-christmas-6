package initializer;

import domain.product.Product;
import domain.product.ProductField;
import file.parser.GenericParser;
import repository.Repository;

public class ProductInitializer extends AbstractInitializer<Product, ProductField> {

    public ProductInitializer(Repository<Product> repository, GenericParser<ProductField> parser) {
        super(repository, parser);
    }

    @Override
    protected Product mapToDomain(ProductField field) {
        return new Product(field.name(), field.price(), field.type());
    }

}
