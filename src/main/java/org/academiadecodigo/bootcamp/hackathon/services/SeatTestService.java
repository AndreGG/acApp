package org.academiadecodigo.bootcamp.hackathon.services;

import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.dao.CadetDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionManager;

import java.util.List;

/**
 * Created by codecadet on 3/17/17.
 */
public class SeatTestService implements Service{

    CadetDao cadetDao;
    TransactionManager transactionManager;

    public SeatTestService(CadetDao cadetDao, TransactionManager transactionManager) {
        this.cadetDao = cadetDao;
        this.transactionManager = transactionManager;
    }

    public List<Cadet> findAll() {

        transactionManager.beginTransaction();
        List<Cadet> l = cadetDao.findAll();
        transactionManager.commitTransaction();

        return l;
    }

    @Override
    public Class getServiceClass() {
        return SeatTestService.class;
    }
}
