import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, modulusButton, clearButton;

    public Calculator() {
        // Create frame
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 490);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Color backgroundColor = new Color(233, 233, 233);

        // Create text fields
        firstNumberField = new JTextField();
        secondNumberField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        Dimension fieldSize = new Dimension(200, 30);
        firstNumberField.setPreferredSize(fieldSize);
        secondNumberField.setPreferredSize(fieldSize);
        resultField.setPreferredSize(fieldSize);

        // Set background color for text fields
        firstNumberField.setBackground(Color.WHITE);
        secondNumberField.setBackground(Color.WHITE);
        resultField.setBackground(Color.WHITE);

        // Create buttons
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        modulusButton = new JButton("%");
        clearButton = new JButton("Clear");

        // Set background color for buttons
        Color buttonBackgroundColor = new Color(224, 238, 255);
        addButton.setBackground(buttonBackgroundColor);
        subtractButton.setBackground(buttonBackgroundColor);
        multiplyButton.setBackground(buttonBackgroundColor);
        divideButton.setBackground(buttonBackgroundColor);
        modulusButton.setBackground(buttonBackgroundColor);
        clearButton.setBackground(buttonBackgroundColor);

        // Add action listeners
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        modulusButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Layout components
        gbc.insets = new Insets(5, 5, 5, 5);

        // First Number
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("First Number:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(firstNumberField, gbc);

        // Second Number
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("Second Number:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(secondNumberField, gbc);

        // Result
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(new JLabel("Result:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(resultField, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(modulusButton);
        buttonPanel.add(clearButton);

        // Set background color for button panel
        buttonPanel.setBackground(backgroundColor);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        add(buttonPanel, gbc);

        // Set background color for the frame
        getContentPane().setBackground(backgroundColor);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double num1, num2, result = 0.0;

        try {
            num1 = Double.parseDouble(firstNumberField.getText());
            num2 = Double.parseDouble(secondNumberField.getText());

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                result = num1 / num2;
            } else if (e.getSource() == modulusButton) {
                result = num1 % num2;
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}