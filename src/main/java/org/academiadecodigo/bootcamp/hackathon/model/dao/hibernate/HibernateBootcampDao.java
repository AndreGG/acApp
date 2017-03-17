package org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate;

import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionException;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by codecadet on 3/16/17.
 */
public class HibernateBootcampDao extends HibernateDao<Bootcamp> implements BootcampDao {

    public HibernateBootcampDao() {
        super(Bootcamp.class);
    }

    public Bootcamp findByName(String name) {
        try {

            Session session = HibernateSessionManager.getSession();
            Query q = session.createQuery("from Bootcamp where name = :name");

            q.setString("name", String.valueOf(name));
            Bootcamp bootcamp = (Bootcamp) q.uniqueResult();

            return bootcamp;

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }


}
