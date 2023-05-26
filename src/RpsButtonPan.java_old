import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;

import javax.swing.BoxLayout;
import java.awt.Dimension;

import javax.swing.Box;

public class RpsButtonPan extends JPanel implements ActionListener {
    Util.RPS_Util util = new Util.RPS_Util();
    JButton scissors = util.scissors;
    JButton rock = util.rock;
    JButton paper = util.paper;
    JButton btn;
    RockPaperScissors_old rps;

    public RpsButtonPan(int num) {
        setPreferredSize(new Dimension(Define.MAX_WIDTH, 70));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        if (num == 1) {
            btn = new JButton("준비 완료");
            btn.addActionListener(this);
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

    public JPanel Retry() {
        JPanel panel = new JPanel();
        JButton[] btn = new JButton[2];
        String str[] = { "다시하기", "나가기" };
        for (int i = 0; i < str.length; i++) {
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

    public void actionPerformed(ActionEvent e) {
        if (btn.getActionCommand().equals("준비 완료")) {
            System.out.println("I'm Ready");
            Start("가위 바위 보");
        }
    }

    public void Start(String str) {
        Main_Window.mainPan.setLayout(new BoxLayout(Main_Window.mainPan, BoxLayout.Y_AXIS));
        Main_Window.mainPan.add(Box.createVerticalStrut(30));
        Main_Window.mainPan.add(rps.titlePan(str));
        Main_Window.mainPan.add(Box.createVerticalStrut(20));
        Main_Window.mainPan.add(rps.contentPan());
        Main_Window.mainPan.add(rps.resultPan());
        Main_Window.mainPan.add(new RpsButtonPan(2));
    }

}