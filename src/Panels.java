import javax.swing.*;
import java.awt.*;

public class Panels extends JPanel {
    public JPanel titlePan(String str) {
        JLabel gameName = new JLabel(str, SwingConstants.CENTER);
        gameName.setFont(new Font("HY견고딕", Font.BOLD, 30));
        gameName.setForeground(new Color(41, 158, 57));
        gameName.setBackground(Color.WHITE);
        gameName.setOpaque(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.add(gameName).setPreferredSize(new Dimension(230, 50));
        return panel;
    }

    public JPanel contentPan() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.add(Con("USER")); // 유저 박스
        panel.add(Box.createHorizontalStrut(100));
        panel.add(Con("PC")); // 컴퓨터 박스
        return panel;
    }

    public JPanel resultPan() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        panel.add(TextBox("TEST"));
        panel.setPreferredSize(new Dimension(Define.MAX_WIDTH, 70));
        return panel;
    }

    public JLabel TextBox(String str) {
        JLabel label = new JLabel(str, SwingConstants.CENTER);
        label.setFont(new Font("HY견고딕", Font.PLAIN, 40));
        label.setForeground(resultColor("BLACK"));
        return label;
    }

    public Color resultColor(String str) {
        Color color = Color.white;
        if (str == "RED")
            color = new Color(255, 0, 127);
        else if (str == "BLACK") {
            color = Color.black;
        }
        return color;
    }

    public Box Con(String str) {
        Box Container = Box.createVerticalBox();
        Box box = Box.createHorizontalBox();
        JLabel label = new JLabel(str, SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(25.0f));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.add(new RPS_Random(false));
        box.setBorder(BorderFactory.createBevelBorder(10));
        box.setBackground(Color.white);
        box.setPreferredSize(new Dimension(80, 80));
        box.setMaximumSize(new Dimension(80, 80));
        box.setOpaque(true);
        Container.add(label);
        Container.add(Box.createVerticalStrut(10));
        Container.add(box);
        Container.setOpaque(true);
        return Container;
    }

    public JPanel Retry() {
        JPanel panel = new JPanel();
        JButton[] btn = new JButton[2];
        String str[] = { "다시하기", "나가기" };
        for (int i = 0; i < str.length; i++) {
            btn[i] = new JButton("" + str[i]);
            btn[i].setMaximumSize(new Dimension(100, 40));
            // btn[i].addActionListener(util);
        }

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setPreferredSize(new Dimension(Define.MAX_WIDTH, 70));

        panel.add(btn[0]);
        panel.add(Box.createHorizontalStrut(50));
        panel.add(btn[1]);
        return panel;
    }
}
