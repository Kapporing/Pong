import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pong implements ActionListener, KeyListener {
    int width = 1500;
    int height = 900;

    boolean w,s,up,down;

    static Pong pong;
    Paddle p1;
    Paddle p2;


    public int gameStatus = 0;

    Renderer renderer;

    public Pong(){
        Timer timer = new Timer(20, this);
        JFrame board = new JFrame("Pong");
        renderer = new Renderer();

        board.setSize(width + 20, height + 50);
        board.setLocationRelativeTo(null);
        board.setVisible(true);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.add(renderer);
        board.addKeyListener(this);

        start();

        timer.start();
    }

    public static void main(String[] args) {
        pong = new Pong();
    }

    void render(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,width, height);

        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(5));
        g.drawLine(width / 2, 0, width / 2, height);

        p1.render(g);
        p2.render(g);
    }

    void start() {
        p1 = new Paddle(this, 1);
        p2 = new Paddle(this, 2);
    }

    void update() {
        if(w) {
            p1.move(true);
        }
        if(s) {
            p1.move(false);
        }
        if(up) {
            p2.move(true);
        }
        if(down) {
            p2.move(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        renderer.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W){
            w = true;
        }
        if (key == KeyEvent.VK_S){
            s = true;
        }
        if (key == KeyEvent.VK_UP){
            up = true;
        }
        if (key == KeyEvent.VK_DOWN){
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W){
            w = false;
        }
        if (key == KeyEvent.VK_S){
            s = false;
        }
        if (key == KeyEvent.VK_UP){
            up = false;
        }
        if (key == KeyEvent.VK_DOWN){
            down = false;
        }
    }
}
