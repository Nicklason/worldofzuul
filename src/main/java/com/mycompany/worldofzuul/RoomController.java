package com.mycompany.worldofzuul;

import com.mycompany.worldofzuul.*;
import com.mycompany.items.*;
import com.mycompany.pointsofinterest.*;
import com.mycompany.rooms.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class RoomController {
    @FXML
    private ListView playerInventoryListView;
    
    @FXML
    private ListView poiListView;
    
    @FXML
    private ToggleGroup fieldToggle;
    
    @FXML
    private ToggleButton farmhouseToggleButton;
    @FXML
    private ToggleButton pesticidesToggleButton;
    @FXML
    private ToggleButton irrigationToggleButton;
    
    
    @FXML
    public void handlePoiToggleEvent(ActionEvent event){
        
        ToggleButton selectedToggleButton = (ToggleButton) fieldToggle.getSelectedToggle();
        System.out.println(selectedToggleButton);
        
        if (selectedToggleButton == null) {
            System.out.println("Nothing toggeled");
        } else {
            if (selectedToggleButton.equals(farmhouseToggleButton)) {
                System.out.println("This is the farmhouse");
               
            }
            if (selectedToggleButton.equals(pesticidesToggleButton)) {
                System.out.println("This is the pesticides");
            }
            if (selectedToggleButton.equals(irrigationToggleButton)) {
                System.out.println("This is the irrigation");
            }  
        }
            
        

    }
    
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
