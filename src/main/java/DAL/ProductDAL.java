package DAL;

import hibernate.entities.Category;
import hibernate.entities.Product;
import hibernate.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;
import org.hibernate.query.Query;

public class ProductDAL {
    static final SessionFactory factory = HibernateUtils.getSessionFactory();
    public List getAllProduct(String orderby){
        Session session = factory.openSession();
        List listProduct = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Product  ORDER BY id "+orderby;
            listProduct = session.createQuery(hql).list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listProduct;
    }
    public Product getProductById(int id){
        Session session = factory.openSession();
        Product product = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Product P WHERE P.id ="+ id;
            product = (Product) session.createQuery(hql).uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product;
    }
    public boolean insertProdct(Product product){
        Session session = factory.openSession();
        boolean result = true;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();

            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return result;
    }
    public boolean updateProduct(Product product){
        Session session = factory.openSession();
        boolean result=false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "UPDATE Product set category=:category, name = :name, description = :description," +
                    " price = :price, amount=:amount,image=:image WHERE id = :id";

            Query query = session.createQuery(hql);

            query.setParameter("name", product.getName());
            query.setParameter("id", product.getId());
            query.setParameter("category", product.getCategory());
            query.setParameter("description", product.getDescription());
            query.setParameter("price", product.getPrice());
            query.setParameter("amount", product.getAmount());
            query.setParameter("image", product.getImage());
             query.executeUpdate();
            result =true;
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            result=false;

        } finally {
            session.close();
        }

        return result;
    }
    public boolean deleteProduct(int id){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "DELETE FROM Product WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
             query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
    
    public long getCount(){
        Session session = factory.openSession();
        long amount = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("select count(*) from Product");
            amount = (long)query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return amount;        
    }
    
    public static void main(String[] args) {
        ProductDAL dal = new ProductDAL();
        
        System.out.println("Count: "+String.valueOf(dal.getCount()));
        
        

    }
}
