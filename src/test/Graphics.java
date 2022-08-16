package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics extends JPanel implements ActionListener {

    private Timer t = new Timer(100, this);
    public String state;

    private Snake s;
    private Food f;
    private Game game;

    public Graphics(Game g) {
        t.start();
        state = "START";

        game = g;
        s = g.getPlayer();
        f = g.getFood();

        // add a KeyListener to the game
        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setFont(new Font("Arial", 1, 19));
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, game.widht * game.dimension + 5, game.height * game.dimension + 5);

        if (state == "START") {
            g2d.setColor(Color.WHITE);
            g2d.drawString("Press any key", game.widht / 2 * game.dimension - 40,
                    game.height / 2 * game.dimension - 20);
        } else if (state == "RUNNING") {

            g2d.setColor(Color.red);
            g2d.fillRect(f.getX() * game.dimension, f.getY() * game.dimension, game.dimension, game.dimension);

            g2d.setColor(Color.cyan);
            for (Rectangle r : s.getBody()) {
                g2d.fill(r);
            }
        } else {
            g2d.setColor(Color.WHITE);
            g2d.drawString("Your Score: " + (s.getBody().size() - 3), game.widht / 2 * game.dimension - 40,
                    game.height / 2 * game.dimension - 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        game.update();
    }

}
