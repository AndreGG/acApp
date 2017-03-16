package org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate;

import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;

/**
 * Created by codecadet on 3/16/17.
 */
public class HibernateBootcampDao extends HibernateDao<Bootcamp> implements BootcampDao {

    public HibernateBootcampDao() {
        super(Bootcamp.class);
    }


}
