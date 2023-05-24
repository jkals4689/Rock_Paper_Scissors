import java.awt.*;
import javax.swing.*;

public class RockPaperScissors extends JFrame {
    private JPanel contentPan, resultPan, buttonPan, retryPan, labelPan;
    Util.RPS_Util util = new Util.RPS_Util();

    JButton rock = util.rock;
    JButton paper = util.paper;
    JButton scissors = util.scissors;

    public RockPaperScissors(String str) {
        // 버튼 클릭 이벤트
        rock.addActionListener(util);
        paper.addActionListener(util);
        scissors.addActionListener(util);

        Main_Window.mainPan.removeAll();
        Main_Window.mainPan.setLayout(new BoxLayout(Main_Window.mainPan, BoxLayout.Y_AXIS));
        Main_Window.mainPan.add(Box.createVerticalStrut(30));
        Main_Window.mainPan.add(titlePan(str));
        Main_Window.mainPan.add(Box.createVerticalStrut(20));
        Main_Window.mainPan.add(contentPan());
        Main_Window.mainPan.add(resultPan());
        Main_Window.mainPan.add(new RpsButtonPan(util.num));
        Main_Window.mainPan.updateUI();
    }

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

}