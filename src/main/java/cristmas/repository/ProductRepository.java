package cristmas.repository;

import cristmas.domain.product.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements Repository<Product> {
    private final List<Product> products = new ArrayList<>();

    @Override
    public void add(Product data) {
        products.add(data);
    }

    @Override
    public void remove(Product data) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Optional<Product> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return List.copyOf(products);
    }

    @Override
    public void update(String name, Product newData) {

    }

    @Override
    public boolean exists(String name) {
        Optional<Product> product = this.findByName(name);
        return product.isPresent();
    }
}
