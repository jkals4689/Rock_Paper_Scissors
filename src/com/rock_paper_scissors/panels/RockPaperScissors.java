package com.rock_paper_scissors.panels;

import javax.swing.*;
import java.awt.*;

public class RockPaperScissors extends JPanel {
    public static JLabel result = new JLabel("준비 되셨습니까?");
    public JLabel timeout;

    private JLabel title;

    final void SetTitle(String str) {
        title = new JLabel(str);
        title.setFont(new Font("HY견고딕", Font.BOLD, 30));
        title.setForeground(new Color(41,158,57));
        title.setBackground(Color.white);
        title.setMaximumSize(new Dimension(230, 50));
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setOpaque(true); // 투명도 설정
    }

    public RockPaperScissors(DisplayPanel win, String gameName) {
         this.title = new JLabel(gameName);
    }
}
