package christmas.file.parser;

import christmas.domain.product.ProductField;
import christmas.file.reader.Reader;

public class ProductParser extends AbstractFieldParser<ProductField> {

    public ProductParser(Reader reader) {
        super(reader, ProductField.class);
    }

}
