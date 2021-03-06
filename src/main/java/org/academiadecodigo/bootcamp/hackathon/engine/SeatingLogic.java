package org.academiadecodigo.bootcamp.hackathon.engine;

import org.academiadecodigo.bootcamp.hackathon.RNG.RNG;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.services.Service;

import java.util.*;

/**
 * Created by codecadet on 3/16/17.
 */
public class SeatingLogic implements Service {

    private Set<Cadet> cadets;
    private Set<Cadet> backupCadets;
    private HashMap<Integer, String> riggedSeats;

    public SeatingLogic(Set<Cadet> cadets) {

        this.cadets = cadets;
        backupCadets = new HashSet<>();

        for(Cadet cadet: cadets) {
            backupCadets.add(cadet);
        }

        riggedSeats = new HashMap<>();

    }

    public void resetCadetList() {
        for(Cadet cadet: backupCadets) {
            cadets.add(cadet);
        }
    }

    public Cadet assignSeat(int seatNumber) {

        Cadet assignedCadet = null;

        if(isRigged(seatNumber)) {

            /*String cadetName = riggedSeats.get(seatNumber);
            Cadet assignedCadet = cadetDao.findByName(cadetName);
            riggedCadet.setCurrentSeat(seatNumber);*/

        } else {

            double highestRoll = 0;

            for(Cadet cadet: cadets) {

                double currentSeat = cadet.getCurrentSeat();
                double chance = getCadetRow(currentSeat);

                if (currentSeat == 0) {
                    chance = 1;
                }

                double cadetRoll = (RNG.roll() * chance);

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

        int seatsByRow = 4;

        return (int)Math.ceil(cadetSeat/seatsByRow);
    }

    public boolean isRigged(int seatNumber) {

        boolean rigged = riggedSeats.containsKey(seatNumber);

        return rigged;
    }

    @Override
    public Class getServiceClass() {
        return SeatingLogic.class;
    }
}
