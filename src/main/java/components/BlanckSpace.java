package components;

import javax.swing.*;
import java.awt.*;

public class BlanckSpace extends JLabel {
    private int ancho;
    private int alto;

    public BlanckSpace(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        // Establecer las dimensiones del panel
        this.setPreferredSize(new Dimension(ancho, alto));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (getWidth() - ancho) / 2;
        int y = (getHeight() - alto) / 2;

        // Dibujar el rectángulo con relleno en el panel
        g.setColor(new Color(245, 246, 250)); // Cambiar el color del fondo según sea necesario
        g.fillRect(x, y, ancho, alto);
    }
}
