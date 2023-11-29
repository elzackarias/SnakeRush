package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SnakeBoard extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private int snakeSize;
    private int[] x, y;
    private boolean gameOver;
    private SnakeGame snakeGame;
    private int foodX, foodY;
    private int score;
    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
    private Direction direction = Direction.RIGHT;

    public SnakeBoard(SnakeGame snakeGame) {
        this.snakeGame = snakeGame;
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        initGame();
    }

    private void initGame() {
        snakeSize = 3;
        x = new int[400];
        y = new int[400];
        gameOver = false;
        score = 0;

        for (int i = 0; i < snakeSize; i++) {
            x[i] = 200 - i * 10;
            y[i] = 200;
        }

        spawnFood();

        timer = new Timer(150, this);
        timer.start();
    }
    public int getScore() {
        return score;
    }
    private void spawnFood() {
        int randomX = (int) (Math.random() * 40) * 10;
        int randomY = (int) (Math.random() * 40) * 10;

        foodX = randomX;
        foodY = randomY;
    }

    public void restartGame() {
        initGame();
        direction = Direction.RIGHT;
        repaint();
    }

    private void move() {
        for (int i = snakeSize; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case UP:
                y[0] -= 10;
                break;
            case DOWN:
                y[0] += 10;
                break;
            case LEFT:
                x[0] -= 10;
                break;
            case RIGHT:
                x[0] += 10;
                break;
        }
    }

    private void checkCollision() {
        if (x[0] < 0 || x[0] >= 400 || y[0] < 0 || y[0] >= 400) {
            gameOver();
        }

        for (int i = snakeSize; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                gameOver();
            }
        }
    }


    private void checkFood() {
        if (x[0] == foodX && y[0] == foodY) {
            snakeSize++;
            score += 10;
            spawnFood();
        }
    }

    private void gameOver() {
        timer.stop();
        snakeGame.showGameOverScreen();
        gameOver = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            move();
            checkCollision();
            checkFood();
            repaint();
        }
    }

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
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction != Direction.UP) {
                    direction = Direction.DOWN;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (direction != Direction.RIGHT) {
                    direction = Direction.LEFT;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != Direction.LEFT) {
                    direction = Direction.RIGHT;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
}

