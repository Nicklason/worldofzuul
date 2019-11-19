package com.mycompany.testingmuptiplestages;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {
    @FXML
    private Button toField;
    
    @FXML
    private void switchToField() throws IOException {
        App.setRoot("rooms/field");
    }
    
    @FXML
    private void switchToLake() throws IOException {
        App.setRoot("rooms/lake");
    }
    
    @FXML
    private void switchToSuburb() throws IOException {
        App.setRoot("rooms/suburbs");
    }
    
    @FXML
    private void switchToBigCity() throws IOException {
        App.setRoot("rooms/bigcity");
    }
    
    @FXML
    private void switchToStreet() throws IOException {
        App.setRoot("rooms/street");
    }
    
    @FXML
    private void switchToLobby() throws IOException {
        App.setRoot("rooms/lobby");
    }
}
