package lk.kavishmanjitha.views;

import lk.kavishmanjitha.Constant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame() {
        setSize(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
        setTitle(Constant.APPLICATION_TITLE);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(Color.WHITE);
        gamePanel.setPreferredSize(new Dimension(500, 500));
        gamePanel.setBounds(0, 0, 500, 500);
        add(gamePanel, BorderLayout.NORTH);

        JButton startButton = new JButton();
        startButton.setText("START");
        startButton.setBackground(Color.GREEN);
        add(startButton, BorderLayout.WEST);

        JLabel statusLable = new JLabel();
        statusLable.setText("SCORE : 0");
        statusLable.setBorder(new EmptyBorder(0, 50, 0, 0));
        add(statusLable, BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Start");
            }
        });
    }
}
