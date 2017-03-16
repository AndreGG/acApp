package org.academiadecodigo.bootcamp.hackathon.services;

import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.CadetDao;
import org.hibernate.type.IntegerType;

import java.util.HashMap;
import java.util.List;

/**
 * Created by codecadet on 3/16/17.
 */
public abstract class SeatingAssignmentService {

    private CadetDao cadetDao;
    private BootcampDao bootcampDao;
    private List<Cadet> cadets;
    private HashMap<String, Integer> currentSeatAssignment;

    public SeatingAssignmentService(CadetDao cadetDao, BootcampDao bootcamp) {

        this.cadetDao = cadetDao;
        this.bootcampDao = bootcamp;
        this.cadets = bootcampDao.getCadets();

        for(Cadet cadet: cadets) {
            currentSeatAssignment.put(cadet.getName(), cadet.getCurrentSeat());
        }

        currentSeatAssignment.containsKey()

    }

    public void

}
