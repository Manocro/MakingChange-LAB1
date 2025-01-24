package GUI;

import Logic.Purse;
import Logic.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

        //CHANGE PANEL SECTION WITH SCROLLING FEATURE.
        changePanel = new PursePanel();
        JScrollPane scrollPane = new JScrollPane(changePanel);
        scrollPane.setPreferredSize(new Dimension(600, 250));
        this.add(scrollPane, BorderLayout.CENTER);
        //this.add(changePanel, BorderLayout.CENTER); //PREVIOUS VERSION, NO SCROLLING FEATURE
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //ACTION LISTENER WITH FUNCTION SO THAT IF ENTER KEY IS PRESSED IT WORKS TOO AS THE BUTTON.
        InputListener inputListener = new InputListener();
        calculateButton.addActionListener(new InputListener());
        input.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    inputListener.actionPerformed(new ActionEvent(input, ActionEvent.ACTION_PERFORMED, null));
                }
            }
        });
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
