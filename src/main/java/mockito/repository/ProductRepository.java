package mockito.repository;

import mockito.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        add(new Product("phone", 100.0)); // 0
        add(new Product("laptop", 100.0)); // 1
        add(new Product("printer", 100.0)); // 2
        add(new Product("monitor", 100.0)); // 3
        add(new Product("keyboard", 100.0)); // 4
    }

    public Product add(Product product) {
        product.setId(products.size());
        this.products.add(product);
        return product;
    }

    public Product getByName(String name) {
        for (Product p : products) {
            if (name.equals(p.getName())) {
                return p;
            }
        }
        return null;
    }

    public List<Product> all() {
        return products;
    }

    public int size() {
        return products.size();
    }
}
