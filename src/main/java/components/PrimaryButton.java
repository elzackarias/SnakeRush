package components;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PrimaryButton extends JButton {
public PrimaryButton(String text) {
    setText(text);
    setCursor(new Cursor(Cursor.HAND_CURSOR));
    customizeButton();
}
    private void customizeButton() {
        // Modificar propiedades del botón
        setForeground(Color.WHITE);
        setBackground(new Color(59, 89, 182));
        setFont(new Font("SFProDisplay-Bold", Font.PLAIN, 17));
        setFocusPainted(false);
        setBorderPainted(false);
        setPreferredSize(new Dimension(120, 48));
        setBorder(new EmptyBorder(1, 2, 12, 2));
        // Aplicar bordes redondeados
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(new Color(99, 131, 250).darker());
        } else if (getModel().isRollover()) {
            g.setColor(new Color(20, 21, 23));
        } else {
            g.setColor(new Color(99, 131, 250));
        }
        // Dibujar el botón con bordes redondeados
        g.fillRoundRect(0, 0, getWidth(), getHeight()-10, 15, 15);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No pintar borde
    }
}
