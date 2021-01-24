package lk.kavishmanjitha.view;

import lk.kavishmanjitha.model.Entity;
import lk.kavishmanjitha.util.Constant;

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    private Graphics2D graphics2D;
    private BufferedImage bufferedImage;
    private Thread thread;

    private Entity head;
    private Entity apple;
    private ArrayList<Entity> snake;

    private int score;
    private boolean isRunning;
    private boolean isgGameOver;

    private int dx;
    private int dy;

    public static boolean upDirection;
    public static boolean downDirection;
    public static boolean rightDirection;
    public static boolean leftDirection;

    public GamePanel() {
        addKeyListener(new DirectionKeyAdapter());
    }

    @Override
    public void run() {
        if (isRunning) {
            return;
        }
        gameInitialize();
        while (isRunning) {
            drawEntities();
            entitiesRender();
            try {
                Thread.sleep(Constant.GAME_SPEED);
            } catch (InterruptedException e) {
                MainFrame.statusLabel.setText("Something went wrong !!!");
                MainFrame.statusLabel.setForeground(Color.RED);
            }
        }
    }

    public void addNotify() {
        super.addNotify();
        thread = new Thread(this);
        thread.start();
    }

    private void gameInitialize() {
        bufferedImage = new BufferedImage(Constant.GAME_PANEL_WIDTH, Constant.GAME_PANEL_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        graphics2D = bufferedImage.createGraphics();

        isRunning = true;
        score = 0;
        isgGameOver = false;
        dx = 0;
        dy = 0;

        snake = new ArrayList<Entity>();
        head = new Entity(Constant.GAME_SIZE);
        head.setPostion(Constant.GAME_PANEL_WIDTH / 2, Constant.GAME_PANEL_HEIGHT / 2);
        snake.add(head);

        for (int i = 1; i < 3; i++) {
            Entity e = new Entity(Constant.GAME_SIZE);
            e.setPostion(head.getX() + (i * Constant.GAME_SIZE), head.getY());
            snake.add(e);
        }
        apple = new Entity(Constant.GAME_SIZE);
        setAppleLocation();
    }

    public void paint(Graphics mycanvas) {
        mycanvas.setColor(Color.blue);
        mycanvas.fillRect(0, 0, Constant.GAME_PANEL_WIDTH - 1, Constant.GAME_PANEL_HEIGHT - 1);
        mycanvas.setColor(Color.white);
        mycanvas.fillRect(20, 20, Constant.GAME_PANEL_WIDTH - 41, Constant.GAME_PANEL_HEIGHT - 41);
    }

    public void setAppleLocation() {
        int x = (int) (Math.random() * (Constant.GAME_PANEL_WIDTH - Constant.GAME_SIZE));
        int y = (int) (Math.random() * (Constant.GAME_PANEL_HEIGHT - Constant.GAME_SIZE));
        x = x - (x % Constant.GAME_SIZE);
        y = y - (y % Constant.GAME_SIZE);
        apple.setPostion(x, y);
    }

    private void entitiesRender() {
        render(graphics2D);
        Graphics g = getGraphics();
        g.drawImage(bufferedImage, 0, 0, null);
        g.dispose();
    }

    private void drawEntities() {
        if (upDirection && dy == 0) {
            dy = -Constant.GAME_SIZE;
            dx = 0;
        }
        if (downDirection && dy == 0) {
            dy = Constant.GAME_SIZE;
            dx = 0;
        }
        if (leftDirection && dx == 0) {
            dy = 0;
            dx = -Constant.GAME_SIZE;
        }
        if (rightDirection && dx == 0 && dy != 0) {
            dy = 0;
            dx = Constant.GAME_SIZE;
        }
        if (dx != 0 || dy != 0) {
            for (int i = snake.size() - 1; i > 0; i--) {
                snake.get(i).setPostion(snake.get(i - 1).getX(), snake.get(i - 1).getY());
            }
            head.move(dx, dy);
        }

        for (Entity e : snake) {
            if (e.isCollision(head)) {
                isgGameOver = true;
                break;
            }
        }

        if (apple.isCollision(head)) {
            score++;
            setAppleLocation();
            Entity e = new Entity(Constant.GAME_SIZE);
            e.setPostion(-100, -100);
            snake.add(e);
        }

        if (head.getX() < 0) {
            head.setX(Constant.GAME_PANEL_WIDTH);
        }
        if (head.getY() < 0) {
            head.setY(Constant.GAME_PANEL_HEIGHT);
        }
        if (head.getX() > Constant.GAME_PANEL_WIDTH) {
            head.setX(0);
        }
        if (head.getY() > Constant.GAME_PANEL_HEIGHT) {
            head.setY(0);
        }
    }

    public void render(Graphics2D g2d) {
        g2d.clearRect(0, 0, Constant.GAME_PANEL_WIDTH, Constant.GAME_PANEL_HEIGHT);
        g2d.setColor(Color.BLUE);
        for (Entity e : snake) {
            e.render(g2d);
        }
        g2d.setColor(Color.RED);
        apple.render(g2d);

        if (isgGameOver) {
            MainFrame.statusLabel.setText("GAMEOVER !!!");
            MainFrame.statusLabel.setForeground(Color.RED);
        }

        MainFrame.statusLabel.setText("SCORE: " + score);
        MainFrame.statusLabel.setForeground(Color.BLUE);

        if (dx == 0 && dy == 0) {
            MainFrame.statusLabel.setText("READY !!!");
            MainFrame.statusLabel.setForeground(Color.RED);
        }
    }
}
