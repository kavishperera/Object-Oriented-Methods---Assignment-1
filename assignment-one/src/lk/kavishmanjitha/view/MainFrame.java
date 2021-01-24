package lk.kavishmanjitha.view;

import lk.kavishmanjitha.util.Constant;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    public static JLabel statusLabel;

    public MainFrame() {
        pack();
        setTitle(Constant.APPLICATION_TITLE);
        setSize(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        GamePanel gamePanel = new GamePanel();
        gamePanel.setBackground(Color.WHITE);
        gamePanel.setPreferredSize(new Dimension(Constant.GAME_PANEL_WIDTH, Constant.GAME_PANEL_HEIGHT));
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        gamePanel.setBounds(0, 0, Constant.GAME_PANEL_WIDTH, Constant.GAME_PANEL_HEIGHT);
        add(gamePanel, BorderLayout.NORTH);

        JButton startButton = new JButton();
        startButton.setText("START");
        startButton.setBackground(Color.GREEN);
        add(startButton, BorderLayout.WEST);

        statusLabel = new JLabel();
        statusLabel.setText("SCORE : 0");
        statusLabel.setBorder(new EmptyBorder(0, 50, 0, 0));
        add(statusLabel, BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Start");
            }
        });
    }
}
