package org.academiadecodigo.bootcamp.hackathon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import org.academiadecodigo.bootcamp.hackathon.navigation.Navigator;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class CreditsController implements Controller{

    @FXML
    private ImageView logo;

    @FXML
    private MenuItem summarizer;

    @FXML
    private MenuItem seating;

    @FXML
    private MenuItem close;

    @FXML
    private MenuItem help;

    @FXML
    void exitProgram(ActionEvent event) {

        System.exit(0);

    }

    @FXML
    void skipToCredits(ActionEvent event) {

        Navigator.getInstance().loadScreen("credits");

    }

    @FXML
    void skipToSeating(ActionEvent event) {

        Navigator.getInstance().loadScreen("seating");

    }

    @FXML
    void skipToSummarizer(ActionEvent event) {
        Navigator.getInstance().loadScreen("Summarizer");
    }

    @Override
    public void initialize() {

    }

    @Override
    public void addEventHandler(Scene scene) {

    }

    public void setInjections() {

    }
}
