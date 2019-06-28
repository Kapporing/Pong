import java.awt.*;
import java.util.Random;

public class Ball {
    Random random;

    int x;
    int y;
    int width = 25;
    int height = 25;

    int motionX;
    int motionY;

    public Ball(Pong pong) {
        this.random = new Random();
        this.x = pong.width / 2 - this.width / 2;
        this.y = pong.height / 2 - this.height / 2;
        this.motionX = random.nextInt(3) - 1  + random.nextInt(50);
        this.motionY = random.nextInt(3) - 1  + random.nextInt(50);
    }
    public void update(Paddle p1, Paddle p2) {
        this.x += this.motionX;

        if (collision(p1) == 1) {
            this.motionX = random.nextInt(3) - 1  + random.nextInt(50);
            this.motionY = -2 + random.nextInt(50);
        }
        if (collision(p2) == 1) {
            this.motionX = -(random.nextInt(3) - 1  + random.nextInt(50));
            this.motionY = -2 + random.nextInt(50);
        }
        if (collision(p1) == 2) {
            p1.score++;
        }
        if (collision(p2) == 2) {
            p2.score++;
        }

    }

    public int collision(Paddle paddle) {
        if (paddle.x + paddle.width > this.x && this.x + width > paddle.x && paddle.y < this.y + height && paddle.y + paddle.height > this.y) {
                return 1; // Hit Paddle

        } else if ((paddle.x > this.x && paddle.paddleNumber == 1) || (paddle.x < this.x - this.width && paddle.paddleNumber == 2)){
            return 2;
        }
        return 0; // No Hit
    }

    public void render(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }
}
