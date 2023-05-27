import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JPanel {
    private JButton btn1 = new JButton("가위 바위 보");
    private JButton btn2 = new JButton("묵 찌 빠");
    private JLabel sel_Game = new JLabel("게임을 선택하시오");
    Util.Main_Util util = new Util.Main_Util();

    public MainWindow() {
        sel_Game.setAlignmentX(Component.CENTER_ALIGNMENT);
        sel_Game.setFont(sel_Game.getFont().deriveFont(30.0f));

        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(btn1).setMaximumSize(new Dimension(150, 150));
        buttonBox.add(Box.createHorizontalStrut(50));
        buttonBox.add(btn2).setMaximumSize(new Dimension(150, 150));
        btn1.addActionListener(util);
        btn2.addActionListener(util);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(50));
        add(sel_Game);
        add(buttonBox);
    }

    // public void actionPerformed(ActionEvent e) {
    // if (btn1.getActionCommand().equals("가위 바위 보"))
    // win.change("RPS1");
    // }
}
