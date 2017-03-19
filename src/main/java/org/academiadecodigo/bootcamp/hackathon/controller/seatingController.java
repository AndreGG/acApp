package org.academiadecodigo.bootcamp.hackathon.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import org.academiadecodigo.bootcamp.hackathon.AudioManager;
import org.academiadecodigo.bootcamp.hackathon.engine.SeatingLogic;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.navigation.Navigator;
import org.academiadecodigo.bootcamp.hackathon.services.BootcampService;
import org.academiadecodigo.bootcamp.hackathon.services.ServiceRegistry;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by codecadet on 3/16/17.
 */
public class SeatingController implements Controller {

    private BootcampService bootS;
    private SeatingLogic sal;
    private int currentSeat = 0;
    private Label[] labels;

    @FXML
    private ImageView logo;
    @FXML
    private GridPane seatingGrid;

    @FXML
    public void initialize() {

        labels = new Label[16];
        ImageView[] images = new ImageView[16];

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHalignment(HPos.CENTER);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setValignment(VPos.TOP);

        for(int i = 0; i < labels.length; i++) {

            labels[i] = new Label();
            images[i] = new ImageView("\\Seat.png");
            Image image = new Image("\\Seat.png");
            images[i].setImage(image);
            Rectangle2D screen = Screen.getPrimary().getVisualBounds();

            System.out.println(screen.getHeight());

            seatingGrid.getColumnConstraints().set(i%4, columnConstraints);
            seatingGrid.getRowConstraints().set(i/4, rowConstraints);

            labels[i].setPadding(new Insets(25, 5, 5, 5));
            labels[i].setText("test");
            labels[i].setAlignment(Pos.CENTER);
            labels[i].setTextAlignment(TextAlignment.CENTER);

            seatingGrid.add(labels[i], i%4, i/4);
            seatingGrid.add(images[i], i%4, i/4);

            System.out.println(seatingGrid.getMinWidth());

            images[i].fitHeightProperty().setValue(seatingGrid.getMinHeight());
            images[i].fitWidthProperty();
        }

        manageAssets();
        setInjections();

    }

    @Override
    public void addEventHandler(Scene scene) {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case R:

                        for(Label label: labels) {
                            label.setText("");
                        }

                        currentSeat = 0;
                        sal.resetCadetList();

                        break;
                    default:
                        //AudioManager.loop("drums", 5);
                        System.out.println(event.getCode() + "" + this.getClass().getSimpleName());
                        break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case SPACE:
                        AudioManager.stopAll();
                        //AudioManager.start("tadaaa");
                        assignSeat();
                        break;
                    default:
                        System.out.println(event.getCode() + "" + this.getClass().getSimpleName());
                        break;
                }
            }
        });
    }

    public void setInjections() {

        this.bootS = (BootcampService)ServiceRegistry.getInstance().getService(BootcampService.class);

        Set<Cadet> bootcampCadets = bootS.getBootcampCadets("Javangers");

        this.sal = new SeatingLogic(bootcampCadets);

        Iterator<Cadet> iterator = bootcampCadets.iterator();

        for(int i = 0; i < bootcampCadets.size(); i++) {

            System.out.println(iterator.next().getName());

        }

    }

    public void assignSeat() {

        if(currentSeat == labels.length) {

            currentSeat = 0;
            sal.resetCadetList();

        }

        System.out.println(currentSeat);

        Cadet cadet = sal.assignSeat(currentSeat);

        System.out.println(cadet);
        System.out.println(labels[currentSeat]);

        labels[currentSeat].setText(cadet.getName());
        currentSeat++;

    }

    public void manageAssets() {

        for(Label label: labels) {
            label.setText("");
        }
    }

    @FXML
    void showAdminSettings(MouseEvent event) {
        AudioManager.stopAll();
        Navigator.getInstance().loadScreen("AdminView");
    }

    @FXML
    void showSeating(ActionEvent event) {
        AudioManager.stopAll();
        Navigator.getInstance().loadScreen("seating");
    }

    @FXML
    void logoClicked(MouseEvent event) {
    }


    @FXML
    void skipToCredits(ActionEvent event) {
        AudioManager.stopAll();
        Navigator.getInstance().loadScreen("credits");
    }

    @FXML
    void skipToSeating(ActionEvent event) {
        AudioManager.stopAll();
        Navigator.getInstance().loadScreen("seating");
    }

    @FXML
    void skipToSummarizer(ActionEvent event) {
        AudioManager.stopAll();
        Navigator.getInstance().loadScreen("summarizer_dum");
    }

    @FXML
    void exitProgram(ActionEvent event) {
        AudioManager.stopAll();
        System.exit(0);
    }

    @FXML
    void showSeating(MouseEvent event) {
        AudioManager.stopAll();
        Navigator.getInstance().loadScreen("seating");
    }

    @FXML
    public void showSummarizer(MouseEvent event) {
        AudioManager.stopAll();
        Navigator.getInstance().loadScreen("Summarizer");
    }
}


