/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.worldofzuul;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import com.mycompany.rooms.Rooms;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author nicol
 */


public class LobbyController {
    
    private static Game game = Game.getInstance();
    
    // Progressbar
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressbarLabel;
    
    @FXML
    private Button endGameButton;
    @FXML
    private ToggleButton endGameToggle;
    @FXML
    private TextArea endGameTextArea;
    
    private boolean hasEventAdded = false;
    
    @FXML
    public void initialize() {
        if (!hasEventAdded) {
            Scene scene = App.getScene();

            scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent> () {
                @Override
                public void handle(KeyEvent t) {
                    if(t.getCode() == KeyCode.ESCAPE) {
                        try {
                            App.setRoot("menu/menu");
                        } catch (IOException err) {
                            System.out.println("Oof");
                        }
                    }
                }
            });
        }

        progressBar.setProgress(game.progress);
        progressbarLabel.setText(game.fixedCount + "/9 Completed");
     
    }   
   
   
    @FXML
    private void switchToLake() throws IOException {
        game.setState(Game.GameState.PLAYING);
        game.setCurrentRoom(game.getRoom(Rooms.LAKE.getName()));
        game.setCurrentPointOfInterest(null);
        App.setRoot("rooms/lake");
    }

    public void endGame() {
        if (endGameToggle.isSelected()) {
            endGameButton.setVisible(true);
            endGameTextArea.setVisible(true);
            endGameTextArea.setText("are you done with the game?"); 
        } else {
            endGameButton.setVisible(false);
            endGameTextArea.setVisible(false);
        }
    }
    
    public void switchToEndScreen()throws IOException{
        game.setState(Game.GameState.FINISHED);
        App.setRoot("menu/endscreen");
    }
}
