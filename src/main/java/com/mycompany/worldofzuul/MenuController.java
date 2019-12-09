
package com.mycompany.worldofzuul;

//import com.mycompany.pointsofinterest.PointOfInterest;
import com.mycompany.pointsofinterest.*;
import com.mycompany.rooms.Room;
import com.mycompany.rooms.Rooms;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MenuController {
    
    private static Game game = Game.getInstance();
    
    private static boolean doneIntro = false;
    
    // Progressbar
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressbarLabel;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnHints;
    @FXML
    private Button btnAbout;
    @FXML
    private Button btnHelp;
    @FXML
    private TextField txtFieldPlayer;
    @FXML
    private Button btnAnswer;
    @FXML
    private TextField txtfieldGirl;
    @FXML
    private ImageView imgviewPhoto;
    @FXML
    private Button btnPhoto;
    @FXML
    private TextArea txtAreaGirl;
    @FXML
    private ImageView imgviewClair;
    @FXML
    private ToggleButton clairToggleButton;
    @FXML
    private ToggleGroup poiToggle;
    @FXML
    private ImageView speechBubble1;
    @FXML
    private ImageView speechBubble2;
    @FXML
    private ImageView imgviewLakeSign;
    @FXML
    private Button btnSwitchToLake;
    
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
        if (doneIntro) {
            App.setRoot("rooms/" + game.getCurrentRoom().getName());
        } else {
            doneIntro = true;
            App.setRoot("menu/introscene");
        }
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
        String playerName;
        String girlText = txtAreaGirl.getText();

        if (girlText.equals("Hello, you must be new here...")) {
            if (txtFieldPlayer.getText().trim().isEmpty()) {
                txtFieldPlayer.setPromptText("Say something...");
            } else if (txtFieldPlayer.getText().equals("Hello") || txtFieldPlayer.getText().equals("hello")||txtFieldPlayer.getText().equals("Hi")||txtFieldPlayer.getText().equals("hi")){
                txtAreaGirl.setText("My name is Clair. What's your name?");
                txtAreaGirl.setWrapText(true);
                txtFieldPlayer.setPromptText("Choose a name");
                txtFieldPlayer.clear();
            } else {
                txtFieldPlayer.setPromptText("Try saying hello or hi");
                txtFieldPlayer.clear();
            }
        }

        if (girlText.equals("My name is Clair. What's your name?")) {
            if (txtFieldPlayer.getText().trim().isEmpty()) {
                txtFieldPlayer.setPromptText("You didn't choose a name");
            } else {  
                playerName=txtFieldPlayer.getText();
                txtAreaGirl.setWrapText(true);
                txtAreaGirl.setText("I come here since I was a little girl. The water was so blue back then. Here see this picture...");
                txtFieldPlayer.setPromptText("Take the picture");
                txtFieldPlayer.clear();
                btnPhoto.setVisible(true);
                txtFieldPlayer.setPromptText(" ");  
            }
        }

        if (girlText.equals("I come here since I was a little girl. The water was so blue back then. Here see this picture...")){
            txtAreaGirl.setWrapText(true);
            txtFieldPlayer.clear();
        }

        if (girlText.equals("The level in the dam has fallen so much. And the water is dark and polluted. Do you think we can do something to change this?")){
            if (txtFieldPlayer.getText().trim().isEmpty()) {
                txtFieldPlayer.setPromptText("Clair is waiting for your answer...");
            } else if (txtFieldPlayer.getText().equals("Yes") || txtFieldPlayer.getText().equals("yes")) {
                txtAreaGirl.setText("Thank you");
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
        game.setCurrentRoom(game.getRoom(Rooms.LAKE.getName()));
        game.setCurrentPointOfInterest(null);
        App.setRoot("rooms/lake");
    }
    public void setProgress() {
        ArrayList<PointOfInterest> allFixablePois = new ArrayList<>();

        for (Room room : game.rooms) {
            for (PointOfInterest pointofinterest : room.getPointsOfInterest()) {
                if (pointofinterest.isFixable()) {
                    allFixablePois.add(pointofinterest);
                }
            }
        }

        int fixedPoiCount = 0;

        for (PointOfInterest poi : allFixablePois) {
            if (poi.isFixed()) {
                fixedPoiCount++;
            }
        }
        double newProgress = fixedPoiCount * 0.111;
        game.fixedCount = fixedPoiCount;
        game.progress = newProgress;
        progressBar.setProgress(newProgress);
        progressbarLabel.setText(fixedPoiCount + "/" + allFixablePois.size() + " Completed");
    }
}
