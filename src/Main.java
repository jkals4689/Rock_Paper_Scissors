import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class MainWindow extends JPanel implements ActionListener {
    private JButton btn1 = new JButton("가위 바위 보");
    private JButton btn2 = new JButton("묵 찌 빠");
    private JLabel sel_Game = new JLabel("게임을 선택하시오");
    private Display_Panel win;

    public MainWindow(Display_Panel win) {
        this.win = win;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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

class RockPaperScissors extends JPanel implements ActionListener {
    private Display_Panel win;
    private JButton btn = new JButton("준비 완료");
    private Panels pan = new Panels();

    public RockPaperScissors(String gamename, Display_Panel win) {
        this.win = win;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(30));
        add(pan.titlePan(gamename));
        add(Box.createVerticalStrut(20));
        add(pan.contentPan());
        add(btn);

    }

    public void actionPerformed(ActionEvent e) {
        if (btn.getActionCommand().equals("준비 완료"))
            win.change("MainWindow");
    }
}

class Display_Panel extends JFrame {
    public MainWindow mainWindow = null;
    public RockPaperScissors rps1 = null;

    public void change(String panelname) {
        if (panelname.equals("RPS1")) {
            getContentPane().removeAll();
            getContentPane().add(rps1);
            revalidate();
            repaint();
        } else if (panelname.equals("MainWindow")) {
            getContentPane().removeAll();
            getContentPane().add(mainWindow);
            revalidate();
            repaint();
        }
    }
}

public class Main extends JFrame {

    public static void main(String[] args) {
        Display_Panel win = new Display_Panel();
        win.setTitle("미니 게임");
        win.mainWindow = new MainWindow(win);
        win.rps1 = new RockPaperScissors("가위 바위 보", win);
        win.add(win.mainWindow);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(Define.MAX_WIDTH, Define.MAX_HEIGHT);
        win.setVisible(true);
        win.setResizable(false);

    }

}
