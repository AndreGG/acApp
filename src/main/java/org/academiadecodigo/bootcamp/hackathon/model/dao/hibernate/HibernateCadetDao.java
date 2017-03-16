package org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate;

import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.Summarizer;
import org.academiadecodigo.bootcamp.hackathon.model.dao.CadetDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionException;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by codecadet on 3/16/17.
 */
public class HibernateCadetDao extends HibernateDao<Cadet> implements CadetDao {



    public HibernateCadetDao() {
        super(Cadet.class);
    }


    @Override
    public Cadet findByName(String cadetName) {
        try {

            Session session = HibernateSessionManager.getSession();
            Query q = session.createQuery("from Cadet where name = :cadetName");
            q.setString("cadetName", cadetName);
            Cadet cadet = (Cadet) q.uniqueResult();

            return cadet;

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }


}
