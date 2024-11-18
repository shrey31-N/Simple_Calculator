package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfiled;
    JButton[] numberButton = new JButton[10];
    JButton[] functionalButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Times new roman", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfiled = new JTextField();
        textfiled.setBounds(50, 25, 300, 50);
        textfiled.setFont(myFont);
        textfiled.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionalButton[0] = addButton;
        functionalButton[1] = subButton;
        functionalButton[2] = mulButton;
        functionalButton[3] = divButton;
        functionalButton[4] = decButton;
        functionalButton[5] = equButton;
        functionalButton[6] = delButton;
        functionalButton[7] = clrButton;
        functionalButton[8] = negButton;

        for (int i = 0; i < functionalButton.length; i++) {
            functionalButton[i].addActionListener(this);
            functionalButton[i].setFont(myFont);
            functionalButton[i].setFocusable(false);
        }

        for (int i = 0; i < numberButton.length; i++) {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(155, 430, 100, 50);
        clrButton.setBounds(260, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(textfiled);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numberButton.length; i++) {
            if (e.getSource() == numberButton[i]) {
                textfiled.setText(textfiled.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfiled.setText(textfiled.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfiled.getText());
            operator = '+';
            textfiled.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfiled.getText());
            operator = '-';
            textfiled.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfiled.getText());
            operator = '*';
            textfiled.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfiled.getText());
            operator = '/';
            textfiled.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfiled.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfiled.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textfiled.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textfiled.getText();
            textfiled.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfiled.setText(textfiled.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfiled.getText());
            temp *= -1;
            textfiled.setText(String.valueOf(temp));
        }
    }
}
