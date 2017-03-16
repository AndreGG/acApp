package org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate;

import org.academiadecodigo.bootcamp.hackathon.model.dao.Dao;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionException;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import java.util.List;

/**
 * Created by codecadet on 3/16/17.
 */
public abstract class HibernateDao<E> implements Dao<E> {

    private Class<E> eClass;

    public HibernateDao(Class eClass) {
        this.eClass = eClass;
    }

    public void create(E e) {
        try {

            HibernateSessionManager.getSession().save(e);

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }


    public void update(E e) {
        try {

            HibernateSessionManager.getSession().saveOrUpdate(e);

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }


    public void delete(E e) {
        try {

            HibernateSessionManager.getSession().delete(e);

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }


    public E findById(int id) {
        try {

            Session session = HibernateSessionManager.getSession();
            Query q = session.createQuery("from " + eClass.getSimpleName() + " where id = :id");
            q.setString("id", String.valueOf(id));
            E e = (E) q.uniqueResult();

            return e;

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }


    public List<E> findAll() {
        try {

            Session session = HibernateSessionManager.getSession();
            Query q = session.createQuery("from " + eClass.getSimpleName());
            List<E> e = q.list();

            return e;

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }


    public long count() {
        try {

            Session session = HibernateSessionManager.getSession();
            long count = (long) session.createCriteria(eClass.getSimpleName())
                    .setProjection(Projections.rowCount())
                    .uniqueResult();

            return count;

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }

}
