package org.academiadecodigo.bootcamp.hackathon.controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.academiadecodigo.bootcamp.hackathon.engine.SeatingAssignmentLogic;
import org.academiadecodigo.bootcamp.hackathon.engine.seats.Seat;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateCadetDao;
import org.academiadecodigo.bootcamp.hackathon.services.SeatTestService;
import org.academiadecodigo.bootcamp.hackathon.services.ServiceRegistry;

import java.util.ArrayList;


/**
 * Created by codecadet on 3/16/17.
 */
public class seatingController implements Controller {

    private SeatTestService seatTestService;
    private ArrayList<Cadet> cadets;
    private SeatingAssignmentLogic sal;
    private ArrayList<Label> labelArray;
    private int currentSeat = 0;

    @FXML
    private ImageView logo;
    @FXML
    private GridPane seatingGrid;
    @FXML
    private TableView<Cadet> cadetsList;
    @FXML
    private TableColumn<Cadet, String> columnCadets;
    @FXML
    private Label seat1;
    @FXML
    private Label seat2;
    @FXML
    private Label seat3;
    @FXML
    private Label seat4;
    @FXML
    private Label seat5;
    @FXML
    private Label seat6;
    @FXML
    private Label seat7;
    @FXML
    private Label seat8;
    @FXML
    private Label seat9;
    @FXML
    private Label seat10;
    @FXML
    private Label seat11;
    @FXML
    private Label seat12;
    @FXML
    private Label seat13;
    @FXML
    private Label seat14;
    @FXML
    private Label seat15;
    @FXML
    private Label seat16;

    @FXML
    public void initialize() {

        setServices();
        seatTestService = (SeatTestService) ServiceRegistry.getInstance().getService(SeatTestService.class);
        columnCadets.setCellValueFactory(new PropertyValueFactory<>("name"));
        cadetsList.getItems().setAll(seatTestService.findAll());

    }

    @Override
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
                        assignSeat();
                    default:
                        System.out.println(event.getCode() + " tou dentro");
                        break;
                }
            }
        });

    }

    @Override
    public void setServices() {

        this.sal = (SeatingAssignmentLogic)ServiceRegistry.getInstance().getService(SeatingAssignmentLogic.class);
        System.out.println("SAL Service " + sal);

    }

    public void assignSeat() {

        for(Label label: labelArray) {

            Cadet cadet = sal.assignSeat(labelArray.indexOf(label));
            label.setText(cadet.getName());
            cadets.remove(cadet);
            cadetsList.getItems().remove(cadet);

        }

    }

    @Override
    public void manageAssets() {

        labelArray = new ArrayList<>();

        labelArray.add(seat1);
        labelArray.add(seat2);
        labelArray.add(seat3);
        labelArray.add(seat4);
        labelArray.add(seat5);
        labelArray.add(seat6);
        labelArray.add(seat7);
        labelArray.add(seat8);
        labelArray.add(seat9);
        labelArray.add(seat10);
        labelArray.add(seat11);
        labelArray.add(seat12);
        labelArray.add(seat13);
        labelArray.add(seat14);
        labelArray.add(seat15);
        labelArray.add(seat16);

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




}
