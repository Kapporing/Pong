import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

class Ball {
    private Random random;
    private Pong board;

    private int x;
    private int y;
    private int width = 25;
    private int height = 25;

    private int motionX;
    private int motionY;

    Ball(Pong pong) {
        this.board = pong;
        this.random = new Random();
        this.x = pong.width / 2 - this.width / 2;
        this.y = pong.height / 2 - this.height / 2;
        this.motionX = random.nextInt(3) - 1  + random.nextInt(10);
        this.motionY = random.nextInt(3) - 1  + random.nextInt(10);
    }
    void update(Paddle p1, Paddle p2) {
        this.x += this.motionX;
        this.y += this.motionY;

        if (this.y + height > board.height || this.y < 0) {
            if (this.motionY < 0) {
                this.y = 0;
                this.motionY = random.nextInt(10) + 1;
            } else {
                this.motionY = -random.nextInt(10) - 1;
                this.y = board.height - height;
            }
        }

        if (collision(p1) == 1)
        {
            this.motionX = 10;
            this.motionY = (-2 + random.nextInt(4)) * 5;

            if (motionY == 0)
            {
                motionY = 5;
            }

        }
        else if (collision(p2) == 1)
        {
            this.motionX = -10;
            this.motionY = (-2 + random.nextInt(4)) * 5;

            if (motionY == 0)
            {
                motionY = 5;
            }

        }

        if (collision(p1) == 2)
        {
            p2.score++;
        }
        else if (collision(p2) == 2)
        {
            p1.score++;
        }
    }

    private int collision(Paddle paddle) {
        if (paddle.x + paddle.width > this.x && this.x + width > paddle.x && paddle.y < this.y + height && paddle.y + paddle.height > this.y) {
                return 1; // Hit Paddle

        } else if ((paddle.x > this.x && paddle.paddleNumber == 1) || (paddle.x < this.x - this.width && paddle.paddleNumber == 2)){
            return 2;
        }
        return 0; // No Hit
    }

    void render(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }
}
