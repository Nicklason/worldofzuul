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

/**
 *
 * @author niklas
 */
public class EndScreenController {

    private static Game game = Game.getInstance();

    @FXML
    private ImageView imageview;

    private ArrayList<String> endScene = new ArrayList<>();
    int i = 0;

    @FXML
    public void initialize() {
        System.out.println(game.createEndList());
        endScene = game.createEndList();
        Image img = new Image(endScene.get(i));
        imageview.setImage(img);
    }

    @FXML
    public void next() {
        i++;
        System.out.println(i);
        Image img = new Image(endScene.get(i));
        if (i < endScene.size()-1) {
            
            imageview.setImage(img);
        } else {
            i=0;
            imageview.setImage(img);

        }

    }
    @FXML
    public void previous(){
    Image img = new Image(endScene.get(i));
        if (i != 0) {
            i--;
            imageview.setImage(img);
        }else{
        i= endScene.size()-1;
        imageview.setImage(img);
        }
    }

}
