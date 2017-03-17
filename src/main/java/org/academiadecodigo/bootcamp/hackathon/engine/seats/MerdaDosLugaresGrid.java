package org.academiadecodigo.bootcamp.hackathon.engine.seats;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Created by codecadet on 3/17/17.
 */
public class MerdaDosLugaresGrid {

    private static final int SEATS_BY_ROW = 3;
    private static final int NUMBER_OF_ROWS  = 4;
    private static final int NUMBER_OF_SEATS = SEATS_BY_ROW * NUMBER_OF_ROWS;
    private Seat[] seats;


    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();

        grid.setGridLinesVisible(true);

        Scene scene = new Scene(grid, 400, 400);



        Label[] labels = new Label[NUMBER_OF_SEATS];

        for (int i = 0; i < NUMBER_OF_SEATS; i++) {
            labels[i] = new Label();
            labels[i].setText(String.valueOf(i + 1));
            labels[i].setPrefSize(60, 60);
            labels[i].setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
            labels[i].setPadding(new Insets(10, 10, 10, 10));
            grid.add(labels[i], i % SEATS_BY_ROW, (i / SEATS_BY_ROW) + 1);
        }

        primaryStage.setTitle("MERDA DOS LUGARES");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
