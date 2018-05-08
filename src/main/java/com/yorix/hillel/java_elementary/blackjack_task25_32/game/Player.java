package com.yorix.hillel.java_elementary.blackjack_task25_32.game;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ResourceBundle;

public class Player {
    public static ResourceBundle resourceBundle;

    private SimpleStringProperty name;
    private ObservableList<Card> pocketCards;
    private int points;
    private SimpleIntegerProperty score;
    private SimpleIntegerProperty wins;
    private boolean isFull;

    private Node node;
    private TextField textField;
    private Label nameLabel;

    public Player() {
        name = new SimpleStringProperty(resourceBundle.getString("lbl.no_name"));

        pocketCards = FXCollections.observableArrayList();
        score = new SimpleIntegerProperty(0);
        wins = new SimpleIntegerProperty(0);

        createNode();
    }

    void createNode() {
        nameLabel = new Label();
        nameLabel.textProperty().bind(name);
        textField = new TextField();
        textField.setMaxWidth(125);
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (textField.getText().length() > 15) {
                textField.setText(textField.getText().substring(0, 15));
            }
            if (textField.getText().length() == 0) {
                name.setValue(resourceBundle.getString("lbl.no_name"));
            } else {
                name.setValue(textField.getText());
            }
        });
        textField.setPromptText(resourceBundle.getString("lbl.enter_name"));
        setNode(new HBox(nameLabel, textField));
    }

    public void takeCard(Deck deck) {
        if (isFull) return;
        Card card = deck.pull();
        pocketCards.add(card);
        points += card.getValue();
        isFull = points >= 21;
    }

    public void dropPocketCards(Deck deck) {
        score.set(0);
        deck.mergePocketCards(pocketCards);
        pocketCards.clear();
        isFull = false;
        points = 0;
    }

    public void resetStatistics() {
        wins.setValue(0);
    }

    public ObservableList<Card> getPocketCards() {
        return pocketCards;
    }

    public int getPoints() {
        return points;
    }

    public void setFull() {
        isFull = true;
    }

    public boolean isFull() {
        return isFull;
    }

    public void upNumberOfWins() {
        wins.set(wins.get() + 1);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getWins() {
        return wins.get();
    }

    public SimpleIntegerProperty winsProperty() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins.set(wins);
    }

    public int getScore() {
        return score.get();
    }

    public SimpleIntegerProperty scoreProperty() {
        return score;
    }

    public void setScore(int score) {
        this.score.set(score);
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
        ((HBox) node).setSpacing(20);
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    @Override
    public String toString() {
        return name.get();
    }
}
