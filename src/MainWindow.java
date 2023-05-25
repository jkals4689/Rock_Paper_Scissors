import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JPanel implements ActionListener {
    private JButton btn1 = new JButton("가위 바위 보");
    private JButton btn2 = new JButton("묵 찌 빠");
    private JLabel sel_Game = new JLabel("게임을 선택하시오");
    private Main.Display_Panel win;

    public MainWindow(Main.Display_Panel win) {
        this.win = win;
        setLayout(null);
        sel_Game.setFont(sel_Game.getFont().deriveFont(30.0f));
        add(sel_Game);
        add(btn1).setMaximumSize(new Dimension(150, 150));
        add(Box.createHorizontalStrut(50));
        add(btn2).setMaximumSize(new Dimension(150, 150));
    }

    public void actionPerformed(ActionEvent e) {
        if (btn1.getActionCommand().equals("가위 바위 보"))
            win.change("RPS1");
    }
}
