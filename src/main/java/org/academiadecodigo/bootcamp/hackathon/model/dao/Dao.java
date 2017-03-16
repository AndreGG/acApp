package org.academiadecodigo.bootcamp.hackathon.model.dao;

import java.util.List;

/**
 * Created by codecadet on 3/16/17.
 */
public interface Dao<E> {

    void create(E e);

    void update(E e);

    void delete(E e);

    E findById(int id);

    List<E> findAll();

    long count();

}
