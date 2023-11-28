package components;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*;
/**
 *
 * @author jzacarias
 */
public class PanelUI extends JPanel {
    public PanelUI() {
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics graph){
        Graphics2D g2 = (Graphics2D) graph;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0,0,getWidth(),getHeight(),20,20);
        super.paintComponent(graph);
    }
}
