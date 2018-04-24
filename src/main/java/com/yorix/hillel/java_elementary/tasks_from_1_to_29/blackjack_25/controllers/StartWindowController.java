package com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.controllers;

import com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.game.Game;
import com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.game.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartWindowController implements Initializable {

    @FXML
    private TextField txtPlayerName;
    @FXML
    private CheckBox checkBoxDemo;
    @FXML
    private ComboBox cmbBoxAI, cmbBoxRnd;

    private ResourceBundle resourceBundle;
    private Stage startStage;
    private Game game;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resourceBundle = resources;
        cmbBoxAI.getSelectionModel().select(0);
        cmbBoxRnd.getSelectionModel().select(0);
    }

    public void setStartStage(Stage startStage) {
        this.startStage = startStage;
    }


    public void createGame() {
        int numberOfRounds = cmbBoxRnd.getSelectionModel().getSelectedIndex() + 1;
        int numberOfPlayers = cmbBoxAI.getSelectionModel().getSelectedIndex() + 1;
        String playerName = txtPlayerName.getText();

        game = new Game(resourceBundle, numberOfPlayers, checkBoxDemo.isSelected(), playerName);

        startStage.hide();
        showGameWindow();

        game.getTable().startGame(numberOfRounds);
    }

    private void showGameWindow() {
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("../fxml/game.fxml"));
        gameLoader.setResources(resourceBundle);

        Parent parent = null;
        try {
            parent = gameLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameController gameController = gameLoader.getController();
        gameController.setTable(game.getTable());
        gameController.createPlayersViews();

        VBox pane = new VBox();
        pane.getChildren().add(parent);

        for (Player player : game.getTable().getPlayers()) {
            VBox playerBox = new VBox(new Label(player.toString()));
            playerBox.getChildren().add(gameController.createCardsListView(player));
            playerBox.setPrefHeight(180);
            playerBox.setPadding(new Insets(5));
            pane.getChildren().add(playerBox);
        }

        Scene scene = new Scene(pane);
        scene.getStylesheets().add("com/yorix/hillel/java_elementary/tasks_from_1_to_29/blackjack_25/styles/style.css");

        Stage gameStage = new Stage();
        gameStage.setScene(scene);
        gameStage.setTitle(resourceBundle.getString("key.title"));
        gameStage.setMinWidth(600);
        gameStage.setMinHeight(600);
        gameStage.show();

        gameController.setGameStage(gameStage);
        gameController.setParentStage(startStage);
    }
}
