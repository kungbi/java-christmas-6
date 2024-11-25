package christmas.initializer;

import christmas.file.parser.GenericParser;
import java.io.IOException;
import christmas.repository.Repository;

public abstract class AbstractInitializer<T, F> {
    private final Repository<T> repository;
    private final GenericParser<F> parser;

    public AbstractInitializer(Repository<T> repository, GenericParser<F> parser) {
        this.repository = repository;
        this.parser = parser;
    }

    public void init() {
        try {
            parse();
        } catch (IOException error) {
            throw new IllegalArgumentException("Failed to initialize data.", error);
        }
    }

    private void parse() throws IOException {
        while (true) {
            F field = parser.nextLine();
            if (field == null) {
                break;
            }
            repository.add(mapToDomain(field));
        }
    }

    protected abstract T mapToDomain(F field);
}