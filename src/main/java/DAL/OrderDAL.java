package DAL;

import hibernate.entities.Category;
import hibernate.entities.Order;
import hibernate.entities.Product;
import hibernate.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class OrderDAL {
    static final SessionFactory factory = HibernateUtils.getSessionFactory();
    public List getAllOrder(String orderby){
        Session session = factory.openSession();
        List listOrder = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Order  ORDER BY id "+orderby;
            listOrder = session.createQuery(hql).list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOrder;
    }
    public Order getOrderById(int id){
        Session session = factory.openSession();
        Order order = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Order P WHERE P.id ="+ id;
            order = (Order) session.createQuery(hql).uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return order;
    }

    public int deleteOrder(int id){
        Session session = factory.openSession();
        int result = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "DELETE FROM Order WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            result = query.executeUpdate();
            //  System.out.println("Rows affected: " + result);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}
