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
import javafx.geometry.Insets;
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
    private ToggleGroup poiToggle;
    
    @FXML
    private ToggleButton farmhouseToggleButton;
    @FXML
    private ToggleButton pesticidesToggleButton;
    @FXML
    private ToggleButton irrigationToggleButton;
    @FXML
    private ToggleButton bridgeToggleButton;
    @FXML
    private ToggleButton boatToggleButton;
    @FXML
    private ToggleButton leakingPipeToggleButton;
    @FXML
    private ToggleButton streetToggleButton;
    @FXML
    private ToggleButton pumpToggleButton;
    @FXML
    private ToggleButton boyToggleButton;
    @FXML
    private ToggleButton vendingMachineToggleButton;
    @FXML
    private ToggleButton storeToggleButton;
    @FXML
    private ToggleButton oldmanToggleButton;
    @FXML
    private ToggleButton billboardToggleButton;
    @FXML
    private ToggleButton containerToggleButton;
    @FXML
    private ToggleButton lockedDoorToggleButton;
    
    
    private static Game game = new Game();
    
    
    
    @FXML
    public void initialize(){
        
        playerItems = FXCollections.observableArrayList();
        playerItems.addAll(game.inventory.getAll());
        playerInventoryListView.setItems(playerItems);
        playerInventoryListView.setCellFactory(Item -> new Cellplayerinventory());
        
        poiItems = FXCollections.observableArrayList();
        poiListView.setCellFactory(Item -> new Cellpoiinventory());
                
    }
    
    static class Cellplayerinventory extends ListCell<Item> {
        VBox vbox = new VBox();
        Label itemLabel = new Label();
        ImageView img = new ImageView();
        
        public Cellplayerinventory(){
            super();
            vbox.getChildren().addAll(itemLabel,img);
        }
        
        @Override
        public void updateItem(Item item,boolean empty){
            super.updateItem(item, empty);
            setText(null);
            setGraphic(null);
            
            if (item != null && !empty) {
                img.setImage(new Image("PNG/"+item.getImagePath()));
                vbox.setPrefHeight(120);
                vbox.setId("InvItemcontainer");
                vbox.setAlignment(Pos.CENTER);
                img.setId("Imagecontainer");
                itemLabel.setPadding(new Insets(0, 0, 0, 0));
                itemLabel.setId("ItemLabel");
                itemLabel.setAlignment(Pos.CENTER);
                itemLabel.setText(item.getName());
                setGraphic(vbox);
            }
        }
                
    }
    
    static class Cellpoiinventory extends ListCell<Item> {
        VBox vbox = new VBox();
        Label itemLabel = new Label();
        ImageView img = new ImageView();
        
        public Cellpoiinventory(){
            super();
            vbox.getChildren().addAll(itemLabel,img);
        }
        
        @Override
        public void updateItem(Item item,boolean empty){
            
            super.updateItem(item, empty);
            setText(null);
            setGraphic(null);
            
            if (item != null && !empty) {
                img.setImage(new Image("PNG/"+item.getImagePath()));
                vbox.setPrefHeight(120);
                vbox.setId("InvItemcontainer");
                vbox.setAlignment(Pos.CENTER);
                img.setId("Imagecontainer");
                itemLabel.setPadding(new Insets(0, 0, 0, 0));
                itemLabel.setId("ItemLabel");
                itemLabel.setAlignment(Pos.CENTER);
                itemLabel.setText(item.getName());
                setGraphic(vbox);
            }
        }
                
    }
    
    @FXML
    public void handlePickupPoi(ActionEvent event){
        System.out.println("Clicking pickup btn");
        Item selectedItem = (Item) poiListView.getSelectionModel().getSelectedItem();
        
        if (poiListView.getSelectionModel().getSelectedItem() == null) {
            System.out.println("No selected Item!");
        } else {
            game.getCurrentPointOfInterest().inventory.remove(selectedItem);
            game.getCurrentPointOfInterest().inventory.getAll();
            poiItems.remove(selectedItem);
            playerItems.add(selectedItem);
            game.inventory.add(selectedItem);
            
        }
        
    }
    @FXML
    public void handleDropItem(ActionEvent event){
        System.out.println("Clicking drop btn");
        Item selectedItem = (Item) playerInventoryListView.getSelectionModel().getSelectedItem();
        
        if (playerInventoryListView.getSelectionModel().getSelectedItem() == null) {
            System.out.println("No selected Item!");
        } else {
            game.getCurrentPointOfInterest().inventory.add(selectedItem);
            poiItems.add(selectedItem);
            game.inventory.remove(selectedItem);
            playerItems.remove(selectedItem);
            
        }
    }
    
    @FXML
    public void handlePoiToggleEvent(ActionEvent event){
      
        ToggleButton selectedToggleButton = (ToggleButton) poiToggle.getSelectedToggle();
        System.out.println(selectedToggleButton);
        
        if (selectedToggleButton == null) {
            System.out.println("Nothing toggeled");
            currentPointOfInterestLabel.setText("None");
            game.setCurrentPointOfInterest(null);
            poiListView.getItems().clear();
        } else {
            if (selectedToggleButton.equals(farmhouseToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.FARMHOUSE.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(pesticidesToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.PESTICIDES.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(irrigationToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.FIELD.getName()).getPointOfInterest(PointsOfInterest.IRRIGATION.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(bridgeToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.LAKE.getName()).getPointOfInterest(PointsOfInterest.BRIDGE.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(boatToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.LAKE.getName()).getPointOfInterest(PointsOfInterest.BOAT.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(leakingPipeToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.LAKE.getName()).getPointOfInterest(PointsOfInterest.LEAKINGPIPE.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(boyToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.SUBURBS.getName()).getPointOfInterest(PointsOfInterest.BOY.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(streetToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.SUBURBS.getName()).getPointOfInterest(PointsOfInterest.STREET.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(pumpToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.SUBURBS.getName()).getPointOfInterest(PointsOfInterest.WATERPUMP.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(oldmanToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.BIGCITY.getName()).getPointOfInterest(PointsOfInterest.OLDMAN.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(storeToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.BIGCITY.getName()).getPointOfInterest(PointsOfInterest.STORE.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(vendingMachineToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.BIGCITY.getName()).getPointOfInterest(PointsOfInterest.VENDINGMACHINE.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(lockedDoorToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.STREET.getName()).getPointOfInterest(PointsOfInterest.LOCKEDDOOR.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(containerToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.STREET.getName()).getPointOfInterest(PointsOfInterest.CONTAINER.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
            if (selectedToggleButton.equals(billboardToggleButton)) {
                game.setCurrentPointOfInterest(game.getRoom(Rooms.STREET.getName()).getPointOfInterest(PointsOfInterest.BILLBOARD.getName()));
                currentPointOfInterestLabel.setText(game.getCurrentPointOfInterest().getName());
                
                poiListView.getItems().clear();
                poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
                poiListView.setItems(poiItems);
            }
        }
            
        

    }
    
    @FXML
    private void switchToField() throws IOException {
        App.setRoot("rooms/field");
        game.setCurrentRoom(game.getRoom(Rooms.FIELD.getName()));
        game.setCurrentPointOfInterest(null);
    }
    
    @FXML
    private void switchToLake() throws IOException {
        App.setRoot("rooms/lake");
        game.setCurrentRoom(game.getRoom(Rooms.LAKE.getName()));
        game.setCurrentPointOfInterest(null);
    }
    
    @FXML
    private void switchToSuburb() throws IOException {
        App.setRoot("rooms/suburbs");
        game.setCurrentRoom(game.getRoom(Rooms.SUBURBS.getName()));
        game.setCurrentPointOfInterest(null);
    }
    
    @FXML
    private void switchToBigCity() throws IOException {
        App.setRoot("rooms/bigcity");
        game.setCurrentRoom(game.getRoom(Rooms.BIGCITY.getName()));
        game.setCurrentPointOfInterest(null);
    }
    
    @FXML
    private void switchToStreet() throws IOException {
        App.setRoot("rooms/street");
        game.setCurrentRoom(game.getRoom(Rooms.STREET.getName()));
        game.setCurrentPointOfInterest(null);
    }
    
    @FXML
    private void switchToLobby() throws IOException {
        App.setRoot("rooms/lobby");
        game.setCurrentRoom(game.getRoom(Rooms.LOBBY.getName()));
        game.setCurrentPointOfInterest(null);
    }
}
