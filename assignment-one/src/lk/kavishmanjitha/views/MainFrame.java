package lk.kavishmanjitha.views;

import lk.kavishmanjitha.Constant;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        pack();
        setSize(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
        setTitle(Constant.APPLICATION_TITLE);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
