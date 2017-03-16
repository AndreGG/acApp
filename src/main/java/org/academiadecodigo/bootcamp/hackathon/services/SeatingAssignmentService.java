package org.academiadecodigo.bootcamp.hackathon.services;

import org.academiadecodigo.bootcamp.hackathon.RNG.RNG;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.CadetDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.file.SettingsFileHandler;

import java.util.HashMap;
import java.util.List;

/**
 * Created by codecadet on 3/16/17.
 */
public abstract class SeatingAssignmentService {

    private CadetDao cadetDao;
    private BootcampDao bootcampDao;
    private List<Cadet> cadets;
    private HashMap<String, Integer> riggedSeats;
    private int seatsByRow;

    public SeatingAssignmentService(CadetDao cadetDao, BootcampDao bootcamp) {

        this.cadetDao = cadetDao;
        this.bootcampDao = bootcamp;
        this.cadets = bootcampDao();
        seatsByRow = SettingsFileHandler.getSeatsByRow();

    }

    private List<Cadet> bootcampDao() {
    }

    public Cadet assignSeat(int seatNumber) {

        if(isRigged(seatNumber)) {

            String name = SettingsFileHandler.getCadetName();
            Cadet riggedCadet = cadetDao.findByName(name);
            riggedCadet.setCurrentSeat(seatNumber);

            cadets.remove(riggedCadet);
            return riggedCadet;

        } else {

            int highestRoll = 0;
            Cadet assignedCadet = null;

            for(Cadet cadet: cadets) {

                double currentSeat = cadet.getCurrentSeat();
                int chance = getCadetRow(currentSeat);

                int cadetRoll = RNG.roll() * chance;

                if(cadetRoll > highestRoll) {

                    highestRoll = cadetRoll;
                    assignedCadet = cadet;

                }

            }

            cadets.remove(assignedCadet);
            return assignedCadet;
        }
    }

    public int getCadetRow(double cadetSeat) {
        return (int)Math.ceil(cadetSeat/seatsByRow);
    }

    public boolean isRigged(int seatNumber) {

        boolean rigged = false;




        return rigged;
    }

}
