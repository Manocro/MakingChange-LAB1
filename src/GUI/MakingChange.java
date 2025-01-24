package GUI;

import javax.swing.JFrame;

public class MakingChange {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Making Change Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        RegisterPanel registerPanel = new RegisterPanel();
        frame.add(registerPanel);

        frame.setVisible(true);
    }
}
