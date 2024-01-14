package com.rock_paper_scissors.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JPanel implements ActionListener {
    private final JButton rps = new JButton("가위 바위 보");
    private final JButton mjb = new JButton("묵 찌 빠");

    private final DisplayPanel win;
    public MainWindow(DisplayPanel win) {
        this.win = win;
        setBackground(Color.LIGHT_GRAY);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel selGame = new JLabel("게임을 선택 하시오");
        selGame.setFont(new Font("HY견고딕", Font.BOLD, 40));
        selGame.setAlignmentX(Component.CENTER_ALIGNMENT);

        Box buttonBox = Box.createHorizontalBox();
        rps.setFont(new Font("HY견고딕", Font.PLAIN, 20));
        rps.setBackground(Color.white);
        mjb.setFont(new Font("HY견고딕", Font.PLAIN, 20));
        mjb.setBackground(Color.white);

        buttonBox.add(rps).setMaximumSize(new Dimension(150, 150));
        buttonBox.add(Box.createHorizontalStrut(50));
        buttonBox.add(mjb).setMaximumSize(new Dimension(150, 150));
        buttonBox.setPreferredSize(new Dimension(200, 200));

        add(Box.createVerticalStrut(100));
        add(selGame);
        add(buttonBox);

        rps.addActionListener(this);
        mjb.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
