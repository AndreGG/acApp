package org.academiadecodigo.bootcamp.hackathon.services;

import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionManager;

import java.util.LinkedList;
import java.util.List;

import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionException;

/**
 * Created by codecadet on 3/16/17.
 */
public class AdminService implements Service {

    private BootcampDao bootcampDao;
    private TransactionManager tx;

    public AdminService(BootcampDao bootcampDao, TransactionManager transactionManager) {

        this.bootcampDao = bootcampDao;
        this.tx = transactionManager;

    }

    @Override
    public Class getServiceClass() {
        return AdminService.class;
    }

    public List<String> getAllBootcampsByName() {

        tx.beginTransaction();

        List<String> bootcampName = new LinkedList<>();
        List<Bootcamp> bootcamps = bootcampDao.findAll();

        for(int i = 0; i < bootcamps.size(); i++){
            bootcampName.add(bootcamps.get(i).getName());
        }

        tx.commitTransaction();

        return bootcampName;
    }


    public void changeBootcampName(String currentName, String newBootCampName) {

        tx.beginTransaction();

        Bootcamp bootcamp = bootcampDao.findByName(currentName);
        bootcamp.setName(newBootCampName);

        bootcampDao.update(bootcamp);

        tx.commitTransaction();
    }

    public void createBootcamp(Bootcamp bootcamp) {

            tx.beginTransaction();

            bootcampDao.create(bootcamp);

            tx.commitTransaction();

    }
}
