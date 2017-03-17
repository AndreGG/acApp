package org.academiadecodigo.bootcamp.hackathon.services;

import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.CadetDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionException;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionManager;

/**
 * Created by codecadet on 3/16/17.
 */
public class AdminService implements Service {

    BootcampDao bootcampDao;
    TransactionManager transactionManager;

    public AdminService(BootcampDao bootcampDao, TransactionManager transactionManager) {

        this.bootcampDao = bootcampDao;
        this.transactionManager = transactionManager;

    }

    @Override
    public Class getServiceClass() {
        return AdminService.class;
    }

    public void createBootcamp(Bootcamp bootcamp){

        try {
            transactionManager.beginTransaction();

            bootcampDao.create(bootcamp);

            transactionManager.commitTransaction();
        }catch (TransactionException ex){

            transactionManager.rollbackTransaction();

        }
    }

}
