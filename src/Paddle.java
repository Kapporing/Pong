import java.awt.*;

public class Paddle {
    public int paddleNumber;

    public int x;
    public int y;
    public int width = 50;
    public int height = 300;
    public int score;

    public Paddle(Pong p, int paddleNumber) {
        this.score = 0;

        this.paddleNumber = paddleNumber;

        if (paddleNumber == 1) {
            this.x = 0;
        }
        if (paddleNumber == 2) {
            this.x = p.width - width;
        }
        this.y = p.height / 2 - height / 2;
    }



    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public void move(boolean up) {
        int speed = 20;
        if (up) {
            if (y - speed > 0) {
                y -= speed;
            } else {
                y = 0;
            }
        } else {
            if (y + height < Pong.pong.height) {
                y += speed;
            }
        }
    }
}
