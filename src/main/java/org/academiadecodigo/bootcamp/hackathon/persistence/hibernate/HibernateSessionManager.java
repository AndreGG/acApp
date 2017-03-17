package org.academiadecodigo.bootcamp.hackathon.persistence.hibernate;

import org.academiadecodigo.bootcamp.hackathon.persistence.DBConnectionManager;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by codecadet on 3/16/17.
 */
public class HibernateSessionManager implements DBConnectionManager, TransactionManager {

    private SessionFactory sessionFactory;

    public HibernateSessionManager() {
        // hibernate initialization code
        try {

            // Hold services needed by Hibernate
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml") // Load settings from hibernate.cfg.xml
                    .build();

            sessionFactory = new MetadataSources(serviceRegistry)
                    .buildMetadata() // Tell Hibernate about sources of metadata (database mappings)
                    .buildSessionFactory();

        } catch (HibernateException hex) {
            hex.getMessage();
            hex.printStackTrace();
        }

    }

    public void beginTransaction() {
        Session session = getSession();
        session.beginTransaction();
    }

    public void commitTransaction() {
        getSession().getTransaction().commit();
    }

    public void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }

    public Session getSession() {
        // Hibernate will automatically open a new session if needed
        // Closing the session is not required
        return sessionFactory.getCurrentSession();
    }

    // Required to stop hibernate and allow the application to terminate
    public void close() {
        sessionFactory.close();
    }

}
