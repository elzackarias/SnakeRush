import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase GameOverWindow de la ventana de fin del juego
class GameOverWindow extends JFrame {
    private JLabel scoreLabel; // muestra el puntaje
    private SnakeGame snakeGame; // Referencia al juego de la serpiente


    // Constructor de la clase que toma una instancia de SnakeGame y el puntaje como parámetros
    public GameOverWindow(SnakeGame snakeGame, int score) {
        this.snakeGame = snakeGame;

        setTitle("Game Over"); // título de la ventana
        setSize(400, 200); // tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierre de la ventana


        // Crear un panel para agregar componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Centra la etiqueta en el eje X


        // Añadir una etiqueta de "Game Over" al panel
        JLabel label = new JLabel("Game Over");
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra la etiqueta en el eje X
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(4, 5))); //  SE crea un area espaciado

        // Añadir una etiqueta para mostrar el puntaje
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra la etiqueta en el eje X
        panel.add(scoreLabel);

        // Añadir un botón para reiniciar el juego
        JButton restartButton = new JButton("Restart");
        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el botón en el eje X
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llama al método para reiniciar el juego en SnakeGame
                snakeGame.restartGame();
            }
        });
        panel.add(restartButton);

        // Añadir un botón para ver los rankings
        JButton rankingsButton = new JButton("View Rankings");
        rankingsButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el botón en el eje X
        rankingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llama al método para ver los rankings en SnakeGame
                snakeGame.displayRankings();
            }
        });
        panel.add(rankingsButton);

        // Añadir el panel a la ventana
        add(panel);
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
        // Hacer visible la ventana
        setVisible(true);
    }
}
