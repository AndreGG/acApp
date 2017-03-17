package org.academiadecodigo.bootcamp.hackathon;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.hackathon.persistence.file.SettingsFileHandler;

/**
 * Created by codecadet on 3/16/17.
 */
public class Main extends Application {

    public void init() {

    }

    public void start(Stage primaryStage) throws Exception {

    }

    public void stop() {

    }

    public static void main(String[] args) {

        SettingsFileHandler myFile = new SettingsFileHandler();
        System.out.println(myFile.getSettings());

        System.exit(1);

    }

}
