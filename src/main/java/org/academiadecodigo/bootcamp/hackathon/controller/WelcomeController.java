package org.academiadecodigo.bootcamp.hackathon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.bootcamp.hackathon.navigation.Navigator;

/**
 * Created by codecadet on 3/16/17.
 */

public class WelcomeController implements Controller {

    @FXML
    private ImageView logo;

    @FXML
    private Button summarizerButton;

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
    void showAdminSettings(MouseEvent event) {
        Navigator.getInstance().loadScreen("AdminView");
    }

    @FXML
    void showCredits(ActionEvent event) {
        Navigator.getInstance().loadScreen("credits");
    }

    @FXML
    void showSeating(ActionEvent event) {
        Navigator.getInstance().loadScreen("seating");
    }

    @FXML
    void showSummarizer(ActionEvent event) {
        Navigator.getInstance().loadScreen("Summarizer");
    }

    @FXML
    public void skipToSummarizer(ActionEvent actionEvent) {
        Navigator.getInstance().loadScreen("Summarizer");
    }

    @FXML
    public void skipToSeating(ActionEvent actionEvent) {
        Navigator.getInstance().loadScreen("seating");
    }

    @FXML
    public void skipToCredits(ActionEvent actionEvent) {
        Navigator.getInstance().loadScreen("credits");
    }


    @Override
    public void initialize() {

    }

    @Override
    public void addEventHandler(Scene scene) {

    }

    @Override
    public void setServices() {

    }

    public void manageAssets() {

    }
}

