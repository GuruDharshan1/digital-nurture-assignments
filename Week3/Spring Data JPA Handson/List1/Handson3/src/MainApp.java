import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Employee emp = new Employee();
            emp.setFirstName("Jane");
            emp.setLastName("Smith");
            emp.setSalary(50000);

            session.save(emp);

            List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();
            for (Employee e : employees) {
                System.out.println(e);
            }

            Employee empToDelete = session.get(Employee.class, emp.getId());
            if (empToDelete != null) {
                session.delete(empToDelete);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
