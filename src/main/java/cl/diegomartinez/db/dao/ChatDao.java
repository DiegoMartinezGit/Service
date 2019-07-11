package cl.diegomartinez.db.dao;

import cl.diegomartinez.db.model.Chat;
import cl.vicenterivera.SOAServiceLib.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class ChatDao {

    public static boolean save(Chat chat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(chat);
            return true;
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public static List<Chat> msjs_byid(Long id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Chat> query = session.createNativeQuery(
                    "select * from chat where id_usr1 = :id or id_usr2=:id",
                    Chat.class);
            query.setParameter("id",id);
            return query.list();

        } catch (HibernateException | NoResultException ex) {
            return new ArrayList<>();
        }
    }






}