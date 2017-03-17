package org.academiadecodigo.bootcamp.hackathon.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import org.academiadecodigo.bootcamp.hackathon.navigation.Navigator;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by codecadet on 3/16/17.
 */

public class SummarizerController implements Controller {

    private final int ROTATION_DURATION = 6;
    private int rotateValue = 0;
    private int rotationDuration = 0;
    private boolean spinning = false;
    private Timer spinningTimer;
    private TimerTask rotatingTask;
    private TimerTask incrementingTask;
    private TimerTask rotationTask;
    private boolean slowDown;

    @FXML
    private ImageView logo;

    @FXML
    private Group wheelOfFate;

    @FXML
    void showSettings(MouseEvent event) {

    }

    public void initialize() {

        spinningTimer = new Timer();
        slowDown = false;

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
                        System.out.println(event.getCode() + " tou dentro");
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
                    default:
                        System.out.println(event.getCode() + " tou dentro");
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

                    if(rotateValue > 1) {
                        rotateValue--;
                    }

                } else if (!slowDown) {

                    if(rotateValue < 10) {
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

                    if (wheelOfFate.getRotate() >= 360) {
                        wheelOfFate.setRotate(0);
                        System.out.println("here before cancel");
                        System.out.println(spinning);
                        if(!spinning) {
                            System.out.println("here at cancel");
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

                if(rotationDuration == ROTATION_DURATION - 2) {
                    slowDown = true;
                }

                if(rotationDuration >= ROTATION_DURATION) {
                    incrementingTask.cancel();
                    rotationDuration = 0;
                    spinning = false;
                    this.cancel();
                }
            }
        };
    }

    @Override
    public void setServices() {

    }
}

