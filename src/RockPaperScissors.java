import java.awt.*;
import javax.swing.*;

public class RockPaperScissors extends JFrame {
    private JPanel titlePan, contentPan, resultPan, buttonPan, retryPan, labelPan;
    Util.RPS_Util util = new Util.RPS_Util();
    public RockPaperScissors(String str) {
        util.rps_click();
        JLabel gameName = new JLabel(str, SwingConstants.CENTER);

        // 가위바위보 게임 이름
        JPanel titlePan = new JPanel();
        titlePan.setBackground(Color.RED);
        gameName.setFont(new Font("HY견고딕", Font.BOLD, 30));
        gameName.setForeground(new Color(41, 158, 57));
        gameName.setBackground(Color.WHITE);
        gameName.setOpaque(true);
        titlePan.add(gameName).setPreferredSize(new Dimension(230, 50));

        labelPan = new JPanel();
        // 컴퓨터 유저 텍스트
        contentPan = new JPanel();
        contentPan.setBackground(Color.BLUE);

        contentPan.add(Con("USER")); // 유저 박스
        contentPan.add(Box.createHorizontalStrut(100));
        contentPan.add(Con("PC")); // 컴퓨터 박스

        resultPan = new JPanel();
        resultPan.setBackground(Color.YELLOW);
        resultPan.add(resultBox("TEST"));
        resultPan.setPreferredSize(new Dimension(Define.MAX_WIDTH, 70));

        buttonPan = new JPanel();
        buttonPan.setBackground(Color.cyan);
        buttonPan.add(util.scissors);
        buttonPan.add(Box.createHorizontalStrut(30));
        buttonPan.add(button("바위"));
        buttonPan.add(Box.createHorizontalStrut(30));
        buttonPan.add(button("보"));

        retryPan = Retry();

        Main_Window.mainPan.setLayout(new BoxLayout(Main_Window.mainPan, BoxLayout.Y_AXIS));
        Main_Window.mainPan.add(Box.createVerticalStrut(30));
        Main_Window.mainPan.add(titlePan);
        Main_Window.mainPan.add(Box.createVerticalStrut(20));
        Main_Window.mainPan.add(contentPan);
        Main_Window.mainPan.add(resultPan);
        Main_Window.mainPan.add(buttonPan);
        // Main_Window.mainPan.add(pcNuser);
    }

    public Box Con(String str) {
        Box Container = Box.createVerticalBox();
        Box box = Box.createHorizontalBox();
        JLabel label = new JLabel(str, SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(25.0f));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        box.setBorder(BorderFactory.createBevelBorder(10));
        box.setBackground(Color.white);
        box.setPreferredSize(new Dimension(80, 80));
        box.setMaximumSize(new Dimension(80, 80));
        box.setMinimumSize(new Dimension(80, 80));
        box.setOpaque(true);
        Container.add(label);
        Container.add(Box.createVerticalStrut(10));
        Container.add(box);
        Container.setOpaque(true);
        return Container;
    }

    public JLabel resultBox(String str) {
        JLabel label = new JLabel(str, SwingConstants.CENTER);
        label.setFont(new Font("agave NFM", Font.BOLD, 40));
        label.setForeground(new Color(255, 0, 127));
        return label;
    }

    public JButton button(String str) {
        JButton button = new JButton(str);
        button.setFont(button.getFont().deriveFont(20.0f));
        button.setBackground(Color.white);
        button.setPreferredSize(new Dimension(80, 80));
        return button;
    }

    public JPanel Retry() {
        JPanel panel = new JPanel();
        JButton retry = new JButton("다시하기");
        JLabel or = new JLabel("또는");
        JButton exit = new JButton("나가기");

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setPreferredSize(new Dimension(Define.MAX_WIDTH, 70));
        retry.setMaximumSize(new Dimension(100, 40));
        exit.setMaximumSize(new Dimension(100, 40));

        panel.add(retry);
        panel.add(Box.createHorizontalStrut(50));
        panel.add(exit);
        return panel;
    }
}
