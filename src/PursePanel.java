import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse;

    public PursePanel() {
        this.purse = new Purse();
        this.setPreferredSize(new Dimension(600, 300));
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("Purse Contents:", 10, 20);

        int y = 40;
        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            g.drawString(entry.getKey().name() + ": " + entry.getValue(), 10, y);
            y += 20;
        }

        g.drawString("Total Value: $" + String.format("%.2f", purse.getValue()), 10, y + 20);
    }
}
