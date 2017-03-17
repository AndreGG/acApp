package org.academiadecodigo.bootcamp.hackathon.testpackage;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.dao.CadetDao;


/**
 * Created by codecadet on 3/17/17.
 */
public class ListTester extends Application {


    private TableView<Cadet> table = new TableView<>();
    private final ObservableList<Cadet> data =
            FXCollections.observableArrayList(
                    new Cadet("António"),
                    new Cadet("Amaral"),
                    new Cadet("André"),
                    new Cadet("Giuliano"));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(500);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("Cadets");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Cadet, String>("name"));


        table.setItems(data);
        table.getColumns().addAll(firstNameCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Cadet {

        private final String name;


        private Cadet(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}

