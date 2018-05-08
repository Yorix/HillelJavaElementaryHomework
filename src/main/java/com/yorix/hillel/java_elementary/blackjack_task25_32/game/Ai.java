package com.yorix.hillel.java_elementary.blackjack_task25_32.game;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Ai extends Player {

    private Complexity complexity;


    public Ai(String name) {
        super();
        setName(name + " (" + complexity + ")");
    }

    @Override
    void createNode() {
        ComboBox<Complexity> comboBox = new ComboBox<>();
        setNameLabel(new Label());
        getNameLabel().textProperty().bind(nameProperty());
        comboBox.getItems().add(Complexity.GREEN);
        comboBox.getItems().add(Complexity.ADVANCE);
        comboBox.getItems().add(Complexity.EXPERT);
        complexity = Complexity.GREEN;
        comboBox.getSelectionModel().select(complexity);
        comboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setName(getName().substring(0, 4) + " (" + newValue.toString() + ")");
            complexity = newValue;
        });

        setNode(new HBox(getNameLabel(), comboBox));
    }

    @Override
    public void takeCard(Deck deck) {
        super.takeCard(deck);

        boolean full = StrategyHelper.selectStrategy(complexity).sayStop(getPoints());
        if (full) this.setFull();
    }

    public enum Complexity {
        GREEN("str.green"), ADVANCE("str.advance"), EXPERT("str.expert");

        private String string;

        Complexity(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return resourceBundle.getString(string);
        }
    }
}
