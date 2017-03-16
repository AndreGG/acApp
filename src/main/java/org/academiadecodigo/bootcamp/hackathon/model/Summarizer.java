package org.academiadecodigo.bootcamp.hackathon.model;

import java.sql.Date;

/**
 * Created by codecadet on 3/16/17.
 */
public class Summarizer {

    private int id;
    private Date date;
    private int summerizerNumber;
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

    public int getSummerizerNumber() {
        return summerizerNumber;
    }

    public void setSummerizerNumber(int summerizerNumber) {
        this.summerizerNumber = summerizerNumber;
    }

    public Cadet getCadetAssigned() {
        return cadetAssigned;
    }

    public void setCadetAssigned(Cadet cadetAssigned) {
        this.cadetAssigned = cadetAssigned;
    }
}
