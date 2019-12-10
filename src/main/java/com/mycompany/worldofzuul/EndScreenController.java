/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.worldofzuul;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author niklas
 */
public class EndScreenController {
    @FXML
    private AnchorPane endAnchorpane;
    private static Game game = Game.getInstance();

    @FXML
    private ImageView imageview;

    private ArrayList<String> endPictures = new ArrayList<>();
    int i = 0;

    @FXML
    public void initialize() {
        endPictures = game.getEndPictures();
        imageview.setImage(new Image(endPictures.get(i)));
        endAnchorpane.setStyle("-fx-background-color: #000000;");
    }

    @FXML
    public void next() {
        System.out.println(i);

        if (i < endPictures.size() - 1) {
            // There are more pictures in the list
            i++;
        } else {
            // Reached end of the list, go back to the start
            i = 0;
        }

        imageview.setImage(new Image(endPictures.get(i)));
    }

    @FXML
    public void previous() {
        System.out.println(i);

        if (i == 0) {
            // Reached start of the list, go to the end of it
            i = endPictures.size() - 1;
        } else {
            // There are more pictures in the list
            i--;
        }

        imageview.setImage(new Image(endPictures.get(i)));
    }
}
