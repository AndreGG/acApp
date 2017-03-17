package org.academiadecodigo.bootcamp.hackathon.services;

import org.academiadecodigo.bootcamp.hackathon.model.dao.*;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateBootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateCadetDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateSummarizerDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.DBConnectionManager;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateTransactionManager;

/**
 * Created by codecadet on 3/16/17.
 */
public class ServiceInitializer {


    public void init() {

        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        CadetDao cadetDAO = new HibernateCadetDao();
        BootcampDao bootcampDAO = new HibernateBootcampDao();
        SummarizerDao summarizerDao = new HibernateSummarizerDao();

        AdminService adminService = new AdminService(bootcampDAO, hibernateTransactionManager);
        SeatTestService seatTestService = new SeatTestService(cadetDAO,hibernateTransactionManager);

        ServiceRegistry.getInstance().registerService(adminService);
        ServiceRegistry.getInstance().registerService(seatTestService);

    }

    public void stopServices() {

    }

}
