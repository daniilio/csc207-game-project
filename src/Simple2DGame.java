import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Simple2DGame extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private int x = 50, y = 50, velX = 0, velY = 0;

    public Simple2DGame() {
        timer = new Timer(10, this);  // Call actionPerformed every 10 milliseconds
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);  // Draw a blue square (player)
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += velX;  // Update the player's x position
        y += velY;  // Update the player's y position
        repaint();  // Repaint the screen
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            velX = -2;  // Move left
        }
        if (key == KeyEvent.VK_RIGHT) {
            velX = 2;   // Move right
        }
        if (key == KeyEvent.VK_UP) {
            velY = -2;  // Move up
        }
        if (key == KeyEvent.VK_DOWN) {
            velY = 2;   // Move down
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            velX = 0;
        }
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            velY = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple 2D Game");
        Simple2DGame game = new Simple2DGame();
        frame.add(game);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}