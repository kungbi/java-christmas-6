package cristmas.file.parser;

import cristmas.domain.product.ProductField;
import cristmas.file.reader.Reader;

public class ProductParser extends AbstractFieldParser<ProductField> {

    public ProductParser(Reader reader) {
        super(reader, ProductField.class);
    }

}
