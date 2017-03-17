package org.academiadecodigo.bootcamp.hackathon;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.hackathon.navigation.Navigator;
import org.academiadecodigo.bootcamp.hackathon.services.ServiceInitializer;
import org.academiadecodigo.bootcamp.hackathon.testpackage.SQLLoader;

/**
 * Created by codecadet on 3/16/17.
 */
public class Main extends Application {



    @Override
    public void init() {

        SQLLoader sqlLoader = new SQLLoader();
        ServiceInitializer serviceInitializer = new ServiceInitializer();
        serviceInitializer.init();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigator.getInstance().setStage(primaryStage);
        Navigator.getInstance().loadScreen("Welcome");

    }

    @Override
    public void stop() {

    }

    public static void main(String[] args) {
        launch(args);
    }

}
