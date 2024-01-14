package com.rock_paper_scissors.panels;

import com.rock_paper_scissors.Define;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    public JLabel countDown = new JLabel("");

    private DisplayPanel win;
    private int connum = 0;
    private final JLabel computerIconLabel = new JLabel("");
    private final JLabel userIconLabel = new JLabel("");

    public void setIconLabel(int user, int computer) {
        if(user != Define.CLEAR && computer != Define.CLEAR){
            this.userIconLabel.setIcon(Define.getImageIcon(user));
            this.computerIconLabel.setIcon(Define.getImageIcon(computer));
        } else if (user == Define.CLEAR && computer == Define.CLEAR){
            this.userIconLabel.setIcon(null);
            this.computerIconLabel.setIcon(null);
        }
    }

    private Box box() {
        Box box = Box.createHorizontalBox(); // Box 생성

        if(connum == 0) {
            box.add(userIconLabel);
        } else box.add(computerIconLabel);

        box.setBorder(BorderFactory.createBevelBorder(10));
        box.setBackground(Color.white);
        box.setMaximumSize(new Dimension(80, 80));
        box.setPreferredSize(new Dimension(80, 80));
        box.setOpaque(true);
        this.connum++;

        return box;
    }

    private Box Con(String user) {
        Box container = Box.createVerticalBox();

        container.setAlignmentX(CENTER_ALIGNMENT);
        container.setPreferredSize(new Dimension(150, 150));
        container.setMaximumSize(new Dimension(150, 150));

        JLabel label = new JLabel(user, SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(25.0f));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        Box box = box();

        container.add(label);
        container.add(Box.createVerticalStrut(10));
        container.add(box);

        return container;
    }

    public ContentPanel(DisplayPanel win, String gameName) {
        this.win = win;
        setBackground(Color.LIGHT_GRAY);

        setMaximumSize(new Dimension(Define.MAX_WIDTH, 150));
        setOpaque(true);

        countDown.setFont(new Font("HY견고딕", Font.PLAIN, 40));
        countDown.setPreferredSize(new Dimension(40,100));
        countDown.setForeground(Color.black);

        add(Con("User"));
        add(Box.createHorizontalStrut(30));
        add(countDown);
        add(Box.createHorizontalStrut(30));
        add(Con("Computer"));
    }
}
