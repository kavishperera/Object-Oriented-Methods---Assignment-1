package lk.kavishmanjitha.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DirectionKeyAdapter extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_LEFT)) {
            GamePanel.leftDirection = true;
            GamePanel.rightDirection = false;
            GamePanel.upDirection = false;
            GamePanel.downDirection = false;
        }

        if ((key == KeyEvent.VK_RIGHT)) {
            GamePanel.leftDirection = false;
            GamePanel.rightDirection = true;
            GamePanel.upDirection = false;
            GamePanel.downDirection = false;
        }

        if ((key == KeyEvent.VK_UP)) {
            GamePanel.rightDirection = false;
            GamePanel.leftDirection = false;
            GamePanel.upDirection = true;
            GamePanel.downDirection = false;
        }

        if ((key == KeyEvent.VK_DOWN)) {
            GamePanel.rightDirection = false;
            GamePanel.leftDirection = false;
            GamePanel.upDirection = false;
            GamePanel.downDirection = true;
        }
    }
}
