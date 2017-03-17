package org.academiadecodigo.bootcamp.hackathon.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;


/**
 * Created by codecadet on 3/16/17.
 */
public class seatingController {



    @FXML
    private ImageView logo;

    @FXML
    private TableView<Cadet> cadetsList;

    @FXML
    private TableColumn<Cadet, String> columnCadets;

    @FXML private void initialize() {
        columnCadets.setCellValueFactory(new PropertyValueFactory<>("name"));

        cadetsList.getItems().setAll(parseCadetList());
    }

    private Cadet parseCadetList() {
        return null;
    }

    @FXML
    void showAdminSettings(MouseEvent event) {

    }

    @FXML
    void showSeating(ActionEvent event) {

    }




}
