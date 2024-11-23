package christmas.repository;

import christmas.domain.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ProductRepository implements Repository<Product> {
    private final List<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        if (this.exists(product.getName())) {
            throw new IllegalArgumentException("Product already exists");
        }
        products.add(product);
    }

    @Override
    public void remove(Product data) {

    }

    @Override
    public int getSize() {
        return products.size();
    }

    @Override
    public Optional<Product> findByName(String name) {
        return products.stream().filter(product -> product.getName().equals(name)).findFirst();
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public void update(String name, Product newData) {

    }

    @Override
    public boolean exists(String name) {
        return findByName(name).isPresent();
    }

    @Override
    public List<Product> findByCondition(Predicate<Product> condition) {
        return List.of();
    }

    @Override
    public void clear() {

    }

    @Override
    public List<Product> findPage(int pageNumber, int pageSize) {
        return List.of();
    }
}
