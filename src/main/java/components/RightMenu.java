package components;

import javax.swing.*;
import java.awt.*;

public class RightMenu extends JPanel {
    public RightMenu(){
        setOpaque(false);
    }
    protected void paintComponent(Graphics graph){
        Graphics2D g2 = (Graphics2D) graph;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0,0,getWidth(),getHeight(),20,20);
        g2.fillRect(0,0,25,getHeight());
        super.paintComponent(graph);
    }
}
