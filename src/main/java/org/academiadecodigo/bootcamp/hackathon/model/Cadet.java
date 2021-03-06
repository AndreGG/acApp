package org.academiadecodigo.bootcamp.hackathon.model;

/**
 * Created by codecadet on 3/16/17.
 */
public class Cadet {

    private int id;
    private String name;
    private boolean availableToSummerize;
    private int currentSeat;
    private Bootcamp bootcamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailableToSummerize() {
        return availableToSummerize;
    }

    public void setAvailableToSummerize(boolean availableToSummerize) {
        this.availableToSummerize = availableToSummerize;
    }

    public int getCurrentSeat() {
        return currentSeat;
    }

    public void setCurrentSeat(int currentSeat) {
        this.currentSeat = currentSeat;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }
}
