package in.cg.services;

import in.cg.entities.*;
import org.hibernate.*;
import in.cg.util.HibernateUtil;

public class TicketService {

    public void raiseTicket(Long orderId, String issueDescription) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            OrderEntity order = session.get(OrderEntity.class, orderId);

            if (order != null) {
                SupportTicket ticket = new SupportTicket();
                ticket.setOrder(order);
                ticket.setIssueDescription(issueDescription);

                session.save(ticket);
                tx.commit();

                System.out.println("Support Ticket Raised!");
            } else {
                System.out.println("Order Not Found!");
            }
        } catch (Exception e) {
            tx.rollback();
        }
        session.close();
    }
}