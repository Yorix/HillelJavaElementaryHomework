package com.yorix.hillel.java_elementary.blackjack_task25_32.controllers;

import com.yorix.hillel.java_elementary.blackjack_task25_32.game.Ai;
import com.yorix.hillel.java_elementary.blackjack_task25_32.game.Card;
import com.yorix.hillel.java_elementary.blackjack_task25_32.game.Player;
import com.yorix.hillel.java_elementary.blackjack_task25_32.game.Table;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private Label lblCardValue, lblRoundInfo;
    @FXML
    private Button btnPass, btnDeck, btnNextRound, btnNewGame;

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
        btnNextRound.setText(resourceBundle.getString("btn.start_round"));
        setRoundInfo();
    }

    public void restartRound() {
        btnDeck.setVisible(false);
        btnPass.setVisible(false);
        btnNextRound.setVisible(true);
        btnNextRound.setText(resourceBundle.getString("btn.restart_round"));
        setRoundInfo();
    }

    public void bonusRound() {
        btnDeck.setVisible(false);
        btnPass.setVisible(false);
        btnNextRound.setVisible(true);
        btnNextRound.setText(resourceBundle.getString("btn.bonus_round"));
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

    void setGameStage(Stage gameStage) {
        this.gameStage = gameStage;
    }

    void setParentStage(Stage parentStage) {
        this.parentStage = parentStage;
    }

    private void setRoundInfo() {
        StringBuilder roundInfo = new StringBuilder();
        roundInfo
                .append(resourceBundle.getString("lbl.round"))
                .append(table.getRoundNumber())
                .append(resourceBundle.getString("lbl.of"))
                .append(table.getNumberOfRounds())
                .append(". ");
        if (btnDeck.isVisible()) {
            roundInfo
                    .append(resourceBundle.getString("lbl.move"))
                    .append(table.getCurrentPlayer());
        } else if (btnNextRound.isVisible() && btnNextRound.getText().equals(resourceBundle.getString("btn.start_round"))
                || btnNextRound.getText().equals(resourceBundle.getString("btn.bonus_round"))) {
            roundInfo
                    .append(table.getRoundWinner())
                    .append(resourceBundle.getString("lbl.won"));
        } else if (btnNextRound.isVisible() && btnNextRound.getText().equals(resourceBundle.getString("btn.restart_round"))) {
            roundInfo
                    .append(resourceBundle.getString("lbl.draw"));
        } else {
            roundInfo = new StringBuilder()
                    .append(table.getGameWinner().toString())
                    .append(resourceBundle.getString("lbl.won"));
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
        cardListView.setId("cardListView");
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
                        if (item == null || empty)
                            setGraphic(null);
                        else {
                            setGraphic(item.getImgView());
                        }
                    }
                };
            }
        });
        return cardListView;
    }

    private void initListeners(ListView<Card> cardListView) {
        cardListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> changedOvrrd(cardListView)
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
            sum += card.getValue();
        }
        if (sum == 0) lblCardValue.setVisible(false);
        else lblCardValue.setVisible(true);
        lblCardValue.setText(resourceBundle.getString("lbl.picked_cards_points") + sum);
    }
}
