package org.academiadecodigo.bootcamp.hackathon.controller;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.MenuItem;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import org.academiadecodigo.bootcamp.hackathon.navigation.Navigator;

public class WelcomeController implements Controller{

    @FXML
    private ImageView logo;

    @FXML
    private Button summarizerButton;

    @FXML
    private Button seatingButton;

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
    void showSeating(MouseEvent event) {

        Navigator.getInstance().loadScreen("seating");

    }

    @FXML
    void showSummarizer(MouseEvent event) {

        Navigator.getInstance().loadScreen("Summarizer");

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

    @Override
    public void setServices() {

    }
}


