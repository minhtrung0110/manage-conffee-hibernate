package DAL;

import hibernate.entities.Category;
import hibernate.entities.Product;
import hibernate.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

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
    public int insertProdct(Product product){
        Session session = factory.openSession();
        int result = 1;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();

            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
        return result;
    }
    public int updateProduct(Product product){
        System.out.println("A - "+product);
        Session session = factory.openSession();
        int result = 0;
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
            System.out.println(hql);
            result = query.executeUpdate();
           System.out.println("Rows affected: " + result);
           // session.update(product);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }
    public int deleteProduct(int id){
        Session session = factory.openSession();
        int result = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "DELETE FROM Product WHERE id = :id";
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
    public static void main(String[] args) {
        ProductDAL dal = new ProductDAL();
        List listProduct = dal.getAllProduct("DESC");
        listProduct.forEach(s-> System.out.println(s.toString()));
        //dal.updateProdct(1);
        Product product = new Product();
        product.setCategory(new Category(1,"Trồn Là"));
        product.setAmount(250);
        product.setName("Trà Bóng Siêu Cươi");
        product.setImage("Dapda.img");
        product.setDescription("Đá và Lời Ra");
        product.setPrice(2500000);
        dal.insertProdct(product);
        dal.deleteProduct(22);
        System.out.println("Element: "+dal.getProductById(20));

    }
}
