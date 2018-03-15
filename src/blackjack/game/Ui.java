package blackjack.game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Ui extends JFrame implements ResetRound {
    private int numberOfPlayers;
    private JPanel window;
    private JPanel header;
    private JPanel headerLeft;
    private JPanel headerCenter;
    private JPanel headerRight;
    private JPanel table;
    private JPanel[] playersFields;
    private JButton deck;
    private JButton pass;
    private JButton nextRound;
    private ImageIcon backSide;
    private Border border;
    private Border emptyBorder;
    private JComboBox<String> selectNumOfPlayers;
    private JButton startGame;
    private JLabel[] cards;
    private JLabel roundInfo;

    private Game game;
    private final int numberOfRounds = 3;


    public Ui() {
        super("Black Jack");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocation(300, 100);

        window = new JPanel(new BorderLayout());
        header = new JPanel(new GridLayout(1, 3));
        headerLeft = new JPanel();
        headerCenter = new JPanel();
        headerRight = new JPanel();
        table = new JPanel(new GridLayout());
        backSide = new ImageIcon("src/blackjack/src/deck/0_back.png");
        String[] np = {"2", "3", "4"};
        selectNumOfPlayers = new JComboBox<>(np);
        selectNumOfPlayers.setSelectedIndex(0);
        deck = new JButton(backSide);
        pass = new JButton("ПАСС!");
        border = BorderFactory.createEtchedBorder();
        emptyBorder = BorderFactory.createEmptyBorder(10, 20, 10, 20);
        startGame = new JButton("Начать игру");
        nextRound = new JButton("Следующий раунд");
        roundInfo = new JLabel();


        headerLeft.setBorder(emptyBorder);
        headerCenter.setBorder(emptyBorder);
        headerRight.setBorder(emptyBorder);
        header.setBorder(border);

        window.setBackground(Color.GRAY);
        header.setBackground(Color.LIGHT_GRAY);
        headerLeft.setBackground(Color.LIGHT_GRAY);
        headerCenter.setBackground(Color.LIGHT_GRAY);
        headerRight.setBackground(Color.LIGHT_GRAY);
        table.setBorder(border);
        table.setBackground(Color.GRAY);

        deck.setMargin(new Insets(0, 0, 0, 0));
        deck.setBorderPainted(false);
        deck.setFocusPainted(false);
        deck.setBackground(Color.LIGHT_GRAY);
        deck.setEnabled(false);

        headerLeft.add(roundInfo);
        headerCenter.add(deck);
        headerRight.add(new JLabel("<html><font color='116644' size='4'>Выберите количество игроков</font></html>"));
        headerRight.add(selectNumOfPlayers);
        headerRight.add(startGame);

        header.add(headerLeft);
        header.add(headerCenter);
        header.add(headerRight);

        window.add(header, BorderLayout.PAGE_START);

        setContentPane(window);
        setVisible(true);

        startGame.addActionListener(e -> {
            numberOfPlayers = selectNumOfPlayers.getSelectedIndex() + 2;
            playersFields = new JPanel[numberOfPlayers];
            for (int i = 0; i < numberOfPlayers; i++) {
                playersFields[i] = new JPanel();
                playersFields[i].setBackground(Color.LIGHT_GRAY);
                playersFields[i].setBorder(border);
                playersFields[i].setVisible(false);
                table.add(playersFields[i]);
            }
            window.add(table);
            game = new Game(numberOfPlayers, numberOfRounds);
            game.round();
            start();
        });

        deck.addActionListener(e -> {
            String card = game.takeCard();
            if (card == null) {
                nextMove();
                return;
            }
            playersFields[game.getActivePlayerNumber()].add(new Label(card));
            roundInfo.setText(getRoundInfo());
            window.updateUI();
        });

        pass.addActionListener(e -> {
            nextMove();
            window.updateUI();
        });

        nextRound.addActionListener(e -> {
            clearTable();
            start();
        });
    }

    private void start() {
        headerLeft.removeAll();
        headerRight.removeAll();
        headerRight.add(pass);
        deck.setEnabled(true);
        roundInfo.setText(getRoundInfo());
        headerLeft.add(roundInfo);
        redrawTable();
        window.updateUI();
    }

    private void redrawTable() {
        for (int i = 0; i < numberOfPlayers; i++) {
            playersFields[i].setVisible(false);
        }
        playersFields[game.getActivePlayerNumber()].setVisible(true);
    }

    private void clearTable() {
        for (int i = 0; i < numberOfPlayers; i++) {
            playersFields[i].removeAll();
        }
    }

    private void nextMove() {
        if (game.getActivePlayerNumber() >= game.getNumberOfPlayers() - 1) {
            round();
            return;
        }
        playersFields[game.getActivePlayerNumber()].setVisible(false);
        game.pass();
        roundInfo.setText(getRoundInfo());
        playersFields[game.getActivePlayerNumber()].setVisible(true);
    }

    private String getRoundInfo() {
        return "<html><font color='444411' size='6'>Раунд " + (game.getRoundNumber() + 1) +
                "<br><br>Игрок " + (game.getActivePlayerNumber() + 1) + "</font></html>";
    }

    @Override
    public void round() {
        for (int i = 0; i < numberOfPlayers; i++) {
            playersFields[i].setBackground(Color.LIGHT_GRAY);
            playersFields[i].setVisible(true);
        }
        game.pass();
        deck.setEnabled(false);
        headerLeft.removeAll();
        headerLeft.add(new JLabel("!"));
        headerRight.removeAll();
        headerRight.add(nextRound);
        window.updateUI();
    }
}
