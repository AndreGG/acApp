package org.academiadecodigo.bootcamp.hackathon.model.dao;


import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;

import java.util.List;
import java.util.Set;

/**
 * Created by codecadet on 3/16/17.
 */
public interface BootcampDao extends Dao<Bootcamp> {


    Bootcamp findByName(String name);

    Set<Cadet> getCadets(String name);

}
