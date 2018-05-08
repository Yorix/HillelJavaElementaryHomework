package com.yorix.hillel.java_elementary.blackjack_task25_32.controllers;

import com.yorix.hillel.java_elementary.blackjack_task25_32.game.Ai;
import com.yorix.hillel.java_elementary.blackjack_task25_32.game.Player;
import com.yorix.hillel.java_elementary.blackjack_task25_32.game.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartWindowController implements Initializable {


    @FXML
    private ListView<Player> playersListView;
    @FXML
    private ComboBox cmbBoxRnd;

    private ResourceBundle resourceBundle;
    private Stage startStage;
    private Table table;
    private ObservableList<Player> players;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resourceBundle = resources;
        Player.resourceBundle = resources;

        cmbBoxRnd.getSelectionModel().select(4);
        players = FXCollections.observableArrayList();
        playersListView.setItems(players);

        players.add(new Player());
        playersListView.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Player> call(ListView<Player> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Player item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty)
                            setGraphic(null);
                        else {
                            setGraphic(item.getNode());
                        }
                    }
                };
            }
        });
    }

    public void setStartStage(Stage startStage) {
        this.startStage = startStage;
    }


    public void createGame() {
        for (Player p : players) {
            p.resetStatistics();
        }

        int numberOfRounds = cmbBoxRnd.getSelectionModel().getSelectedIndex() + 1;

        table = new Table(players);

        startStage.hide();
        showGameWindow();

        table.startGame(numberOfRounds);
    }

    private void showGameWindow() {
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
        gameLoader.setResources(resourceBundle);

        Parent parent = null;
        try {
            parent = gameLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameController gameController = gameLoader.getController();
        gameController.setTable(table);
        gameController.createPlayersViews();

        VBox pane = new VBox();
        pane.getChildren().add(parent);

        for (Player player : table.getPlayers()) {
            VBox playerBox = new VBox(new Label(player.toString()));
            playerBox.getChildren().add(gameController.createCardsListView(player));
            playerBox.setPrefHeight(180);
            playerBox.setPadding(new Insets(5));
            pane.getChildren().add(playerBox);
        }

        Scene scene = new Scene(pane);
        scene.getStylesheets().add("/styles/style.css");

        Stage gameStage = new Stage();
        gameStage.setScene(scene);
        gameStage.setTitle(resourceBundle.getString("key.title"));
        gameStage.setMinWidth(600);
        gameStage.setMinHeight(600);
        gameStage.getIcons().add(new Image("/img/blackjack.png"));
        gameStage.show();

        gameController.setGameStage(gameStage);
        gameController.setParentStage(startStage);
    }

    public void addNewPlayer() {
        if (players.size() < 3) {
            players.add(new Ai(resourceBundle.getString("lbl.AI") + " " + players.size()));
        }
    }

    public void removeLastPlayer() {
        if (players.size() > 1) {
            players.remove(players.size() - 1);
        }
    }
}
