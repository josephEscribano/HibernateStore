package dao.hibernateDAO;

import dao.HibernateUtils;
import dao.interfaces.DAOItems;
import io.vavr.control.Either;
import lombok.extern.log4j.Log4j2;
import model.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.Constantes;
import utils.HibernateQuerys;

import java.time.LocalDate;
import java.util.List;

@Log4j2
public class HibernateDAOItems implements DAOItems {

    @Override
    public List<Item> getAll() {
        Session session = null;
        List<Item> list = null;
        try {
            session = HibernateUtils.getSession();
            list = session.createNamedQuery("getItems", Item.class).getResultList();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return list;
    }

    @Override
    public boolean save(Item item) {
        Session session = null;
        boolean confirmacion = false;
        try {
            session = HibernateUtils.getSession();
            session.save(item);
            confirmacion = true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return confirmacion;
    }

    @Override
    public int update(Item item) {
        Session session = null;
        Transaction transaction = null;
        int confirmacion = 0;
        try{
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            session.update(item);
            confirmacion = 1;
            transaction.commit();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            if (transaction != null) {
                transaction.rollback();
            }
        }finally {
            if(session != null){
                session.close();
            }
        }
        return confirmacion;
    }

    @Override
    public int deletePurchasesAndItem(Item item) {
        Session session = null;
        Transaction transaction = null;
        int confirmacion = -2;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            session.createNamedQuery("deleteByItem").setParameter("id", item.getIdItem()).executeUpdate();
            session.delete(item);
            transaction.commit();
            confirmacion = 0;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return confirmacion;
    }

    @Override
    public int deleteItem(Item item) {
        Session session = null;
        Transaction transaction = null;
        int confirmacion = -2;

        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            session.delete(item);
            transaction.commit();
            confirmacion = 0;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return confirmacion;
    }

    @Override
    public Item findItemByID(int id) {
        Session session = null;
        Item item = null;
        try{
            session = HibernateUtils.getSession();
            item = session.createNamedQuery("itemByID",Item.class)
                    .setParameter("id",id)
                    .uniqueResult();
        }catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return item;
    }






}
