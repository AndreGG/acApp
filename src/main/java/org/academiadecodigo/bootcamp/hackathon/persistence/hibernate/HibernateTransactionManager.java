package org.academiadecodigo.bootcamp.hackathon.persistence.hibernate;

import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionManager;

/**
 * Created by codecadet on 3/9/17.
 */
public class HibernateTransactionManager implements TransactionManager {


    @Override
    public void beginTransaction() {

        HibernateSessionManager.beginTransaction();

    }

    @Override
    public void commitTransaction() {

        HibernateSessionManager.commitTransaction();

    }

    @Override
    public void rollbackTransaction() {

        HibernateSessionManager.rollbackTransaction();

    }
}
