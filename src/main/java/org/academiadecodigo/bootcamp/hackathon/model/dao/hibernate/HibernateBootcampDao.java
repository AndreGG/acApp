package org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate;

import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionException;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Set;

/**
 * Created by codecadet on 3/16/17.
 */
public class HibernateBootcampDao extends HibernateDao<Bootcamp> implements BootcampDao {

    private HibernateSessionManager manager;

    public HibernateBootcampDao(HibernateSessionManager manager) {
        super(Bootcamp.class);
        this.manager = manager;
    }

    public Bootcamp findByName(String name) {
        try {

            Session session = manager.getSession();
            Query q = session.createQuery("from Bootcamp where name = :name");

            q.setString("name", String.valueOf(name));
            Bootcamp bootcamp = (Bootcamp) q.uniqueResult();

            return bootcamp;

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }

    @Override
    public Set<Cadet> getCadets(String name) {

        Bootcamp e;

        try {

            Session session = manager.getSession();
            Query q = session.createQuery("from Bootcamp where name = :name");
            q.setString("name", name);
            e = (Bootcamp)q.uniqueResult();

            if(e != null) {
                return e.getCadets();
            }

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

        return null;

    }
}
