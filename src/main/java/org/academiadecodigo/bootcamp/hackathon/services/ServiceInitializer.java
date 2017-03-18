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

    private DBConnectionManager manager;

    public void init() {

        HibernateSessionManager manager = new HibernateSessionManager();

        CadetDao cadetDAO = new HibernateCadetDao(manager);
        BootcampDao bootcampDAO = new HibernateBootcampDao(manager);
        SummarizerDao summarizerDao = new HibernateSummarizerDao(manager);

        BootcampService bootS = new BootcampService(cadetDAO, summarizerDao, bootcampDAO, manager);
        AdminService adminService = new AdminService(bootcampDAO, manager);

        ServiceRegistry.getInstance().registerService(bootS);
        ServiceRegistry.getInstance().registerService(adminService);

    }

    public void stopServices() {
        manager.close();
    }

}
