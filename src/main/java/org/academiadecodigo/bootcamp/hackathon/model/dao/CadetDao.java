package org.academiadecodigo.bootcamp.hackathon.model.dao;

import org.academiadecodigo.bootcamp.hackathon.model.Cadet;

/**
 * Created by codecadet on 3/16/17.
 */
public interface CadetDao extends Dao<Cadet> {

    Cadet findByName(String cadetName);

}
