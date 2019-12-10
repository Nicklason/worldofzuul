package com.mycompany.worldofzuul;

import com.mycompany.items.*;
import com.mycompany.pointsofinterest.*;
import com.mycompany.rooms.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class RoomController {

    // Progressbar
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressbarLabel;

    // Listviews and observablelists
    @FXML
    private ListView<Item> playerInventoryListView;
    @FXML
    ObservableList<Item> playerItems;
    @FXML
    ObservableList<Item> poiItems;
    @FXML
    private ListView<Item> poiListView;
    @FXML
    private Label currentPointOfInterestLabel;

    // Toggle group
    @FXML
    private ToggleGroup poiToggle;

    // Toggle buttons for poi's
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
    private ToggleButton leakingpipeToggleButton;
    @FXML
    private ToggleButton streetToggleButton;
    @FXML
    private ToggleButton waterpumpToggleButton;
    @FXML
    private ToggleButton boyToggleButton;
    @FXML
    private ToggleButton vendingmachineToggleButton;
    @FXML
    private ToggleButton storeToggleButton;
    @FXML
    private ToggleButton oldmanToggleButton;
    @FXML
    private ToggleButton billboardToggleButton;
    @FXML
    private ToggleButton containerToggleButton;
    @FXML
    private ToggleButton doorToggleButton;
    @FXML
    private ToggleButton mapToggleButton;

    // Textareas for funfacts
    @FXML
    private TextArea leakingpipeTextarea;
    @FXML
    private TextArea boatTextarea;
    @FXML
    private TextArea irrigationTextarea;
    @FXML
    private TextArea pesticidesTextarea;
    @FXML
    private TextArea waterpumpTextarea;
    @FXML
    private TextArea oldmanTextarea;
    @FXML
    private TextArea containerTextarea;

    // Textareas for descriptions
    @FXML
    private TextArea leakingpipeDescription;
    @FXML
    private TextArea bridgeDescription;
    @FXML
    private TextArea boatDescription;
    @FXML
    private TextArea irrigationDescription;
    @FXML
    private TextArea pesticidesDescription;
    @FXML
    private TextArea farmhouseDescription;
    @FXML
    private TextArea waterpumpDescription;
    @FXML
    private TextArea streetDescription;
    @FXML
    private TextArea boyDescription;
    @FXML
    private TextArea billboardDescription;
    @FXML
    private TextArea containerDescription;
    @FXML
    private TextArea doorDescription;
    @FXML
    private TextArea oldmanDescription;
    @FXML
    private TextArea vendingmachineDescription;
    @FXML
    private TextArea storeDescription;
    @FXML
    private TextArea mapDescription;

    // Textarea for userfeedback
    @FXML
    private TextArea feedbackTextarea;

    private ArrayList<ToggleButton> allToggleButtons = new ArrayList<>();

    private ArrayList<TextArea> allFunfactAreas = new ArrayList<>();

    private ArrayList<TextArea> allDescriptionAreas = new ArrayList<>();
    
    private ArrayList<PointOfInterest> roomPoiList = new ArrayList<>();

    private boolean hasEventAdded = false;

    private static Game game = Game.getInstance();
    
    @FXML
    public void initialize() {
        
        playerItems = FXCollections.observableArrayList();
        playerItems.addAll(game.inventory.getAll());
        playerInventoryListView.setItems(playerItems);
        playerInventoryListView.setCellFactory(Item -> new Cell());

        poiItems = FXCollections.observableArrayList();
        poiListView.setCellFactory(Item -> new Cell());

        allFunfactAreas.addAll(Arrays.asList(leakingpipeTextarea, boatTextarea, irrigationTextarea, pesticidesTextarea, waterpumpTextarea, oldmanTextarea, containerTextarea));
        allDescriptionAreas.addAll(Arrays.asList(leakingpipeDescription, boatDescription, bridgeDescription, irrigationDescription, pesticidesDescription,
                farmhouseDescription, waterpumpDescription, streetDescription, boyDescription, billboardDescription, containerDescription, doorDescription,
                oldmanDescription, vendingmachineDescription, storeDescription, mapDescription));
        


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
        roomPoiList.addAll(game.getCurrentRoom().getPointsOfInterest());
        allToggleButtons.addAll(Arrays.asList(farmhouseToggleButton, pesticidesToggleButton, irrigationToggleButton, bridgeToggleButton, boatToggleButton, leakingpipeToggleButton, streetToggleButton, waterpumpToggleButton,
              boyToggleButton, vendingmachineToggleButton, storeToggleButton, oldmanToggleButton, billboardToggleButton, containerToggleButton, doorToggleButton, mapToggleButton));
        setCheckmark();
    }

    static class Cell extends ListCell<Item> {

        VBox vbox = new VBox();
        Label itemLabel = new Label();
        ImageView img = new ImageView();

        public Cell() {
            super();
            vbox.getChildren().addAll(itemLabel, img);
        }

        @Override
        public void updateItem(Item item, boolean empty) {

            super.updateItem(item, empty);
            setText(null);
            setGraphic(null);

            if (item != null && !empty) {
                img.setImage(new Image(item.getImagePath()));
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
    public void useItem() {
        Item selecetedItem = (Item) playerInventoryListView.getSelectionModel().getSelectedItem();

        if (playerInventoryListView.getSelectionModel().getSelectedItem() == null) {
            setFeedback("No selected Item");
            return;
        }

        if (selecetedItem.use()) {
            // Item was used

            PointOfInterest targetedPoi = game.getCurrentPointOfInterest();

            String currentPoiDescriptionTextArea = (targetedPoi.getName() + "Description");
            for (TextArea descriptionArea : allDescriptionAreas) {
                if (descriptionArea != null) {
                    if ((descriptionArea.getId()).equals(currentPoiDescriptionTextArea)) {
                        descriptionArea.setText(game.getCurrentPointOfInterest().getLongDescription());
                    }
                }
            }

            if (targetedPoi.hasFunfact() && targetedPoi.isFixed()) {
                String currentPoiFunfactTextArea = (targetedPoi.getName() + "Textarea");
                for (TextArea thisArea : allFunfactAreas) {
                    if (thisArea != null) {
                        if ((thisArea.getId()).equals(currentPoiFunfactTextArea)) {
                            thisArea.setText(targetedPoi.getFunfact());
                            thisArea.setVisible(true);
                        }
                    }
                }
            }

            playerItems.clear();
            playerInventoryListView.getItems().clear();
            playerItems.addAll(game.inventory.getAll());
            playerInventoryListView.setItems(playerItems);
            
            poiListView.getItems().clear();
            poiItems.addAll(game.getCurrentPointOfInterest().inventory.getAll());
            poiListView.setItems(poiItems);

            // setFeedback(selecetedItem.getName() + " was used");
            setProgress();
            setCheckmark();
        } else {
            setFeedback("Can't use " + selecetedItem.getName() + " here");
        }
    }

    @FXML
    public void handlePickupPoi(ActionEvent event) {
        Item selectedItem = (Item) poiListView.getSelectionModel().getSelectedItem();

        if (poiListView.getSelectionModel().getSelectedItem() == null) {
            setFeedback("No selected Item");
        } else {
            game.getCurrentPointOfInterest().inventory.remove(selectedItem);
            game.getCurrentPointOfInterest().inventory.getAll();
            poiItems.remove(selectedItem);
            playerItems.add(selectedItem);
            game.inventory.add(selectedItem);

        }

    }

    @FXML
    public void handleDropItem(ActionEvent event) {

        PointOfInterest poi = game.getCurrentPointOfInterest();

        if (poi == null) {
            setFeedback("No poi selected");
            return;
        }

        Item selectedItem = (Item) playerInventoryListView.getSelectionModel().getSelectedItem();

        if (playerInventoryListView.getSelectionModel().getSelectedItem() == null) {
            setFeedback("No selected Item");
        } else {
            poi.inventory.add(selectedItem);
            poiItems.add(selectedItem);

            game.inventory.remove(selectedItem);
            playerItems.remove(selectedItem);
        }
    }

    @FXML
    public void handlePoiToggleEvent(ActionEvent event) {
        setCheckmark();
        // Check toggle group for active toggle
        ToggleButton selectedToggleButton = (ToggleButton) poiToggle.getSelectedToggle();

        // Make arraylist of all poi's in the current room
        ArrayList<PointOfInterest> funFactAreasInCurrentRoom = game.getCurrentRoom().getPointsOfInterest();

        // Check if any of the poi's from the list above has DescriptionTextArea, if so hide it
        for (PointOfInterest pointofinterest : funFactAreasInCurrentRoom) {
            String textAreaPoiName = pointofinterest.getName() + "Description";
            for (TextArea DescriptionTextArea : allDescriptionAreas) {
                if (DescriptionTextArea != null) {
                    if (textAreaPoiName.equals(DescriptionTextArea.getId())) {
                        DescriptionTextArea.setVisible(false);
                    }
                }
            }
        }

        // Check if any of the poi's from the list above has funfactTextArea, if so hide it
        for (PointOfInterest pointofinterest : funFactAreasInCurrentRoom) {
            String textAreaPoiName = pointofinterest.getName() + "Textarea";
            for (TextArea funFactTextArea : allFunfactAreas) {
                if (funFactTextArea != null) {
                    if (textAreaPoiName.equals(funFactTextArea.getId())) {
                        funFactTextArea.setVisible(false);
                    }
                }
            }
        }

        // If no poi is toggeled
        if (selectedToggleButton == null) {
            currentPointOfInterestLabel.setText("None");
            game.setCurrentPointOfInterest(null);
            poiListView.getItems().clear();
            return;
        }

        // Identify the active poi toggle
        PointsOfInterest poi = null;

        if (selectedToggleButton.equals(farmhouseToggleButton)) {
            poi = PointsOfInterest.FARMHOUSE;
        } else if (selectedToggleButton.equals(pesticidesToggleButton)) {
            poi = PointsOfInterest.PESTICIDES;
        } else if (selectedToggleButton.equals(irrigationToggleButton)) {
            poi = PointsOfInterest.IRRIGATION;
        } else if (selectedToggleButton.equals(bridgeToggleButton)) {
            poi = PointsOfInterest.BRIDGE;
        } else if (selectedToggleButton.equals(boatToggleButton)) {
            poi = PointsOfInterest.BOAT;
        } else if (selectedToggleButton.equals(leakingpipeToggleButton)) {
            poi = PointsOfInterest.LEAKINGPIPE;
        } else if (selectedToggleButton.equals(boyToggleButton)) {
            poi = PointsOfInterest.BOY;
        } else if (selectedToggleButton.equals(streetToggleButton)) {
            poi = PointsOfInterest.STREET;
        } else if (selectedToggleButton.equals(waterpumpToggleButton)) {
            poi = PointsOfInterest.WATERPUMP;
        } else if (selectedToggleButton.equals(oldmanToggleButton)) {
            poi = PointsOfInterest.OLDMAN;
        } else if (selectedToggleButton.equals(storeToggleButton)) {
            poi = PointsOfInterest.STORE;
        } else if (selectedToggleButton.equals(vendingmachineToggleButton)) {
            poi = PointsOfInterest.VENDINGMACHINE;
        } else if (selectedToggleButton.equals(doorToggleButton)) {
            poi = PointsOfInterest.LOCKEDDOOR;
        } else if (selectedToggleButton.equals(containerToggleButton)) {
            poi = PointsOfInterest.CONTAINER;
        } else if (selectedToggleButton.equals(billboardToggleButton)) {
            poi = PointsOfInterest.BILLBOARD;
        } else if (selectedToggleButton.equals(mapToggleButton)) {
            poi = PointsOfInterest.MAP;
        } else {
            throw new Error("Unknown poi button");
        }

        String poiName = poi.getName();
        PointOfInterest newPoi = game.getCurrentRoom().getPointOfInterest(poiName);

        if (!newPoi.isFixed()) {
            selectedToggleButton.setStyle("-fx-graphic: url('images/misc/markerGreenSmall.png')");
        }

        // Set poi
        game.setCurrentPointOfInterest(newPoi);

        // Update label
        currentPointOfInterestLabel.setText(poiName);

        // Set poi description corresponding to wether it is fixed or not
        String currentPoiDescriptionTextArea = (newPoi.getName() + "Description");
        for (TextArea descriptionArea : allDescriptionAreas) {
            if (descriptionArea != null) {
                if ((descriptionArea.getId()).equals(currentPoiDescriptionTextArea)) {
                    descriptionArea.setText(newPoi.getLongDescription());
                    descriptionArea.setVisible(true);
                }
            }
        }

        // If poi has funfact and isfixed set and display
        if (newPoi.hasFunfact() && newPoi.isFixed()) {
            String currentPoiFunfactTextArea = (newPoi.getName() + "Textarea");
            for (TextArea thisArea : allFunfactAreas) {
                if (thisArea != null) {
                    if ((thisArea.getId()).equals(currentPoiFunfactTextArea)) {
                        thisArea.setText(newPoi.getFunfact());
                        thisArea.setVisible(true);
                    }
                }
            }
        }

        // Update list view
        poiListView.getItems().clear();
        poiItems.addAll(newPoi.inventory.getAll());
        poiListView.setItems(poiItems);
    }

    @FXML
    private void switchToField() throws IOException {
        
        game.setCurrentRoom(game.getRoom(Rooms.FIELD.getName()));
        game.setCurrentPointOfInterest(null);
        App.setRoot("rooms/field");
    }

    @FXML
    private void switchToLake() throws IOException {
        
        game.setCurrentRoom(game.getRoom(Rooms.LAKE.getName()));
        game.setCurrentPointOfInterest(null);
        App.setRoot("rooms/lake");
    }

    @FXML
    private void switchToSuburb() throws IOException {
        
        game.setCurrentRoom(game.getRoom(Rooms.SUBURBS.getName()));
        game.setCurrentPointOfInterest(null);
        App.setRoot("rooms/suburbs");
    }

    @FXML
    private void switchToBigCity() throws IOException {
        
        game.setCurrentRoom(game.getRoom(Rooms.BIGCITY.getName()));
        game.setCurrentPointOfInterest(null);
        App.setRoot("rooms/bigcity");
    }

    @FXML
    private void switchToStreet() throws IOException {
        
        game.setCurrentRoom(game.getRoom(Rooms.STREET.getName()));
        game.setCurrentPointOfInterest(null);
        App.setRoot("rooms/street");
    }

    @FXML
    private void switchToLobby() throws IOException {
        game.setState(Game.GameState.IN_LOBBY);
        game.setCurrentRoom(game.getRoom(Rooms.LOBBY.getName()));
        game.setCurrentPointOfInterest(null);
        App.setRoot("menu/lobby");
    }

    @FXML
    private void switchToFactory() throws IOException {
        if (game.getRoom(Rooms.STREET.getName()).getPointOfInterest(PointsOfInterest.LOCKEDDOOR.getName()).isFixed()) {
            game.setCurrentRoom(game.getRoom(Rooms.FACTORY.getName()));
            game.setCurrentPointOfInterest(null);
            App.setRoot("rooms/factory");

        } else {
            setFeedback("The door is locked");
        }

    }

    public void setFeedback(String msg) {

        feedbackTextarea.setText(msg);
        feedbackTextarea.setVisible(true);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                feedbackTextarea.setVisible(false);
            }
        }, 2500L);
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

    public void setCheckmark() {
        for (PointOfInterest poi : roomPoiList) {
            for (ToggleButton togglebutton : allToggleButtons) {
                if (togglebutton != null) {
                    if (togglebutton.getId().substring(0, togglebutton.getId().length() - 12).equals(poi.getName())) {
                        if (poi.isFixed()) {
                            togglebutton.setStyle("-fx-graphic: url('images/misc/checkmark.png')");
                        } else {
                            togglebutton.setStyle("-fx-graphic: url('images/misc/markerRsmall.png')");
                        }
                    }
                }
            }
        }

    }
}
