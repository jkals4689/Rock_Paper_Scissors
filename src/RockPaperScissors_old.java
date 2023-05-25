import java.awt.*;

import javax.swing.*;

public class RockPaperScissors_old extends JFrame {
    Panels panels = new Panels();
    Util.RPS_Util util = new Util.RPS_Util();

    JButton rock = util.rock;
    JButton paper = util.paper;
    JButton scissors = util.scissors;

    public RockPaperScissors_old(String str) {
        // 버튼 클릭 이벤트
        rock.addActionListener(util);
        paper.addActionListener(util);
        scissors.addActionListener(util);

        Main_Window.mainPan.removeAll();
        Ready(str);
        Main_Window.mainPan.updateUI();
    }

    public void End(String str) {
        Main_Window.mainPan.setLayout(new BoxLayout(Main_Window.mainPan, BoxLayout.Y_AXIS));
        Main_Window.mainPan.add(Box.createVerticalStrut(30));
        Main_Window.mainPan.add(titlePan(str));
        Main_Window.mainPan.add(Box.createVerticalStrut(20));
        Main_Window.mainPan.add(contentPan());
        Main_Window.mainPan.add(resultPan());
        Main_Window.mainPan.add(new RpsButtonPan(3));
    }
}