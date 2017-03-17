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

    }

    @FXML
    void showSeating(ActionEvent event) {

    }

    @FXML
    void logoClicked(MouseEvent event) {



    }


    public void skipToSummarizer(ActionEvent actionEvent) {
        Navigator.getInstance().loadScreen("Summarizer");
    }


    public void skipToSeating(ActionEvent actionEvent) {
        Navigator.getInstance().loadScreen("seating");
    }


    public void exitProgram(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void skipToCredits(ActionEvent actionEvent) {
        Navigator.getInstance().loadScreen("credits");
    }
}
