
package com.mycompany.worldofzuul;

import com.mycompany.rooms.Rooms;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MenuController {
    
    private static Game game = Game.getInstance();

    @FXML
    private TextField txtFieldPlayer;
    @FXML
    private Button btnAnswer;
    @FXML
    private ImageView imgviewPhoto;
    @FXML
    private Button btnPhoto;
    @FXML
    private TextArea txtAreaGirl;
    @FXML
    private ImageView imgviewClair;
    @FXML
    private ImageView speechBubble1;
    @FXML
    private ImageView speechBubble2;
    @FXML
    private ImageView imgviewLakeSign;
    @FXML
    private Button btnSwitchToLake;
    @FXML
    private Button endGameButton;
    @FXML
    private ToggleButton endGameToggle;
    @FXML
    private TextArea endGameTextArea;
    private String playerName;
    
    @FXML
    public void initialize() {
        
     
    }   
    @FXML
    void handleClairPoi(ActionEvent event) {
        speechBubble1.setVisible(true);
        speechBubble2.setVisible(true);
        txtAreaGirl.setVisible(true);
        txtFieldPlayer.setVisible(true);
        btnAnswer.setVisible(true);
        if (imgviewClair.visibleProperty().get() == true){
            imgviewClair.setVisible(false);
        }
    }
   
    @FXML
    void handleClairImage(MouseEvent event) {
    imgviewClair.setVisible(false);
    }

    @FXML
    private void PlayPressed() throws IOException {
        String fxmlPath;

        switch (game.getState()) {
            case FINISHED:
                fxmlPath = "menu/endscreen";
                break;
            case INTRO:
                fxmlPath = "menu/introscene";
                break;
            case PLAYING:
                fxmlPath = "rooms/" + game.getCurrentRoom().getName();
                break;
            default:
                throw new Error("Unknown game state");
        }

        App.setRoot(fxmlPath);
    }
     
    @FXML
    private void HintsPressed() throws IOException {
        App.setRoot("menu/hints");
    }

    @FXML
    private void AboutPressed() throws IOException {
        App.setRoot("menu/about");
    }

    @FXML
    private void HelpPressed() throws IOException {
        App.setRoot("menu/help");
    }
    
    @FXML
    private void BackPressed() throws IOException {
        App.setRoot("menu/menu");
    }

    @FXML
    private void QuitPressed () throws IOException {
        System.exit(0);
    }
    
    @FXML
    private void AnswerPressed() throws IOException {
        
        String girlText = txtAreaGirl.getText();

        if (girlText.equals("Hello, you must be new here...")) {
            if (txtFieldPlayer.getText().trim().isEmpty()) {
                txtFieldPlayer.setPromptText("Say something...");
            } else if (txtFieldPlayer.getText().toLowerCase().equals("hello") || txtFieldPlayer.getText().toLowerCase().equals("hi")){
                txtAreaGirl.setText("My name is Clair. What's your name?");
                txtAreaGirl.setWrapText(true);
                txtFieldPlayer.setPromptText("Choose a name");
                txtFieldPlayer.clear();
            } else {
                txtFieldPlayer.setPromptText("Try saying hello or hi");
                txtFieldPlayer.clear();
            }
        } else if (girlText.equals("My name is Clair. What's your name?")) {
            if (txtFieldPlayer.getText().trim().isEmpty()) {
                txtFieldPlayer.setPromptText("You didn't choose a name");
            } else {  
                playerName=txtFieldPlayer.getText();
                System.out.println(playerName);
                txtAreaGirl.setWrapText(true);
                txtAreaGirl.setText("I come here since I was a little girl. The water was so blue back then. Here see this picture...");
                txtFieldPlayer.clear();
                txtFieldPlayer.setVisible(false);
                speechBubble2.setVisible(false);
                btnAnswer.setVisible(false);
                btnPhoto.setVisible(true);
                txtFieldPlayer.setPromptText(" ");  
            }
        } else if (girlText.equals("I come here since I was a little girl. The water was so blue back then. Here see this picture...")){
            txtAreaGirl.setWrapText(true);
            txtFieldPlayer.clear();
        } else if (girlText.equals("The level in the dam has fallen so much. And the water is dark and polluted. Do you think we can do something to change this?")){
            if (txtFieldPlayer.getText().trim().isEmpty()) {
                txtFieldPlayer.setPromptText("Clair is waiting for your answer...");
            } else if (txtFieldPlayer.getText().toLowerCase().equals("yes")) {
                System.out.println(playerName);
                txtAreaGirl.setText("Thank you"+" "+playerName);
                txtFieldPlayer.setVisible(false);
                speechBubble2.setVisible(false);
                btnAnswer.setVisible(false);
                btnPhoto.setVisible(false);
                imgviewPhoto.setVisible(false);
                imgviewLakeSign.setVisible(true);
                btnSwitchToLake.setVisible(true);
            } else if (txtFieldPlayer.getText().equals("No") || txtFieldPlayer.getText().equals("no")) {
                txtAreaGirl.setText("I guess it's too late to change anything...");
                txtFieldPlayer.setPromptText(" ");
                txtFieldPlayer.clear();
            } else {
                txtFieldPlayer.setPromptText("Answer yes or no");
                txtFieldPlayer.clear();
            }
        }
    }

    @FXML
    void PhotoPressed(ActionEvent event) {
        if (imgviewPhoto.visibleProperty().get()==false){
            txtFieldPlayer.setVisible(true);
            speechBubble2.setVisible(true);
            btnAnswer.setVisible(true); 
            imgviewPhoto.setVisible(true);
            txtAreaGirl.setText("The level in the dam has fallen so much. And the water is dark and polluted. Do you think we can do something to change this?");
            txtFieldPlayer.clear();
            txtFieldPlayer.setPromptText("Answer yes or no");
        } else {
            imgviewPhoto.setVisible(false);
        }
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
