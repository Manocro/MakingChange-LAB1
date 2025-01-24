package GUI;
import Logic.Denomination;
import Logic.Purse;
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
        this.removeAll();
        revalidate();
        repaint();
    }
    @Override
    public Dimension getPreferredSize() {
        int height = 100;
        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {

            height += 150;
        }
        return new Dimension(600, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //STYLE
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("Purse Contents:", 10, 20);

        int y = 60;
        int x = 10;

        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denomination = entry.getKey();
            int count = entry.getValue();

            //PROCESS THE DISPLAY IMAGE BASED ON THE DENOMINATION RECORD.
            String imgPath = "Images/" + denomination.img();
            Icon img = new ImageIcon(imgPath);
            img.paintIcon(this, g, x, y);
            int imageSize = img.getIconHeight() + 20;

            //DRAW NAME AND COUNT
            g.drawString(entry.getKey().name() + ": " + count, x, y + imageSize);

            //File imgFile = new File(imgPath);
//            if (imgFile.exists() && imgFile.isFile()) {
//                // Load the image
//                ImageIcon icon = new ImageIcon(imgFile.getAbsolutePath());
//                Image img = icon.getImage();
//                if (img.getWidth(null) == -1 || img.getHeight(null) == -1) {
//                    // Image failed to load
//                    g.drawString("[Image Failed to Load]", x + 150, y);
//                    System.err.println("Failed to load image: " + imgPath);
//                } else {
//                    // Draw image scaled
//                    Image scaledImg = img.getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
//                    g.drawImage(scaledImg, x + 150, y - 30, null);
//                }
//            } else {
//                g.drawString("[Image Not Found]", x + 150, y);
//                System.err.println("Image not found: " + imgPath);
//            }


            y += imageSize + 40;
        }

        g.drawString("Total Value: $" + String.format("%.2f", purse.getValue()), x, y);
    }


}
