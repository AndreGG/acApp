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

    private HibernateSessionManager hibernateSessionManager;

    public HibernateCadetDao(HibernateSessionManager hibernateSessionManager) {
        super(hibernateSessionManager, Cadet.class);
    }

//    public List<Cadet> findByBootcamp(int bootcampNumber) {
//        try {
//
//            Session session = hibernateSessionManager.getSession();
//            Query q = session.createQuery("from Cadet where bootcampNumber = :bootcampNumber");
//            q.setString("bootcampNumber", String.valueOf(bootcampNumber));
//            List<Cadet> cadets = q.list();
//
//            return cadets;
//
//        } catch (HibernateException hex) {
//            throw new TransactionException(hex);
//        }
//    }
}
