package com.sejo.dao;

import com.sejo.entities.Beverage;
import com.sejo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Stack;

public class BeverageDao {

    public void saveBeverage(Beverage beverage) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the beverage object
            session.save(beverage);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void saveListOfBeverages(List< Beverage > beverages) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the beverage object
            for (Beverage beverage : beverages) {
                session.save(beverage);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void saveStackOfBeverages(Stack<Beverage> beverages) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the beverage object
            for (Beverage beverage : beverages) {
                session.save(beverage);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Stack< Beverage > getBeveragesAsStack() {
        Stack< Beverage> beverages = new Stack<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.createQuery("from Beverage", Beverage.class).stream().map(beverages::push);
            return beverages;
        }
    }

    public List< Beverage > getBeveragesAsList() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Beverage", Beverage.class).list();
        }
    }

    public Beverage[] getBeveragesAsArray(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Beverage> beverageList = session.createQuery("from Beverage", Beverage.class).list();
            return beverageList.toArray(new Beverage[0]);
        }
    }

}
