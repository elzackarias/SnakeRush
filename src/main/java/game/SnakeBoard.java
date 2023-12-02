import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Clase del panel de juego de la serpiente
public class SnakeBoard extends JPanel implements ActionListener, KeyListener {
    private Timer timer; // Temporizador para controlar la velocidad
    private int snakeSize; // Tamaño de la serpiente
    private int[] x, y; // Arreglos para almacenar las coordenadas de la serpiente
    private boolean gameOver; // Indica si el juego ha terminado
    private SnakeGame snakeGame; // Referencia al objeto principal del juego
    private int foodX, foodY; // Coordenadas de la manzana
    private int score; // Puntuación
    private enum Direction { //Direcciones del teclado
        UP, DOWN, LEFT, RIGHT
    }
    private Direction direction = Direction.RIGHT;
    // Dirección de la serpiente (inicia hacia la derecha)

    //Constructor que recibe una instancia de SnakeGame
    public SnakeBoard(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        // Establece la referencia al objeto principal del juego
        setPreferredSize(new Dimension(500, 500)); // Establece el tamaño del panel
        setBackground(Color.BLACK); // Establece el color del fondo
        setFocusable(true); // Permite que el panel obtenga el enfoque para recibir las ordenes de teclado
        addKeyListener(this); // Agrega un escuchador de teclado al panel (this se refiere a la propia instancia de SnakeBoard)
        this.snakeGame = snakeGame;

        //Inicia el juego
        initGame();
    }

    //Inicializa el juego
    private void initGame() {
        snakeSize = 3; //tamaño inicial de la serpiente
        x = new int[400]; //arreglo de coordenadas x de la serpiente
        y = new int[400]; //arreglo de coordenadas y de la serpiente
        gameOver = false; // Establece el estado del juego como no terminado
        score = 0; //Puntuacion inicial del juego

        //Inicializa la posición inicial de la serpiente
        for (int i = 0; i < snakeSize; i++) {
            x[i] = 200 - i * 20;
            // Genera la posición inicial de la comida        y[i] = 200;
        }

        //Genera la posición inicial de la manzana
        spawnFood();

        //temporizador para mover la serpiente automáticamente
        timer = new Timer(150, this);
        timer.start();
    }

    //Obtiene el puntaje del juego
    public int getScore() {
        return score;
    }

    //Genera una nueva posición para la manzana
    private void spawnFood() {
        int randomX = (int) (Math.random() * 40) * 10;
        // Genera una posición x  aleatoria (multiplo de 10) en un rango de 0 a 39
        int randomY = (int) (Math.random() * 40) * 10;
        // Genera una posición y  aleatoria (multiplo de 10) en un rango de 0 a 39
        foodX = randomX; // Establece la posición x de la manzana con valor aleatorio generado
        foodY = randomY; // Establece la posición y de la manzana con valor aleatorio generado
    }

    // Reinicia el juego
    public void restartGame() {
        initGame(); // Inicia el juego
        direction = Direction.RIGHT; //Restablce la direccion de la serpeinte a la derecha
        repaint(); //Vuelve a dibujar
    }

    // Mueve la serpiente
    private void move() {
        // Mueve el cuerpo de la serpiente
        for (int i = snakeSize; i > 0; i--) {
            x[i] = x[i - 1];
            // La posición X del la serpeinte en un inicio toma la posición X de la serpiente anterior
            y[i] = y[i - 1];
            // La posición Y del la serpeinte en un inicio toma la posición X de la serpiente anterior
        }
        // Mueve la cabeza de la serpiente en la dirección dada por el teclao
        switch (direction) {
            case UP:
                y[0] -= 10; // Decrementa la coordenada Y para mover hacia arriba
                break;
            case DOWN:
                y[0] += 10; // Incrementa la coordenada Y para mover hacia abajo
                break;
            case LEFT:
                x[0] -= 10; // Decrementa la coordenada X para mover hacia la izquierda
                break;
            case RIGHT:
                x[0] += 10; // Incrementa la coordenada X para mover hacia la derecha
                break;
        }
    }

    // Verifica las colisiones con las paredes y si la serpiente choca con ella misma
    private void checkCollision() {
        if (x[0] < 0 || x[0] >= getWidth() || y[0] < 0 || y[0] >= getHeight()) {
            // Fin del juego si colisiona con las paredes
            gameOver();
        }

        for (int i = snakeSize; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                // Fin del juego si colisiona consigo misma
                gameOver();
            }
        }

    }

    // Verifica si la serpiente ha comido la manzana
    private void checkFood() {
        if (x[0] == foodX && y[0] == foodY) {
            // Aumenta el tamaño de la serpiente
            // genera una nueva posición para la manzana
            snakeSize++;
            score += 10;
            spawnFood();
        }
        // Verifica que la manzana no aparezca en el cuerpo de la serpiente
        int a = 1;
        do {
            for (int i=0; i<snakeSize; i++) {
                if (x[i] == foodX && y[i] == foodY) {
                    a = 1;
                    spawnFood();
                }else {
                    a = 0;
                }
            }
        }while(a==1);
    }

    // Acciones en caso de que se termina el juego
    private void gameOver() {
        // Detiene el temporizador
        timer.stop();
        snakeGame.showGameOverScreen(); // muestra la pantalla de fin de juego
        gameOver = true;
    }

    // Método que se ejecuta en cada tic del temporizador
    @Override
    public void actionPerformed(ActionEvent e) {
        // Realiza acciones solo si el juego no ha terminado
        if (!gameOver) {
            move();
            checkCollision();
            checkFood();
            repaint();
        }
    }

    // Método para pintar y cambiar el tamaño a la manzana, la serpiente y el score
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(foodX, foodY, 10, 10);

        g.setColor(Color.GREEN);
        for (int i = 0; i < snakeSize; i++) {
            g.fillRect(x[i], y[i], 10, 10);
        }

        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP:
                if (direction != Direction.DOWN) {
                    direction = Direction.UP;
                    // Cambia la dirección a arriba si no está yendo hacia abajo
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction != Direction.UP) {
                    direction = Direction.DOWN;
                    // Cambia la dirección a abajo si no está yendo hacia arriba
                }
                break;
            case KeyEvent.VK_LEFT:
                if (direction != Direction.RIGHT) {
                    direction = Direction.LEFT;
                    // Cambia la dirección a izquierda si no está yendo hacia la derecha
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != Direction.LEFT) {
                    direction = Direction.RIGHT;
                    // Cambia la dirección a derecha si no está yendo hacia la izquierda
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //llama cuando una tecla que ha sido presionada previamente es liberada.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // lama cuando una tecla es pulsada y luego liberada, y se utiliza para procesar eventos de teclas que generan caracteres.
    }
}

