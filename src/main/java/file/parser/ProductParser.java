package file.parser;

import domain.product.ProductField;
import file.reader.Reader;

public class ProductParser extends AbstractFieldParser<ProductField> {

    public ProductParser(Reader reader) {
        super(reader, ProductField.class);
    }

}
