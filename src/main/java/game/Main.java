import javax.swing.*;

//Clase del Main
public class Main {
    public static void main(String[] args) {
        // Aseguramos la creación de la interfaz con SwingUtilities.invokeLate
        SwingUtilities.invokeLater(() -> new SnakeGame());
    }
}
