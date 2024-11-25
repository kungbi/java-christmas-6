package cristmas.initializer;

import cristmas.domain.product.Product;
import cristmas.domain.product.ProductField;
import cristmas.file.parser.GenericParser;
import cristmas.repository.Repository;

public class ProductInitializer extends AbstractInitializer<Product, ProductField> {

    public ProductInitializer(Repository<Product> repository, GenericParser<ProductField> parser) {
        super(repository, parser);
    }

    @Override
    protected Product mapToDomain(ProductField field) {
        return new Product(field.name(), field.price(), field.type());
    }

}
