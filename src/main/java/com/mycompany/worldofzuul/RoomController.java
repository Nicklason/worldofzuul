package com.mycompany.worldofzuul;

import com.mycompany.worldofzuul.*;
import com.mycompany.items.*;
import com.mycompany.pointsofinterest.*;
import com.mycompany.rooms.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class RoomController {
    @FXML
    private ListView<Item> playerInventoryListView;
    
    @FXML
    ObservableList<Item> playerItems;
    
    @FXML
    ObservableList<Item> poiItems;
    
    @FXML
    private ListView poiListView;
    
    @FXML
    private Label currentPointOfInterestLabel;
    
    @FXML
    private ToggleGroup fieldToggle;
    
    @FXML
    private ToggleButton farmhouseToggleButton;
    @FXML
    private ToggleButton pesticidesToggleButton;
    @FXML
    private ToggleButton irrigationToggleButton;
    
    private Game game = new Game();
    
    
    
    @FXML
    public void initialize(){
        
        playerItems = FXCollections.observableArrayList();
        //playerItems.addAll(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.FARMHOUSE.getName()).inventory.getAll());
        playerInventoryListView.setItems(playerItems);
        playerInventoryListView.setCellFactory(Item -> new Cellplayerinventory());
        
        poiItems = FXCollections.observableArrayList();
        poiListView.setCellFactory(Item -> new Cellpoiinventory());
                
    }
    
    static class Cellplayerinventory extends ListCell<Item> {
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        
        Label itemLabel = new Label();
        Button useBtn = new Button("Use");
        Button dropBtn = new Button("Drop");
        
        Image itemImage = new Image("PNG/markerRsmall.png");
        ImageView img = new ImageView(itemImage);
        
        public Cellplayerinventory(){
            super();
            hbox.getChildren().addAll(useBtn,dropBtn);
            vbox.getChildren().addAll(itemLabel,img,hbox);
        }
        
        @Override
        public void updateItem(Item item,boolean empty){
            super.updateItem(item, empty);
            setText(null);
            setGraphic(null);
            
            if (item != null && !empty) {
                useBtn.setId("Usebtn");
                dropBtn.setId("Dropbtn");
                hbox.setId("Btncontainer");
                hbox.setAlignment(Pos.CENTER);
                vbox.setId("InvItemcontainer");
                vbox.setAlignment(Pos.CENTER);
                img.setId("Imagecontainer");
                itemLabel.setId("ItemLabel");
                itemLabel.setAlignment(Pos.CENTER);
                itemLabel.setText(item.getName());
                setGraphic(vbox);
            }
        }
                
    }
    
    static class Cellpoiinventory extends ListCell<Item> {
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        Label itemLabel = new Label();
        Button pickupBtn = new Button("Pickup");
        Image itemImage = new Image("PNG/markerRsmall.png");
        ImageView img = new ImageView(itemImage);
        
        
        public Cellpoiinventory(){
            super();
            hbox.getChildren().addAll(pickupBtn);
            vbox.getChildren().addAll(itemLabel,img,hbox);
        }
        
        @Override
        public void updateItem(Item item,boolean empty){
            
            super.updateItem(item, empty);
            setText(null);
            setGraphic(null);
            
            if (item != null && !empty) {
                pickupBtn.setId("Pickup");
                pickupBtn.setOnAction(e -> handlePickup(item.getName()));
                hbox.setId("Btncontainer");
                hbox.setAlignment(Pos.CENTER);
                vbox.setId("InvItemcontainer");
                vbox.setAlignment(Pos.CENTER);
                img.setId("Imagecontainer");
                itemLabel.setId("ItemLabel");
                itemLabel.setAlignment(Pos.CENTER);
                itemLabel.setText(item.getName());
                setGraphic(vbox);
            }
        }
                
    }
    @FXML
    public static void handlePickup(String item){
        System.err.println("Picking up "+ item);
       
    }
    
    @FXML
    public void handlePoiToggleEvent(ActionEvent event){
      
        ToggleButton selectedToggleButton = (ToggleButton) fieldToggle.getSelectedToggle();
        System.out.println(selectedToggleButton);
        
        if (selectedToggleButton == null) {
            System.out.println("Nothing toggeled");
            currentPointOfInterestLabel.setText("None");
            game.setCurrentPointOfInterest(null);
            poiListView.getItems().clear();
        } else {
            if (selectedToggleButton.equals(farmhouseToggleButton)) {
                currentPointOfInterestLabel.setText(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.FARMHOUSE.getName()).getName());
                game.setCurrentPointOfInterest(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.FARMHOUSE.getName()));
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.FARMHOUSE.getName()).inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(pesticidesToggleButton)) {
                currentPointOfInterestLabel.setText(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.PESTICIDES.getName()).getName());
                game.setCurrentPointOfInterest(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.PESTICIDES.getName()));
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.PESTICIDES.getName()).inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(irrigationToggleButton)) {
                currentPointOfInterestLabel.setText(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.IRRIGATION.getName()).getName());
                game.setCurrentPointOfInterest(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.IRRIGATION.getName()));
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.IRRIGATION.getName()).inventory.getAll());
                poiListView.setItems(poiItems);
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
