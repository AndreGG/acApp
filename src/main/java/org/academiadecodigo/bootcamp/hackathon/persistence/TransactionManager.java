package org.academiadecodigo.bootcamp.hackathon.persistence;

/**
 * Created by codecadet on 3/16/17.
 */
public interface TransactionManager {

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

}
