package in.cg.services;

import in.cg.entities.*;
import org.hibernate.*;
import in.cg.util.HibernateUtil;

public class LeadService {

    public void createLead(String name, String source, String contactInfo) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Lead lead = new Lead();
            lead.setName(name);
            lead.setSource(source);
            lead.setContactInfo(contactInfo);

            session.save(lead);
            tx.commit();
            System.out.println("Lead Created!");
        } catch (Exception e) {
            tx.rollback();
        }
        session.close();
    }

    public void assignLeadToEmployee(Long leadId, Long employeeId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Lead lead = session.get(Lead.class, leadId);
            SalesEmployee emp = session.get(SalesEmployee.class, employeeId);

            if (lead != null && emp != null) {
                lead.setEmployee(emp);
                session.update(lead);
                tx.commit();
                System.out.println("Lead Assigned!");
            } else {
                System.out.println("Lead or Employee Not Found!");
            }
        } catch (Exception e) {
            tx.rollback();
        }
        session.close();
    }

    public void convertLeadToCustomer(Long leadId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            Lead lead = session.get(Lead.class, leadId);

            if (lead != null) {
                Customer customer = new Customer();
                customer.setName(lead.getName());
                customer.setEmail(lead.getContactInfo());
                customer.setPhone("N/A");

                session.save(customer);
                session.delete(lead);

                tx.commit();
                System.out.println("Lead Converted To Customer!");
            } else {
                System.out.println("Lead Not Found!");
            }
        } catch (Exception e) {
            tx.rollback();
        }
        session.close();
    }
}