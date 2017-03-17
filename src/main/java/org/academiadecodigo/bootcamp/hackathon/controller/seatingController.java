package org.academiadecodigo.bootcamp.hackathon.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.academiadecodigo.bootcamp.hackathon.engine.SeatingAssignmentLogic;
import org.academiadecodigo.bootcamp.hackathon.engine.seats.Seat;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateCadetDao;
import org.academiadecodigo.bootcamp.hackathon.navigation.Navigator;
import org.academiadecodigo.bootcamp.hackathon.services.SeatTestService;
import org.academiadecodigo.bootcamp.hackathon.services.ServiceRegistry;

import java.util.ArrayList;


/**
 * Created by codecadet on 3/16/17.
 */
public class seatingController implements Controller {

    private SeatTestService seatTestService;
    private ArrayList<Cadet> cadets;

    @FXML
    private ImageView logo;

    @FXML
    private GridPane seatingGrid;

    @FXML
    private TableView<Cadet> cadetsList;

    @FXML
    private TableColumn<Cadet, String> columnCadets;

    @FXML
    public void initialize() {
        seatTestService = (SeatTestService) ServiceRegistry.getInstance().getService(SeatTestService.class);
        columnCadets.setCellValueFactory(new PropertyValueFactory<>("name"));
        cadetsList.getItems().setAll(seatTestService.findAll());
    }

    @Override
    public void addEventHandler(Scene scene) {

    }

    @Override
    public void setServices() {

    }


    @FXML
    void showAdminSettings(MouseEvent event) {

        Navigator.getInstance().loadScreen("AdminView");

    }

    @FXML
    void showSeating(ActionEvent event) {

        Navigator.getInstance().loadScreen("seating");

    }

    @FXML
    void logoClicked(MouseEvent event) {
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

        Navigator.getInstance().loadScreen("summarizer_dum");

    }

    @FXML
    void exitProgram(ActionEvent event) {

        System.exit(0);

    }

    @FXML
    void showSeating(MouseEvent event) {

        Navigator.getInstance().loadScreen("seating");

    }

    @FXML
    void showSummarizer(MouseEvent event) {

        Navigator.getInstance().loadScreen("Summarizer");

    }
}


