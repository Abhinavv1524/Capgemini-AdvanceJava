package in.cg.services;

import in.cg.entities.*;
import org.hibernate.*;
import in.cg.util.HibernateUtil;

public class CustomerService {

    public void registerCustomer(String name, String email, String phone) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhone(phone);

            session.save(customer);
            tx.commit();
            System.out.println("Customer Registered Successfully!");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void addAddressToCustomer(Long customerId, Address address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Customer customer = session.get(Customer.class, customerId);
            if (customer != null) {
                customer.setAddress(address);
                session.save(address);
                session.update(customer);
                tx.commit();
                System.out.println("Address Added Successfully!");
            } else {
                System.out.println("Customer Not Found!");
            }
        } catch (Exception e) {
            tx.rollback();
        }
        session.close();
    }
}