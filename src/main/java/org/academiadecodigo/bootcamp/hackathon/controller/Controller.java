package org.academiadecodigo.bootcamp.hackathon.controller;

import javafx.scene.Scene;

/**
 * Created by codecadet on 3/17/17.
 */
public interface Controller {

    void initialize();

    void addEventHandler(Scene scene);

    void setServices();

    void manageAssets();
}
