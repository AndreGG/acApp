package org.academiadecodigo.bootcamp.hackathon.services;

import org.academiadecodigo.bootcamp.hackathon.model.Cadet;

import java.util.Set;

/**
 * Created by andre on 3/18/2017.
 */
public abstract class BootcampService implements Service {

    public abstract void addCadet(Cadet cadet);

    public abstract void addBootcamp();

    public abstract Set<Cadet> getBootcampCadets(String bootcampName);

    @Override
    public Class getServiceClass() {
        return BootcampService.class;
    }

}
