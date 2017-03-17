package org.academiadecodigo.bootcamp.hackathon.services;

import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionManager;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 3/16/17.
 */
public class AdminService implements Service {

    private BootcampDao bootcampDao;
    private TransactionManager tx;

    public AdminService() {

    }

    @Override
    public Class getServiceClass() {
        return AdminService.class;
    }

    public List<String> getAllBootcampsByName() {

        List<String> bootcampName = new LinkedList<>();

        List<Bootcamp> bootcamps = bootcampDao.findAll();

        while (bootcamps.iterator().hasNext()) {

            int i = 0;
            bootcampName.add(bootcamps.get(i).getName());
            i++;
        }

        return bootcampName;
    }


    public void changeBootcampName(String currentName, String newBootCampName) {

        tx.beginTransaction();

        Bootcamp bootcamp = bootcampDao.findByName(currentName);
        bootcamp.setName(newBootCampName);

        bootcampDao.update(bootcamp);

        tx.commitTransaction();
    }
}
