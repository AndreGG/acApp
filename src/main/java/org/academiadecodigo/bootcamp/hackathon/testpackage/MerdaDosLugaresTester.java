package org.academiadecodigo.bootcamp.hackathon.testpackage;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.hackathon.engine.seats.MerdaDosLugaresGrid;

/**
 * Created by codecadet on 3/17/17.
 */
public class MerdaDosLugaresTester extends Application{

    public static void main(String[] args) {

        Application.launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MerdaDosLugaresGrid seats = new MerdaDosLugaresGrid();

        seats.start(primaryStage);
    }
}
