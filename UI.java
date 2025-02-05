package org.example;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {

    JTextField textField;
    private JTextField iTextField;
    private int y = 100;
    private MyTelegramBot myTelegramBot;

    UI(){
        setBounds(0, 0, 1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        iTextField = new JTextField();
        iTextField.setBounds(100, 50, 250, 30);
        iTextField.setBackground(Color.BLACK);
        iTextField.setForeground(Color.GREEN);
        add(iTextField);

        JButton button = new JButton("SEND___");
        button.setBounds(450, 100, 150, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.GREEN);
        button.addActionListener(e -> {
            myTelegramBot.sendTo(iTextField.getText().trim());
        });
        add(button);

        setVisible(true);
    }

    public void setTextField(String text) {
        textField = new JTextField(text);
        textField.setBounds(100, y, 250, 30);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.GREEN);
        textField.setOpaque(true);
        textField.setEditable(false);
        add(textField);
        repaint();

        y += 40;
    }

    public void setBot(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
    }
}
