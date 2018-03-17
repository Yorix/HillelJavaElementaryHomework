package blackjack.game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Game extends JFrame {
    private final int DECK_SIZE = 32;
    private int numberOfRounds;
    private int numberOfPlayers;

    private Table table;
    private Player winner;
    private Player activePlayer;
    private int activePlayerNumber;
    private int roundNumber;
    private JPanel window;
    private JPanel header;
    private JPanel headerLeft;
    private JPanel headerCenter;
    private JPanel headerRight;
    private JPanel tablePane;
    private JPanel[] playersPanes;
    private JButton deck;
    private JButton pass;
    private JButton nextRound;
    private ImageIcon backSide;
    private Border border;
    private Border emptyBorder;
    private JComboBox<String> selectNumOfPlayers;
    private JButton startGame;
    private JLabel roundInfo;


    public Game(int numberOfRounds) {
        super("Black Jack");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocation(200, 100);

        this.numberOfRounds = numberOfRounds;
        window = new JPanel(new BorderLayout());
        header = new JPanel(new GridLayout(1, 3));
        headerLeft = new JPanel();
        headerCenter = new JPanel();
        headerRight = new JPanel();
        tablePane = new JPanel(new GridLayout());
        backSide = new ImageIcon("src/blackjack/src/deck/0_back.png");
        String[] np = {"2", "3", "4"};
        selectNumOfPlayers = new JComboBox<>(np);
        selectNumOfPlayers.setSelectedIndex(0);
        deck = new JButton(backSide);
        pass = new JButton("ПАСС!");
        border = BorderFactory.createEtchedBorder();
        emptyBorder = BorderFactory.createEmptyBorder(10, 20, 10, 20);
        startGame = new JButton("Начать игру");
        nextRound = new JButton();
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
        tablePane.setBorder(border);
        tablePane.setBackground(Color.GRAY);

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
            table = new Table(DECK_SIZE, numberOfPlayers);
            playersPanes = new JPanel[numberOfPlayers];
            for (int i = 0; i < numberOfPlayers; i++) {
                playersPanes[i] = new JPanel();
                playersPanes[i].setBackground(Color.LIGHT_GRAY);
                playersPanes[i].setBorder(border);
                playersPanes[i].setVisible(false);
                tablePane.add(playersPanes[i]);
            }
            window.add(tablePane);
            startRound();
        });

        deck.addActionListener(e -> {
            if (!activePlayer.isFull()) {
                Card card = activePlayer.takeCard(table.getDeck());
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon("src/blackjack/src/deck/" + card.toString()));
                playersPanes[activePlayerNumber].add(label);

                updateRoundInfo();
                window.updateUI();
            }
        });

        pass.addActionListener(e -> {
            nextMove();
            window.updateUI();
        });

        nextRound.addActionListener(e -> {
            clearTable();
            startRound();
        });
    }

    /**
     * Начало раунда.
     * Обнуление счётчика активного игрока. Присвоение activePlayer ссылки на игрока из table по индексу 0.
     * Обнуление данных объектов "игрок" и "колода".
     * Перемешивание колоды.
     * Добавление кнопки "ПАСС!" на панель.
     * Обновление информации о состоянии раунда через метод updateRoundInfo().
     * Добавление информации о состоянии раунда.
     * Активация кнопки "колода".
     * Возвращение панели "стол" в начальное состояние через метод redrawTable().
     */
    private void startRound() {
        activePlayerNumber = 0;
        activePlayer = table.getPlayers()[0];
        for (Player player : table.getPlayers()) {
            player.round();
        }
        table.getDeck().round();
        table.getDeck().shuffle();

        headerRight.removeAll();
        headerRight.add(pass);
        updateRoundInfo();
        headerLeft.add(roundInfo);
        deck.setEnabled(true);
        redrawTable();
        window.updateUI();
    }

    /**
     * Окончание раунда.
     * Отображаются панели с картами всех игроков.
     * Удаляется кнопка "ПАСС!". Кнопка "колода" помечается как неактивная.
     * Выясняется победитель в методе expose().
     * Выводятся результаты раунда через метод showResults().
     * Выполняется проверка на окончание игры. Если true - вывод результатов. Если false - отображение кнопки "Cледующий раунд".
     */
    private void endRound() {
        for (int i = 0; i < numberOfPlayers; i++) {
            playersPanes[i].setVisible(true);
        }
        deck.setEnabled(false);
        headerRight.removeAll();

        winner = expose();
        showResults(winner);

        if (roundNumber >= numberOfRounds) {
            StringBuilder resultOfGame = new StringBuilder("<html><font color='116644' size='4'>Итоги: <br>");
            int maxWins = 0;
            for (Player player : table.getPlayers()) {
                resultOfGame.append(player).append(" победил в ")
                        .append(player.getNumberOfWins()).append(" раундах.<br>");
                if (player.getNumberOfWins() > maxWins) {
                    winner = player;
                    maxWins = winner.getNumberOfWins();
                }
            }
            resultOfGame.append("</font><font color='0000ff' size='5'>" +
                    "<br>Победитель:<br></font><font color='ff7700' size='16'>")
                    .append(winner).append("</font></html>");
            headerRight.add(new JLabel(resultOfGame.toString()));
        } else {
            headerRight.add(nextRound);
        }
        window.updateUI();
    }

    /**
     * Переход хода.
     * Проверка на конец раунда посредством проверки превышения номера активного игрока над общим числом игроков.
     * Скрытие игровой панели стола для активного игрока.
     * Приращение номера активного игрока, получение активного игрока по номеру.
     * Вызов метода обновления информации о раунде.
     * Отображение панели стола для нового активного игрока.
     */
    private void nextMove() {
        if (activePlayerNumber >= numberOfPlayers - 1) {
            endRound();
            return;
        }
        playersPanes[activePlayerNumber].setVisible(false);
        activePlayer = table.getPlayers()[++activePlayerNumber];
        updateRoundInfo();
        playersPanes[activePlayerNumber].setVisible(true);
    }

    /**
     * Открыть карты.
     * По окончании раунда сравниваются очки всех игроков.
     * Вычисляется максимум очков, не превышающий 21.
     * Если таковой находится, присваивается переменной winner значение игроков с максимумом,
     * параллельно проверяется количество таких игроков.
     * Если находится один игрок с максимумом, возвращается ссылка на него.
     * Если находится минимум два игрока с одинаковым максимальным количеством очков,
     * осуществляется выход из метода со значением null.
     * Если все игроки имеют 0 или больше 21 очков, выясняем, кто из игроков ближе к 21.
     */
    private Player expose() {
        int max = 0;
        int min = 32;
        int repeated = 0;
        winner = null;

        for (Player player : table.getPlayers()) {
            if (player.getPoints() <= 21 && player.getPoints() > max) {
                max = player.getPoints();
            }
        }

        if (max > 0) {
            for (Player player : table.getPlayers()) {
                if (player.getPoints() == max) {
                    winner = player;
                    repeated++;
                }
                if (repeated > 1) {
                    return winner = null;
                }
            }
        } else {
            for (Player player : table.getPlayers()) {
                if (player.getPoints() < min && player.getPoints() > 21) {
                    min = player.getPoints();
                }
            }
            for (Player player : table.getPlayers()) {
                if (player.getPoints() == min) {
                    winner = player;
                    repeated++;
                }
                if (repeated > 1) {
                    return winner = null;
                }
            }
        }
        return winner;
    }

    private void redrawTable() {
        for (int i = 0; i < numberOfPlayers; i++) {
            playersPanes[i].setVisible(false);
        }
        playersPanes[activePlayerNumber].setVisible(true);
    }

    private void clearTable() {
        for (int i = 0; i < numberOfPlayers; i++) {
            playersPanes[i].removeAll();
        }
    }

    private void updateRoundInfo() {
        roundInfo.setText("<html><font color='444411' size='6'>Раунд " + (roundNumber + 1) +
                "<br><br>" + activePlayer + "</font></html>");
    }

    private void showResults(Player winner) {
        StringBuilder string = new StringBuilder("<html><font color='990000' size='6'>" +
                "Результаты " + (roundNumber + 1) + " раунда: </font><br><font color='0000ff' size='4'>");
        for (Player player : table.getPlayers()) {
            string.append(player).append(" - ").append(player.getPoints()).append(" очков.<br>");
        }
        if (winner != null) {
            roundInfo.setText(string.toString() + "<br><br> Победитель раунда: </font>" +
                    "<font color='990000' size='6'> " + winner + "</html>");
            nextRound.setText("Следующий раунд");
            winner.upNumberOfWins();
            roundNumber++;
        } else {
            roundInfo.setText(string.toString() + "<br><br>Ничья!</font></html>");
            nextRound.setText("Переиграть раунд");
        }
    }
}
