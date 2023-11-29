package game;// Importa las clases necesarias del paquete javax.swing para la interfaz gráfica y java.util para las colecciones
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase principal que representa el juego de la serpiente
public class SnakeGame extends JFrame {
    private SnakeBoard snakeBoard;// Panel que contiene el juego de la serpiente
    private JButton restartButton;// Botón para reiniciar el juego
    private List<Player> rankings;// Lista de jugadores y sus puntuaciones
    private JButton rankingsButton;// Botón para ver los rankings
    private int score; // Puntuación actual del jugador

    // Constructor de la clase SnakeGame
    public SnakeGame() {
        setTitle("Snake Rush");// Establece el título de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setLayout(new BorderLayout()); // Utiliza un diseño de borde para organizar los componentes

        snakeBoard = new SnakeBoard(this);
        add(snakeBoard, BorderLayout.CENTER);// Agrega el panel al centro de la ventana

        JPanel buttonPanel = new JPanel(); // Panel para contener los botones

        restartButton = new JButton("Restart"); // Botón para reiniciar el juego
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Oculta la ventana actual
                SwingUtilities.invokeLater(() -> new SnakeGame()); // Crea una nueva instancia del juego
            }
        });
        buttonPanel.add(restartButton); // Agrega el botón al panel

        rankingsButton = new JButton("View Rankings"); // Botón para ver los rankings
        rankingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRankings(); // Muestra los rankings al hacer clic en el botón
            }
        });

        buttonPanel.add(rankingsButton); // Agrega el botón al panel

        add(buttonPanel, BorderLayout.SOUTH); // Agrega el panel de botones en la parte inferior de la ventana

        rankings = new ArrayList<>(); // Inicializa la lista de rankings

        pack(); // Ajusta automáticamente el tamaño de la ventana
        setLocationRelativeTo(null); // Coloca la ventana en el centro de la pantalla
        setVisible(true); // Hace visible la ventana

    }
    // Muestra la pantalla de juego terminado
    public void showGameOverScreen() {
        JOptionPane.showMessageDialog(null, "Game Over! Your score: " + snakeBoard.getScore());
    }

    // Muestra la ventana de rankings
    private void displayRankings() {
        // Crea un StringBuilder para construir el texto de los rankings
        StringBuilder rankingsText = new StringBuilder("Rankings:\n"); // Recorre la lista de rankings
        // y agrega la posición, nombre y puntuación de cada jugador al StringBuilder
        for (int i = 0; i <rankings.size(); i++) {
            rankingsText.append(i + 1).append(". ").append(rankings.get(i)).append("\n");
        }
        // Muestra un cuadro de diálogo informativo con los rankings
        JOptionPane.showMessageDialog(this, rankingsText.toString(), "Rankings", JOptionPane.INFORMATION_MESSAGE);
        // Componente padre (la instancia actual de SnakeGame)
        // Tipo de mensaje (informativo)
    }

}
