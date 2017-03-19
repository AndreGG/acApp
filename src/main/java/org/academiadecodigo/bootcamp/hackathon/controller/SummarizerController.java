package org.academiadecodigo.bootcamp.hackathon.controller;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import org.academiadecodigo.bootcamp.hackathon.AudioManager;
import org.academiadecodigo.bootcamp.hackathon.navigation.Navigator;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by codecadet on 3/16/17.
 */

public class SummarizerController implements Controller {

    private final int ROTATION_DURATION = 10;
    private int rotateValue = 0;
    private int rotationDuration = 0;
    private boolean spinning = false;
    private Timer spinningTimer;
    private TimerTask rotatingTask;
    private TimerTask incrementingTask;
    private TimerTask rotationTask;
    private boolean slowDown;
    private String[] cadetArray = new String[]{"Chapa", "Toto", "André", "Luizord",
            "Camps", "Alexandre", "Boni", "Vero", "Micael", "Amarals", "Branco"};

    @FXML
    private ImageView logo;

    @FXML
    private Group wheelOfFate;

    @FXML
    private Label topCadetName;

    @FXML
    private Label bottomCadetName;

    @FXML
    void showSettings(MouseEvent event) {

    }

    private boolean changed = false;
    private DoubleProperty amountDue = new SimpleDoubleProperty();

    public void setAmountDue(double amountDue) {
        this.amountDue.set(amountDue);
    }


    public void initialize() {

        spinningTimer = new Timer();
        slowDown = false;

        amountDue.addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue o, Object oldVal,
                                Object newVal) {
                System.out.println("Electric bill has changed!");
                //topCadetName.setText(cadetArray[(int) Math.floor(Math.random() * cadetArray.length)]);

            }
        });

    }

    public void spinWheel(KeyEvent keyEvent) {

    }

    public void spinWheel() {

        if (!spinning) {

            slowDown = false;
            spinning = true;

            rotatingTask = getRotatingTask();
            incrementingTask = getIncrementingTask();
            rotationTask = getRotationDurationTask();

            spinningTimer.scheduleAtFixedRate(rotationTask, 0, 1000);
            spinningTimer.scheduleAtFixedRate(incrementingTask, 0, 500);
            spinningTimer.scheduleAtFixedRate(rotatingTask, 0, 10);

        }

    }

    public void addEventHandler(Scene scene) {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    default:
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
                        spinWheel();
                        AudioManager.start("twilight");
                    default:
                        System.out.println(event.getCode() + "" + this.getClass().getSimpleName());
                        break;
                }
            }
        });

    }

    private TimerTask getIncrementingTask() {

        return new TimerTask() {

            @Override
            public void run() {

                if (slowDown) {

                    if (rotateValue > 1) {
                        rotateValue--;
                    }

                } else if (!slowDown) {

                    if (rotateValue < 10) {
                        rotateValue++;
                    }

                }
            }
        };
    }

    private TimerTask getRotatingTask() {

        return new TimerTask() {
            @Override
            public void run() {
                synchronized (wheelOfFate) {
                    wheelOfFate.setRotate(wheelOfFate.getRotate() + rotateValue);

                    if(wheelOfFate.getRotate() == 180) {

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                topCadetName.setText(cadetArray[(int) Math.floor(Math.random() * cadetArray.length)]);
                            }
                        });

                    }

                    if (wheelOfFate.getRotate() >= 360) {

                        wheelOfFate.setRotate(0);

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                bottomCadetName.setText(cadetArray[(int) Math.floor(Math.random() * cadetArray.length)]);
                            }
                        });

                        //topCadetName.setText(cadetArray[(int) Math.floor(Math.random() * cadetArray.length)]);
                        //setAmountDue(50);

                        if (!spinning) {
                            AudioManager.start("coyote");
                            this.cancel();
                        }

                    }
                }

            }
        };
    }

    private TimerTask getRotationDurationTask() {

        return new TimerTask() {
            @Override
            public void run() {
                rotationDuration++;

                if (rotationDuration == ROTATION_DURATION / 2) {
                    slowDown = true;
                }

                if (rotationDuration >= ROTATION_DURATION) {
                    incrementingTask.cancel();
                    rotationDuration = 0;
                    spinning = false;
                    this.cancel();
                }
            }
        };
    }

    public void setInjections() {

    }

    public void manageAssets() {

    }

    public void skipToSummarizer(ActionEvent actionEvent) {
        AudioManager.stopAll();
        Navigator.getInstance().loadScreen("summarizer_dum");
    }


    public void skipToSeating(ActionEvent actionEvent) {
        AudioManager.stopAll();
        Navigator.getInstance().loadScreen("seating");
    }


    public void exitProgram(ActionEvent actionEvent) {
        AudioManager.stopAll();
        System.exit(0);
    }


    public void skipToCredits(ActionEvent actionEvent) {
        AudioManager.stopAll();
        Navigator.getInstance().loadScreen("credits");
    }
}

