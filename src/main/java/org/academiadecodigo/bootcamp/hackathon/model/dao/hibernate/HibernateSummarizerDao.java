package org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate;

import org.academiadecodigo.bootcamp.hackathon.model.Summarizer;
import org.academiadecodigo.bootcamp.hackathon.model.dao.SummarizerDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionException;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Date;

/**
 * Created by codecadet on 3/16/17.
 */
public class HibernateSummarizerDao extends HibernateDao<Summarizer> implements SummarizerDao {

    private HibernateSessionManager hibernateSessionManager;

    public HibernateSummarizerDao(HibernateSessionManager hibernateSessionManager) {
        super(hibernateSessionManager, Summarizer.class);
    }

    public Summarizer findByDate(Date date) {
        try {

            Session session = hibernateSessionManager.getSession();
            Query q = session.createQuery("from Summarizer where date = :date");
            q.setString("date", String.valueOf(date));
            Summarizer summarizer = (Summarizer) q.uniqueResult();

            return summarizer;

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }

}
