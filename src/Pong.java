import javax.swing.*;
import java.awt.*;

public class Pong {
    int width = 700;
    int height = 700;

    static Pong pong;

    Renderer renderer;

    public Pong(){
        JFrame board = new JFrame("Pong");
        renderer = new Renderer();
        board.setSize(width, height);
        board.setVisible(true);
        board.add(renderer);
    }

    public static void main(String[] args) {

    }

    void render(Graphics g) {

    }
}
