import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Percentage_Calculator extends JFrame implements ActionListener {

    private JLabel labelPart;
    private JLabel labelPercentage;
    private JLabel labelResult;
    private JTextField textFieldPart;
    private JTextField textFieldPercentage;
    private JButton buttonCalculatePercentage;
    private JButton buttonCalculateChange;
    private JButton buttonCalculateWhole;

    public Percentage_Calculator() {
        setTitle("Percentage Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        labelPart = new JLabel("Part:");
        panel.add(labelPart);
        textFieldPart = new JTextField();
        panel.add(textFieldPart);

        labelPercentage = new JLabel("Whole:");
        panel.add(labelPercentage);
        textFieldPercentage = new JTextField();
        panel.add(textFieldPercentage);

        buttonCalculatePercentage = new JButton("Calculate Percentage");
        buttonCalculatePercentage.addActionListener(this);
        panel.add(buttonCalculatePercentage);

        buttonCalculateChange = new JButton("Calculate Change");
        buttonCalculateChange.addActionListener(this);
        panel.add(buttonCalculateChange);

        buttonCalculateWhole = new JButton("Calculate Whole");
        buttonCalculateWhole.addActionListener(this);
        panel.add(buttonCalculateWhole);

        labelResult = new JLabel("");
        labelResult.setHorizontalAlignment(JLabel.CENTER);
        panel.add(labelResult);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonCalculatePercentage) {
            calculatePercentage();
        } else if (e.getSource() == buttonCalculateChange) {
            calculatePercentageChange();
        } else if (e.getSource() == buttonCalculateWhole) {
            calculateWhole();
        }
    }

    private void calculatePercentage() {
        try {
            double part = Double.parseDouble(textFieldPart.getText());
            double whole = Double.parseDouble(textFieldPercentage.getText());
            double percentage = (part / whole) * 100;
            labelResult.setText(String.format("Percentage: %.2f%%", percentage));
        } catch (NumberFormatException ex) {
            showError("Invalid input. Please enter numbers.");
        }
    }

    private void calculatePercentageChange() {
        try {
            double oldValue = Double.parseDouble(textFieldPart.getText());
            double newValue = Double.parseDouble(textFieldPercentage.getText());
            double change = ((newValue - oldValue) / oldValue) * 100;
            labelResult.setText(String.format("Percentage Change: %.2f%%", change));
        } catch (NumberFormatException ex) {
            showError("Invalid input. Please enter numbers.");
        }
    }

    private void calculateWhole() {
        try {
            double part = Double.parseDouble(textFieldPart.getText());
            double percentage = Double.parseDouble(textFieldPercentage.getText());
            double whole = (part / percentage) * 100;
            labelResult.setText(String.format("Whole: %.2f", whole));
        } catch (NumberFormatException ex) {
            showError("Invalid input. Please enter numbers.");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Percentage_Calculator());
    }
}

