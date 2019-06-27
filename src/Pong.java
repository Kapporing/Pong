import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong implements ActionListener, KeyListener {
    int width = 700;
    int height = 700;

    static Pong pong;
    public int gameStatus = 0;

    Renderer renderer;

    public Pong(){
        Timer timer = new Timer(20, this);
        JFrame board = new JFrame("Pong");
        renderer = new Renderer();
        board.setSize(width, height);
        board.setVisible(true);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.add(renderer);

        timer.start();
    }

    public static void main(String[] args) {
        pong = new Pong();
    }

    void render(Graphics g) {
    }

    void update() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameStatus == 2) {
            update();
        }
        renderer.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W){

        }
        if (key == KeyEvent.VK_S){

        }
        if (key == KeyEvent.VK_UP){

        }
        if (key == KeyEvent.VK_DOWN){

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
