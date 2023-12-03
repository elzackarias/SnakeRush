import javax.swing.*;
import java.awt.*;

public class VistaRankings extends JFrame {

    public VistaRankings() {
        JLabel ranks = new JLabel("Rankings");
        add(ranks);
        add(Box.createRigidArea(new Dimension(490, 10)));
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(VistaRankings.EXIT_ON_CLOSE);
    }

    public void crearJLabel(String contenido) {
        add(Box.createRigidArea(new Dimension(490, 3)));
        JLabel nuevo = new JLabel(contenido);
        add(nuevo);
    }
}