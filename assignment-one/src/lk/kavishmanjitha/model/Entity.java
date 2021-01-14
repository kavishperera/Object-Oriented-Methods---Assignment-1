package lk.kavishmanjitha.model;

import java.awt.*;

public class Entity {

    private int x, y, size;

    public Entity(int size) {
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int i) {
        this.x = x;
    }

    public void setY(int i) {
        this.y = y;
    }

    public void setPostion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public Rectangle getBound() {
        return new Rectangle(x, y, size, size);

    }

    public boolean isCollision(Entity o) {
        if (o == this) return false;
        return getBound().intersects(o.getBound());
    }

    public void render(Graphics2D g2d) {
        g2d.fillRect(x + 1, y + 1, size - 2, size - 2);
    }
}
