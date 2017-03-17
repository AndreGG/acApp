package org.academiadecodigo.bootcamp.hackathon.engine;

import org.academiadecodigo.bootcamp.hackathon.RNG.RNG;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.CadetDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.file.SettingsFileHandler;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;
import org.academiadecodigo.bootcamp.hackathon.services.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by codecadet on 3/16/17.
 */
public class SeatingAssignmentLogic implements Service {

    private CadetDao cadetDao;
    private BootcampDao bootcampDao;
    private Set<Cadet> cadets;
    private HashMap<Integer, String> riggedSeats;
    private int seatsByRow;
    private HibernateSessionManager manager;

    public SeatingAssignmentLogic(CadetDao cadetDao, BootcampDao bootcamp) {

        this.cadetDao = cadetDao;
        this.bootcampDao = bootcamp;

        HibernateSessionManager.beginTransaction();
        this.cadets = bootcampDao.getCadets("Javangers");
        HibernateSessionManager.commitTransaction();
        riggedSeats = new HashMap<>();

    }

    public Cadet assignSeat(int seatNumber) {

        Cadet assignedCadet = null;

        if(isRigged(seatNumber)) {

            /*String cadetName = riggedSeats.get(seatNumber);
            Cadet assignedCadet = cadetDao.findByName(cadetName);
            riggedCadet.setCurrentSeat(seatNumber);*/

        } else {

            int highestRoll = 0;
            assignedCadet = null;

            for(Cadet cadet: cadets) {

                double currentSeat = cadet.getCurrentSeat();
                int chance = getCadetRow(currentSeat);

                int cadetRoll = RNG.roll() * chance;

                if(cadetRoll > highestRoll) {
                    highestRoll = cadetRoll;
                    assignedCadet = cadet;
                }

            }
        }

        cadets.remove(assignedCadet);
        return assignedCadet;
    }

    public int getCadetRow(double cadetSeat) {
        return (int)Math.ceil(cadetSeat/seatsByRow);
    }

    public boolean isRigged(int seatNumber) {

        boolean rigged = riggedSeats.containsKey(seatNumber);

        return rigged;
    }

    @Override
    public Class getServiceClass() {
        return SeatingAssignmentLogic.class;
    }
}
