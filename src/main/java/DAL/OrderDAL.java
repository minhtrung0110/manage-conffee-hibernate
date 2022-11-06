/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import hibernate.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author hieu0
 */




public class OrderDAL{
    
    static final SessionFactory factory = HibernateUtils.getSessionFactory();
    
    
    public long getCount(){
        Session session = factory.openSession();
        long amount = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("select count(*) from Order");
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
    
    public int getTotalRevenue(){
        Session session = factory.openSession();
        double total = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT sum(totalPrice) from Order");
            total = (double)query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (int)total;  
    }
    
    public static void main(String[] args) {
//        new CategoryDAL().findAll().forEach(s->System.out.println(s));

        OrderDAL dal = new OrderDAL();
        System.out.println("Count: "+String.valueOf(dal.getCount()));
        System.out.println("Total Revenue: "+String.valueOf(dal.getTotalRevenue()));
    }
}

