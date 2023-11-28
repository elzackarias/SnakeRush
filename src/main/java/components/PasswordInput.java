package components;
import utils.RoundBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PasswordInput extends JPasswordField {
    private String placeholder;
    private final int borderRadius = 15; // Radio de los bordes
    public PasswordInput(String placeholder){
        this.placeholder = placeholder;
        setOpaque(false);
        setText(placeholder);
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setFont(new Font("SFProDisplay-Regular", Font.PLAIN, 12));
        setBorder(new EmptyBorder(1, 2, 1, 2));
        setBorder(new RoundBorder(Color.WHITE, borderRadius)); // Establecer el borde redondeado
        addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                if (getText().equals(placeholder)){
                    setText("");
                    setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e){
                if (getText().isEmpty()){
                    setText(placeholder);
                    setForeground(Color.GRAY);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Dibuja el fondo redondeado
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, borderRadius, borderRadius);
        // Llama al método de la superclase para pintar el resto del componente
        super.paintComponent(g);
    }

    @Override
    public Insets getInsets() {
        // Agrega un espacio alrededor del texto dentro del campo de texto
        return new Insets(1, borderRadius, 1, borderRadius);
    }

}