import javax.swing.JPanel;
import javax.swing.JButton;

import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.Box;

public class RpsButtonPan extends JPanel {
    Util.RPS_Util util = new Util.RPS_Util();
    JButton scissors = util.scissors;
    JButton rock = util.rock;
    JButton paper = util.paper;

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
    public JPanel Ready() {
        JPanel panel = new JPanel();
        btn = new JButton("준비완료");
        btn.addActionListener(util);
        panel.removeAll();
        panel.add(btn);
        panel.updateUI();
        return panel;
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