package in.cg.services;

import in.cg.entities.Product;
import org.hibernate.*;
import in.cg.util.HibernateUtil;

public class ProductService {

    public void addProduct(String name, double price) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);

            session.save(product);
            tx.commit();
            System.out.println("Product Added!");
        } catch (Exception e) {
            tx.rollback();
        }
        session.close();
    }
}