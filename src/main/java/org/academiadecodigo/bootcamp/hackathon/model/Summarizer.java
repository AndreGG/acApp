package org.academiadecodigo.bootcamp.hackathon.model;

import java.sql.Date;

/**
 * Created by codecadet on 3/16/17.
 */
public class Summarizer {

    private int id;
    private Date date;
    private int summarizerNumber;
    private Cadet cadetAssigned;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSummarizerNumber() {
        return summarizerNumber;
    }

    public void setSummarizerNumber(int summarizerNumber) {
        this.summarizerNumber = summarizerNumber;
    }

    public Cadet getCadetAssigned() {
        return cadetAssigned;
    }

    public void setCadetAssigned(Cadet cadetAssigned) {
        this.cadetAssigned = cadetAssigned;
    }
}
