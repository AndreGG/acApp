package org.academiadecodigo.bootcamp.hackathon.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateCadetDao;
import org.academiadecodigo.bootcamp.hackathon.services.SeatTestService;
import org.academiadecodigo.bootcamp.hackathon.services.ServiceRegistry;


/**
 * Created by codecadet on 3/16/17.
 */
public class seatingController implements Controller {

    private SeatTestService seatTestService;

    @FXML
    private ImageView logo;

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




}
