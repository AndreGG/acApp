package org.academiadecodigo.bootcamp.hackathon.engine.seats;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Created by codecadet on 3/17/17.
 */
public class Seat {

    private ImageView imageView;

    public Seat() {

        this.imageView = new ImageView("@../Seat.png");

    }

    public ImageView getImageView() {
        return imageView;
    }

}
