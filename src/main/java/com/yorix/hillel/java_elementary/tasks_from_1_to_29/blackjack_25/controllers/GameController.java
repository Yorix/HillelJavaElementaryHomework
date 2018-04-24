package com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.controllers;

import com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.game.Ai;
import com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.game.Card;
import com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.game.Player;
import com.yorix.hillel.java_elementary.tasks_from_1_to_29.blackjack_25.game.Table;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private TableView<Player> tblStat;
    @FXML
    private TableColumn<Player, String> clmnName, clmnPoints, clmnWins;
    @FXML
    private Label lblCardValue;
    @FXML
    private Label lblRoundInfo;
    @FXML
    private Button btnPass;
    @FXML
    private Button btnDeck;
    @FXML
    private Button btnNextRound;
    @FXML
    private Button btnNewGame;

    private ResourceBundle resourceBundle;
    private Stage gameStage;
    private Stage parentStage;
    private Table table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resourceBundle = resources;
    }

    public void deckPressed() {
        table.getCurrentPlayer().takeCard(table.getDeck());
    }

    public void passPressed() {
        table.nextMove();

    }

    public void move() {
        setRoundInfo();
        Player player = table.getCurrentPlayer();
        if (player.getClass() == Ai.class) {
            while (!player.isFull()) {
                deckPressed();
            }
            passPressed();
        }
    }

    public void endRound() {
        btnDeck.setVisible(false);
        btnPass.setVisible(false);
        btnNextRound.setVisible(true);
        btnNextRound.setText(resourceBundle.getString("key.startRound"));
        setRoundInfo();
    }

    public void restartRound() {
        btnDeck.setVisible(false);
        btnPass.setVisible(false);
        btnNextRound.setVisible(true);
        btnNextRound.setText(resourceBundle.getString("key.restartRound"));
        setRoundInfo();
    }

    public void bonusRound() {
        btnDeck.setVisible(false);
        btnPass.setVisible(false);
        btnNextRound.setVisible(true);
        btnNextRound.setText(resourceBundle.getString("key.bonusRound"));
        setRoundInfo();
    }

    public void nextRound() {
        btnDeck.setVisible(true);
        btnPass.setVisible(true);
        btnNextRound.setVisible(false);
        table.startRound();
        setRoundInfo();
    }

    public void gameOver() {
        btnDeck.setVisible(false);
        btnPass.setVisible(false);
        btnNextRound.setVisible(false);
        btnNewGame.setVisible(true);
        setRoundInfo();
    }

    public void newGame() {
        gameStage.close();
        parentStage.show();
    }

    public void setGameStage(Stage gameStage) {
        this.gameStage = gameStage;
    }

    public void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }

    private void setRoundInfo() {
        StringBuilder roundInfo = new StringBuilder();
        roundInfo
                .append(resourceBundle.getString("key.round"))
                .append(table.getRoundNumber())
                .append(resourceBundle.getString("key.of"))
                .append(table.getNumberOfRounds())
                .append(". ");
        if (btnDeck.isVisible()) {
            roundInfo
                    .append(resourceBundle.getString("key.move"))
                    .append(table.getCurrentPlayer());
        } else if (btnNextRound.isVisible() && btnNextRound.getText().equals(resourceBundle.getString("key.startRound"))
                || btnNextRound.getText().equals(resourceBundle.getString("key.bonusRound"))) {
            roundInfo
                    .append(table.getRoundWinner())
                    .append(resourceBundle.getString("key.won"));
        } else if (btnNextRound.isVisible() && btnNextRound.getText().equals(resourceBundle.getString("key.restartRound"))) {
            roundInfo
                    .append(resourceBundle.getString("key.draw"));
        } else {
            roundInfo = new StringBuilder()
                    .append(table.getGameWinner().toString())
                    .append(resourceBundle.getString("key.won"));
        }
        lblRoundInfo.setText(roundInfo.toString());
    }

    void setTable(Table table) {
        this.table = table;
        this.table.setGameController(this);
    }

    void createPlayersViews() {
        clmnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmnPoints.setCellValueFactory(new PropertyValueFactory<>("score"));
        clmnWins.setCellValueFactory(new PropertyValueFactory<>("wins"));
        tblStat.setItems(table.getPlayers());
        tblStat.setSelectionModel(null);
    }

    ListView<Card> createCardsListView(Player player) {
        ListView<Card> cardListView = new ListView<>(player.getPocketCards());
        cardListView.setId("card-list-view");
        cardListView.setMinHeight(160);
        cardListView.setOrientation(Orientation.HORIZONTAL);
        cardListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        initListeners(cardListView);

        cardListView.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Card> call(ListView<Card> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Card item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty || item.getImg() == null)
                            setGraphic(null);
                        else {
                            setGraphic(new ImageView(item.getImg()));
                        }
                    }
                };
            }
        });
        return cardListView;
    }

    private void initListeners(ListView<Card> cardListView) {
        cardListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Card>() {
                    @Override
                    public void changed(ObservableValue<? extends Card> observable, Card oldValue, Card newValue) {
                        GameController.this.changedOvrrd(cardListView);
                    }
                }
        );

        cardListView.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                changedOvrrd(cardListView);
            } else {
                cardListView.getSelectionModel().clearSelection();
            }
        });

        cardListView.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.SECONDARY)) {
                cardListView.getSelectionModel().clearSelection();
            }
        });
    }

    private void changedOvrrd(ListView<Card> listView) {
        int sum = 0;
        for (Card card : listView.getSelectionModel().getSelectedItems()) {
            sum += card.getRank().getValue();
        }
        if (sum == 0) lblCardValue.setVisible(false);
        else lblCardValue.setVisible(true);
        lblCardValue.setText(resourceBundle.getString("key.picked.cards.points") + sum);
    }
}
