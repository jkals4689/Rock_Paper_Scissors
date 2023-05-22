import java.awt.*;
import javax.swing.*;

public class RockPaperScissors extends JFrame {
    private JPanel contentPan, resultPan, buttonPan, retryPan, labelPan;
    Util.RPS_Util util = new Util.RPS_Util();
    JLabel rps = new RPS_Random(false);

    JButton rock = util.rock;
    JButton paper = util.paper;
    JButton scissors = util.scissors;

    public RockPaperScissors(String str) {
        // 버튼 클릭 이벤트
        rock.addActionListener(util);
        paper.addActionListener(util);
        scissors.addActionListener(util);

        // 가위바위보 게임 이름
        JLabel gameName = new JLabel(str, SwingConstants.CENTER);
        gameName.setFont(new Font("HY견고딕", Font.BOLD, 30));
        gameName.setForeground(new Color(41, 158, 57));
        gameName.setBackground(Color.WHITE);
        gameName.setOpaque(true);

        JPanel titlePan = new JPanel();
        titlePan.setBackground(Color.RED);
        titlePan.add(gameName).setPreferredSize(new Dimension(230, 50));

        // 컴퓨터 유저 텍스트
        contentPan = new JPanel();
        contentPan.setBackground(Color.BLUE);
        contentPan.add(Con("USER")); // 유저 박스
        contentPan.add(Box.createHorizontalStrut(100));
        contentPan.add(Con("PC")); // 컴퓨터 박스

        resultPan = new JPanel();
        resultPan.setBackground(Color.YELLOW);
        resultPan.add(TextBox("TEST"));
        resultPan.setPreferredSize(new Dimension(Define.MAX_WIDTH, 70));

        Main_Window.mainPan.setLayout(new BoxLayout(Main_Window.mainPan, BoxLayout.Y_AXIS));
        Main_Window.mainPan.add(Box.createVerticalStrut(30));
        Main_Window.mainPan.add(titlePan);
        Main_Window.mainPan.add(Box.createVerticalStrut(20));
        Main_Window.mainPan.add(contentPan);
        Main_Window.mainPan.add(resultPan);
        Main_Window.mainPan.add(new RpsButtonPan(3));
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

    public JPanel Retry() {
        JPanel panel = new JPanel();
        JButton[] btn = new JButton[2];
        String str[] = { "다시하기", "나가기" };
        for (int i = 0; i < 2; i++) {
            btn[i] = new JButton("" + str[i]);
            btn[i].setMaximumSize(new Dimension(100, 40));
            btn[i].addActionListener(util);
        }

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setPreferredSize(new Dimension(Define.MAX_WIDTH, 70));

        panel.add(btn[0]);
        panel.add(Box.createHorizontalStrut(50));
        panel.add(btn[1]);
        return panel;
    }

}

class RpsButtonPan extends JPanel {
    Util.RPS_Util util = new Util.RPS_Util();
    J
    public RpsButtonPan(int num) {
        JButton btn;
        setPreferredSize(new Dimension(Define.MAX_WIDTH, 70));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        if (num == 1) {
            btn = new JButton("준비 완료");
            btn.addActionListener(util);
            removeAll();
            add(btn);
            updateUI();
        }
        if (num == 2) {
            removeAll();
            add(scissors);
            add(Box.createHorizontalStrut(30));
            add(rock);
            add(Box.createHorizontalStrut(30));
            add(paper);
            updateUI();

        }
        if (num == 3) {
            removeAll();
            add(Retry());
            updateUI();
        }

    }
}
