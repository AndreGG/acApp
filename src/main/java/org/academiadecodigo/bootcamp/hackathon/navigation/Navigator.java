package org.academiadecodigo.bootcamp.hackathon.navigation;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.hackathon.controller.Controller;
import org.academiadecodigo.bootcamp.hackathon.controller.SummarizerController;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import static javafx.scene.input.KeyEvent.*;

/**
 * Created by codecadet on 3/16/17.
 */
public final class Navigator {

    private static final String VIEW_PATH = "/views";
    private static Navigator instance = null;
    private LinkedList<Scene> scenes = new LinkedList();
    private Map<String, Initializable> controllers = new HashMap();

    private Stage stage;

    private Navigator() {

    }

    public static synchronized Navigator getInstance() {

        if(instance == null) {
            instance = new Navigator();
        }

        return instance;
    }


    public void loadScreen(String view) {
        try {

            // Instantiate the view and the controller
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + "/" + view + ".fxml"));
            Parent root = fxmlLoader.load();

            //Store the controller
            controllers.put(view, fxmlLoader.<Initializable>getController());

            Controller c = fxmlLoader.getController();

            // Create a new scene and add it to the stack
            Scene scene = new Scene(root);

            c.addEventHandler(scene);

            scenes.push(scene);

            // Put the scene on the stage
            setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failure to load view " + view + " : " + e.getMessage());
        }

    }

    public void back() {
        if (scenes.isEmpty()) {
            return;
        }

        scenes.pop();

        setScene(scenes.peek());
    }

    public void setScene(Scene scene) {

        stage.setScene(scene);
        stage.show();
    }

    public Scene getCurrentScene() {

        return scenes.peek();
    }

    public void setStage(Stage stage) {
        stage.setTitle("<a/C> App");
        this.stage = stage;
    }

    public Initializable getController(String controllerName) {
        return controllers.get(controllerName);

    }

}
