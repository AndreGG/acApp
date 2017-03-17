package org.academiadecodigo.bootcamp.hackathon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.navigation.Navigator;
import org.academiadecodigo.bootcamp.hackathon.services.AdminService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AdminSettingsController {

    private AdminService adminService;

    @FXML
    private MenuItem summarizer;

    @FXML
    private MenuItem seating;

    @FXML
    private MenuItem close;

    @FXML
    private MenuItem help;

    @FXML
    private Button createButton;

    @FXML
    private Button manageButton;

    @FXML
    private Label totalOfCadets;

    @FXML
    private TextField textNrOfCadets;

    @FXML
    private Label bootcampName;

    @FXML
    private TextField textBootcampName;

    @FXML
    private Label bootcampNumber;

    @FXML
    private TextField textBootcampNumber;

    @FXML
    private Label cadet1;

    @FXML
    private Label cadet2;

    @FXML
    private Label cadet3;

    @FXML
    private Label cadet4;

    @FXML
    private Label cadet5;

    @FXML
    private Label cadet6;

    @FXML
    private Label cadet7;

    @FXML
    private Label cadet8;

    @FXML
    private Label cadet9;

    @FXML
    private Label cadet10;

    @FXML
    private Label cadet11;

    @FXML
    private Label cadet12;

    @FXML
    private Label cadet13;

    @FXML
    private Label cadet14;

    @FXML
    private Label cadet15;

    @FXML
    private Label cadet16;

    @FXML
    private Label cadet17;

    @FXML
    private Label cadet18;

    @FXML
    private Label cadet19;

    @FXML
    private Label cadet20;

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    private TextField text3;

    @FXML
    private TextField text4;

    @FXML
    private TextField text5;

    @FXML
    private TextField text6;

    @FXML
    private TextField text7;

    @FXML
    private TextField text8;

    @FXML
    private TextField text9;

    @FXML
    private TextField text10;

    @FXML
    private TextField text11;

    @FXML
    private TextField text12;

    @FXML
    private TextField text13;

    @FXML
    private TextField text14;

    @FXML
    private TextField text15;

    @FXML
    private TextField text16;

    @FXML
    private TextField text17;

    @FXML
    private TextField text18;

    @FXML
    private TextField text19;

    @FXML
    private TextField text20;

    @FXML
    private Button submitButton;

    @FXML
    private ChoiceBox<?> bootcampList;

    @FXML
    private Label selectBootcamp;

    @FXML
    private Button changeNameButton;

    @FXML
    private Label newName;

    private ArrayList<TextField> textFieldsCadets;

    @FXML
    void exitProgramm(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void showCredits(ActionEvent event) {

    }

    @FXML
    void showSeating(ActionEvent event) {

    }

    @FXML
    void showSummarizer(ActionEvent event) {
        Navigator.getInstance().loadScreen("Summarizer");
    }

    @FXML
    void submitNewBootcamp(MouseEvent event) {

        populateTextFieldCadets();

        Set<Cadet> cadets = new HashSet<>();

        Bootcamp bootcamp = new Bootcamp();

        bootcamp.setName(textBootcampName.getText());

        for(int i = 0; i < textFieldsCadets.size() - 1; i++){
            String nameCadet = textFieldsCadets.get(i).getText();

            if(nameCadet != null) {

                Cadet cadet = new Cadet();
                cadet.setName(nameCadet);
                cadet.setCurrentSeat(0);

                cadets.add(cadet);
            }
        }

        bootcamp.setCadets(cadets);

        adminService.createBootcamp(bootcamp);
    }

    @FXML
    void showCreateElements(MouseEvent event) {
        setManageElementsVisible(false);
        setCreateElementsVisible(true);
    }


    @FXML
    void showManageElements(MouseEvent event) {
        setCreateElementsVisible(false);
        setManageElementsVisible(true);
    }

    @FXML
    void saveNameChange(MouseEvent event) {
        
    }

    private void populateTextFieldCadets(){

        textFieldsCadets.add(1, text1);
        textFieldsCadets.add(2, text2);
        textFieldsCadets.add(3, text3);
        textFieldsCadets.add(4, text4);
        textFieldsCadets.add(5, text5);
        textFieldsCadets.add(6, text6);
        textFieldsCadets.add(7, text7);
        textFieldsCadets.add(8, text8);
        textFieldsCadets.add(9, text9);
        textFieldsCadets.add(10, text10);
        textFieldsCadets.add(11, text11);
        textFieldsCadets.add(12, text12);
        textFieldsCadets.add(13, text13);
        textFieldsCadets.add(14, text14);
        textFieldsCadets.add(15, text15);
        textFieldsCadets.add(16, text16);
        textFieldsCadets.add(17, text17);
        textFieldsCadets.add(18, text18);
        textFieldsCadets.add(19, text19);
        textFieldsCadets.add(20, text20);

    }

    private void setCreateElementsVisible(boolean isVisible) {
        totalOfCadets.setVisible(isVisible);
        textNrOfCadets.setVisible(isVisible);
        bootcampName.setVisible(isVisible);
        textBootcampName.setVisible(isVisible);
        bootcampNumber.setVisible(isVisible);
        textBootcampNumber.setVisible(isVisible);

        cadet1.setVisible(isVisible);
        text1.setVisible(isVisible);
        cadet2.setVisible(isVisible);
        text2.setVisible(isVisible);
        cadet3.setVisible(isVisible);
        text3.setVisible(isVisible);
        cadet4.setVisible(isVisible);
        text4.setVisible(isVisible);
        cadet5.setVisible(isVisible);
        text5.setVisible(isVisible);
        cadet6.setVisible(isVisible);
        text6.setVisible(isVisible);
        cadet7.setVisible(isVisible);
        text7.setVisible(isVisible);
        cadet8.setVisible(isVisible);
        text8.setVisible(isVisible);
        cadet9.setVisible(isVisible);
        text9.setVisible(isVisible);
        cadet10.setVisible(isVisible);
        text10.setVisible(isVisible);
        cadet11.setVisible(isVisible);
        text11.setVisible(isVisible);
        cadet12.setVisible(isVisible);
        text12.setVisible(isVisible);
        cadet13.setVisible(isVisible);
        text13.setVisible(isVisible);
        cadet14.setVisible(isVisible);
        text14.setVisible(isVisible);
        cadet15.setVisible(isVisible);
        text15.setVisible(isVisible);
        cadet16.setVisible(isVisible);
        text16.setVisible(isVisible);
        cadet17.setVisible(isVisible);
        text17.setVisible(isVisible);
        cadet18.setVisible(isVisible);
        text18.setVisible(isVisible);
        cadet19.setVisible(isVisible);
        text19.setVisible(isVisible);
        cadet20.setVisible(isVisible);
        text20.setVisible(isVisible);

        submitButton.setVisible(isVisible);
    }

    private void setManageElementsVisible(boolean isVisible) {
        selectBootcamp.setVisible(isVisible);
        bootcampList.setVisible(isVisible);
        newName.setVisible(isVisible);
        changeNameButton.setVisible(isVisible);
    }
}
