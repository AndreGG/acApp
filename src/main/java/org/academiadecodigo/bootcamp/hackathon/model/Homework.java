package org.academiadecodigo.bootcamp.hackathon.model;

import java.sql.Date;

/**
 * Created by codecadet on 3/16/17.
 */
public class Homework {

    private int id;
    private Date date;
    private String subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Cadet getCadetAssigned() {
        return cadetAssigned;
    }

    public void setCadetAssigned(Cadet cadetAssigned) {
        this.cadetAssigned = cadetAssigned;
    }
}
