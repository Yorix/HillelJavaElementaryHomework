package task8;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {


    Window() {
        this("Days in a month");
    }

    Window(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocation(400, 300);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("<html><i>Enter the month and year as MM.YYYY: </html></i>");
        JTextField textField = new JTextField(6);
        JButton button = new JButton("Enter");


        Color myColor = new Color(0xCC9955);
        panel.setBackground(Color.BLACK);
        label.setForeground(myColor);
        textField.setBackground(new Color(44, 44, 44));
        textField.setForeground(Color.LIGHT_GRAY);
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(myColor);
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        setContentPane(panel);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel answer = new JLabel();
                answer.setForeground(myColor);
                if (textField.getText().matches("[0-9]{1,2}[.][0-9]{1,4}")) {
                    if (textField.getText().charAt(1) == '.') {
                        textField.setText("0" + textField.getText());
                    }
                    try {
                        answer.setText(
                                new Days().daysAtMonth(
                                        Integer.parseInt(textField.getText(0, 2)),
                                        Integer.parseInt(textField.getText().substring(3))
                                )
                        );
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    answer.setText("Incorrect month or year.");
                }
                panel.add(answer);
                panel.updateUI();
            }
        });
    }
}
