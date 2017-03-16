package org.academiadecodigo.bootcamp.hackathon.services;

import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.CadetDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.SummarizerDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.DBConnectionManager;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;

/**
 * Created by codecadet on 3/16/17.
 */
public class ServiceInitializer {

    private DBConnectionManager dbConnectionManager;

    public void init() {

        HibernateSessionManager hibernateManager = new HibernateSessionManager();
        CadetDao cadetDAO = ;
        BootcampDao bootcampDAO = ;
        SummarizerDao summarizerDao = ;
        

        ServiceRegistry.getInstance().registerService(userService);

        this.dbConnectionManager = hibernateManager;
    }

    public void stopServices() {
        dbConnectionManager.close();
    }

}
