package org.academiadecodigo.bootcamp.hackathon.model;

import java.util.Set;

/**
 * Created by codecadet on 3/16/17.
 */
public class Bootcamp {

    private int id;
    private String name;
    private Set<Cadet> cadets;

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

    public Set<Cadet> getCadets() {
        return cadets;
    }

    public void setCadets(Set<Cadet> cadets) {
        this.cadets = cadets;
    }
}
