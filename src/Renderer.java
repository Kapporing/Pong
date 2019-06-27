import javax.swing.JPanel;
import java.awt.Graphics;

public class Renderer extends JPanel {
    public static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Pong.pong.render(g);
    }
}
