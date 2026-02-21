package in.cg.services;

import in.cg.entities.*;
import org.hibernate.*;
import in.cg.util.HibernateUtil;

import java.time.LocalDate;
import java.util.*;

public class OrderService {

    public void placeOrder(Long customerId, List<Long> productIds) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Customer customer = session.get(Customer.class, customerId);

            if (customer == null) {
                System.out.println("Customer Not Found!");
                return;
            }

            List<Product> products = new ArrayList<>();
            double total = 0;

            for (Long id : productIds) {
                Product product = session.get(Product.class, id);
                if (product != null) {
                    products.add(product);
                    total += product.getPrice();
                }
            }

            OrderEntity order = new OrderEntity();
            order.setCustomer(customer);
            order.setProducts(products);
            order.setOrderDate(LocalDate.now());
            order.setTotalAmount(total);

            session.save(order);
            tx.commit();

            System.out.println("Order Placed Successfully!");
        } catch (Exception e) {
            tx.rollback();
        }
        session.close();
    }
}