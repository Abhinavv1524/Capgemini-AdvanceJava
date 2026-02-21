package in.cg.services;


import org.hibernate.*;
import in.cg.util.HibernateUtil;

public class ReportService {

    public void getEmployeePerformance(Long employeeId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = "select count(l) from Lead l where l.employee.id = :empId";

            Long leadCount = session.createQuery(hql, Long.class)
                    .setParameter("empId", employeeId)
                    .uniqueResult();

            System.out.println("Employee has handled " + leadCount + " leads.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        session.close();
    }
}