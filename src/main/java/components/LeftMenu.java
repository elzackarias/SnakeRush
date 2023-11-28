package components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LeftMenu extends JPanel {
    private BufferedImage myPicture;
    public LeftMenu(){
        try {
            myPicture = ImageIO.read(new File("src/main/java/sources/leftLogo3.png"));
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        setOpaque(false);
    }
    protected void paintComponent(Graphics graph){
        Graphics2D g2 = (Graphics2D) graph;
        g2.setColor(getBackground());

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0,0,getWidth(),getHeight(),20,20);
        g2.fillRect(getWidth()-25,0,getWidth(),getHeight());
        g2.drawImage(myPicture, 0, 0, this);
        super.paintComponent(graph);
    }
}
