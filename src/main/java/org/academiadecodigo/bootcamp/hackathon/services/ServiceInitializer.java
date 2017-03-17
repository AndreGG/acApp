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


    public void init() {

        HibernateSessionManager hibernateManager = new HibernateSessionManager();
        //CadetDao cadetDAO = new HibernateCadetDao(hibernateManager);
        //BootcampDao bootcampDAO = new HibernateBootcampDao(hibernateManager);
        //SummarizerDao summarizerDao = new HibernateSummarizerDao(hibernateManager);

        //ServiceRegistry.getInstance().registerService();

    }

    public void stopServices() {

    }

}
