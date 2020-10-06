import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class firstScreen extends JPanel {
    public static class ImageLoader {

        public static BufferedImage loadImage(String path) {
            try {
                return ImageIO.read(ImageLoader.class.getResource(path));
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.exit(1);
            }
            return null;
        }
    }

    public BufferedImage background1;
    public BufferedImage background2= ImageLoader.loadImage("image/snakeEw.jpg");
    public void setBackground(BufferedImage background2) {
        this.background1 = background2;
    }

    public void paint(Graphics g)
    {
        // Draws the img to the BackgroundPanel.
        setBackground(background2);
        g.drawImage(background1, 0, 0, null);
    }

    public void main(String[] args) {
        Graphics g = null;
        paint(g);
    }
}