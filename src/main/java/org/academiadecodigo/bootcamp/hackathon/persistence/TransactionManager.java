package org.academiadecodigo.bootcamp.hackathon.persistence;

/**
 * Created by codecadet on 3/16/17.
 */
public interface TransactionManager {

    public void beginTransaction();

    public void commitTransaction();

    public void rollbackTransaction();

}
