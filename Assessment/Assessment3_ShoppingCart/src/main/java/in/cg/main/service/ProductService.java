package in.cg.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import in.cg.main.model.Product;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public ProductService() {

        Product p1 = new Product();
        p1.setId(1);
        p1.setName("Laptop");
        p1.setPrice(50000);

        Product p2 = new Product();
        p2.setId(2);
        p2.setName("Mobile");
        p2.setPrice(20000);

        Product p3 = new Product();
        p3.setId(3);
        p3.setName("Headphones");
        p3.setPrice(3000);

        products.add(p1);
        products.add(p2);
        products.add(p3);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}