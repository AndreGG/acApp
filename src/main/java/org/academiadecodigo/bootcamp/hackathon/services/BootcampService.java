package org.academiadecodigo.bootcamp.hackathon.services;

import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.Summarizer;
import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.CadetDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.SummarizerDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;

import java.util.Set;

/**
 * Created by andre on 3/18/2017.
 */
public class BootcampService implements Service {

    private CadetDao cadetDao;
    private SummarizerDao summarizerDao;
    private BootcampDao bootcampDao;
    private TransactionManager manager;

    public BootcampService(CadetDao cadetDao, SummarizerDao summDao, BootcampDao bootDao, HibernateSessionManager hibernateSessionManager) {

        this.cadetDao = cadetDao;
        this.summarizerDao = summDao;
        this.bootcampDao = bootDao;
        this.manager = hibernateSessionManager;

    }

    public void addCadet(Cadet cadet) {

        manager.beginTransaction();
        cadetDao.create(cadet);
        manager.commitTransaction();

    }

    public void addBootcamp() {

    }

    public Set<Cadet> getBootcampCadets(String name) {

        manager.beginTransaction();
        Set<Cadet> cadets = bootcampDao.getCadets("Javanger");
        manager.commitTransaction();

        return cadets;
    }

    @Override
    public Class getServiceClass() {
        return BootcampService.class;
    }
}
