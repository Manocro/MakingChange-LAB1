import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegisterPanel extends JPanel {
    private final Register register;
    private final JTextField input;
    private final PursePanel changePanel;


    public RegisterPanel() {
        this.register = new Register();
        this.setLayout(new BorderLayout());

        //INPUT PANEL SECTION
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel inputLabel = new JLabel("Enter amount:");
        input = new JTextField(10);
        JButton calculateButton = new JButton("Calculate Change");

        inputPanel.add(inputLabel);
        inputPanel.add(input);
        inputPanel.add(calculateButton);

        this.add(inputPanel, BorderLayout.NORTH);

        //CHANGE PANEL SECTION
        changePanel = new PursePanel();
        this.add(changePanel, BorderLayout.CENTER);

        //ACTION LISTENER
        calculateButton.addActionListener(new InputListener());
    }

    //FOR INPUT CHANGES
    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(input.getText());
                Purse changePurse = register.makeChange(amount);
                changePanel.setPurse(changePurse);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException | IllegalStateException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
