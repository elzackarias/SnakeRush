// Importa las clases necesarias del paquete javax.swing para la interfaz gráfica y java.util para las colecciones
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Clase principal que representa el juego de la serpiente
public class SnakeGame extends JFrame {
    private SnakeBoard snakeBoard; // Panel que contiene el juego de la serpiente
    private List<Player> rankings; //Lista de jugadores y sus puntuaciones


    private GameOverWindow gameOverWindow; // Ventana de Game Over
    public SnakeGame() {
        setTitle("Snake Rush"); // Establece el título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la ventana
        setLayout(new BorderLayout()); // Utiliza un diseño de borde para organizar los componentes

        snakeBoard = new SnakeBoard(this);
        add(snakeBoard, BorderLayout.CENTER); // Agrega el panel en el centro de la ventana

        rankings = new ArrayList<>(); // Inicializa la lista de rankings
        pack(); // Ajusta automáticamente el tamaño de la ventana
        setLocationRelativeTo(null); // Coloca la ventana en el centro de la pantalla
        setVisible(true); //Hace visible la ventana
    }

    // Muestra la pantalla de juego terminado
    public void showGameOverScreen() {
        gameOverWindow = new GameOverWindow(this, snakeBoard.getScore());
    }

    public void restartGame() { //Reinicio del juego
        // Ocultar la ventana de Game Over
        gameOverWindow.setVisible(false);
        snakeBoard.restartGame();
    }

    // Muestra la ventana de rankings
    void displayRankings() {
        // Crea un StringBuilder para construir el texto de los rankings
        StringBuilder rankingsText = new StringBuilder("Rankings:\n");
        // Recorre la lista de rankings
        // y agrega la posición, nombre y puntuación de cada jugador al StringBuilder
        for (int i = 0; i < rankings.size(); i++) {
            rankingsText.append(i + 1).append(". ").append(rankings.get(i)).append("\n");
        }
        // Muestra un cuadro de diálogo informativo con los rankings
        JOptionPane.showMessageDialog(this, rankingsText.toString(), "Rankings", JOptionPane.INFORMATION_MESSAGE);
        // Componente padre (la instancia actual de SnakeGame)
        // Tipo de mensaje (informativo)
    }
}