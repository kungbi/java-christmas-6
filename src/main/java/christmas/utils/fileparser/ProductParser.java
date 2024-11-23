package christmas.utils.fileparser;

import christmas.controller.InputParser;
import christmas.enums.ProductType;
import java.io.IOException;
import java.util.List;

public class ProductParser {

    public static final int NAME_INDEX = 0;
    public static final int PRICE_INDEX = 1;
    public static final int TYPE_INDEX = 2;
    private final Reader reader;

    public ProductParser(Reader reader) {
        this.reader = reader;
    }

    public ProductField nextLine() throws IOException {
        List<String> fields = reader.readLine();
        if (fields == null || fields.isEmpty()) {
            return null;
        }
        validate(fields);

        return new ProductField(
                fields.get(NAME_INDEX), InputParser.parseInt(fields.get(PRICE_INDEX)),
                ProductType.findByKorean(fields.get(TYPE_INDEX))
        );
    }

    private static void validate(List<String> fields) {
        if (fields.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}