package org.academiadecodigo.bootcamp.hackathon.controller;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.MenuItem;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import org.academiadecodigo.bootcamp.hackathon.AudioManager;
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
    void skipToSeating(ActionEvent event) {
        Navigator.getInstance().loadScreen("seating");
    }

    @FXML
    void skipToCredits(ActionEvent event) {

        Navigator.getInstance().loadScreen("credits");
    }

    @FXML
    void showSummarizer(ActionEvent event) {
        Navigator.getInstance().loadScreen("summarizer_dum");
    }

    @FXML
    public void skipToSummarizer(ActionEvent actionEvent) {
        Navigator.getInstance().loadScreen("summarizer_dum");
    }



    @Override
    public void initialize() {
        AudioManager.load(new String[]{"twilight", "coyote", "drums", "tadaaa"});
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


