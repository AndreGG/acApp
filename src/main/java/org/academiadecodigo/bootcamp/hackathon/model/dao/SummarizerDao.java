package org.academiadecodigo.bootcamp.hackathon.model.dao;

import org.academiadecodigo.bootcamp.hackathon.model.Summarizer;

/**
 * Created by codecadet on 3/16/17.
 */
public interface SummarizerDao extends Dao<Summarizer> {

    Summarizer findByDate(int summarizerNumber);
}
