package org.academiadecodigo.bootcamp.hackathon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.bootcamp.hackathon.navigation.Navigator;

/**
 * Created by codecadet on 3/16/17.
 */

public class WelcomeController {

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
    void exitProgramm(ActionEvent event) {
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

    }

    @FXML
    void showSummarizer(ActionEvent event) {
        Navigator.getInstance().loadScreen("Summarizer");
    }

}

