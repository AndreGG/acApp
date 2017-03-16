package org.academiadecodigo.bootcamp.hackathon.services;

import org.academiadecodigo.bootcamp.hackathon.model.dao.*;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateBootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateCadetDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateSummarizerDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.DBConnectionManager;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;

/**
 * Created by codecadet on 3/16/17.
 */
public class ServiceInitializer {

    private DBConnectionManager dbConnectionManager;

    public void init() {

        HibernateSessionManager hibernateManager = new HibernateSessionManager();
        CadetDao cadetDAO = new HibernateCadetDao();
        BootcampDao bootcampDAO = new HibernateBootcampDao();
        SummarizerDao summarizerDao = new HibernateSummarizerDao();

        ServiceRegistry.getInstance().registerService();

        this.dbConnectionManager = hibernateManager;
    }

    public void stopServices() {
        dbConnectionManager.close();
    }

}
