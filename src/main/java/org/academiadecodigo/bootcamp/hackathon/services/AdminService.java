package org.academiadecodigo.bootcamp.hackathon.services;

import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.CadetDao;

/**
 * Created by codecadet on 3/16/17.
 */
public class AdminService implements Service {

    BootcampDao bootcampDao;
    CadetDao cadetDao;

    public AdminService() {

    }

    @Override
    public Class getServiceClass() {
        return AdminService.class;
    }

    public void createBootcamp(Bootcamp bootcamp){
        bootcampDao.create(bootcamp);
    }

    public void addCadetsListToBootcamp(Cadet cadet){
    }

}
