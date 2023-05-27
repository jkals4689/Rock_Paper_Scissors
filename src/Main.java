import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

import java.util.Random;

class Define {
    public static final int MAX_WIDTH = 500;
    public static final int MAX_HEIGHT = 500;
}

class MainWindow extends JPanel {
    private JButton rpS = new JButton("가위 바위 보");
    private JButton mJB = new JButton("묵 찌 빠");
    private Display_Panel win;

    public MainWindow(Display_Panel win) {
        this.win = win;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel selGame = new JLabel("게임을 선택하시오");
        selGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        selGame.setFont(selGame.getFont().deriveFont(30.0f));

        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(rpS).setMaximumSize(new Dimension(150, 150));
        buttonBox.add(Box.createHorizontalStrut(50));
        buttonBox.add(mJB).setMaximumSize(new Dimension(150, 150));

        add(Box.createVerticalStrut(50));
        add(selGame);
        add(buttonBox);

        rpS.addActionListener(new MyActionListener());
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == rpS) {
                win.change("RPS1");
            }
        }
    }

}

class RockPaperScissors extends JPanel {
    private JButton btn = new JButton("준비 완료");
    private JLabel title;
    private JLabel result;
    private JPanel content = new JPanel();
    private Display_Panel win;

    final void SetTitle(String str) {
        title = new JLabel(str);
        title.setFont(new Font("HY견고딕", Font.BOLD, 30));
        title.setForeground(new Color(41, 158, 57));
        title.setBackground(Color.white);
        title.setMaximumSize(new Dimension(230, 50));
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setOpaque(true);
    }

    final Box SetCon(String str) {
        Box container = Box.createVerticalBox();
        Box box = Box.createHorizontalBox();

        // container.setPreferredSize(new Dimension(150, 150));
        container.setAlignmentX(CENTER_ALIGNMENT);
        container.setMaximumSize(new Dimension(150, 150));
        container.setBackground(Color.yellow);
        container.setOpaque(true);

        JLabel label = new JLabel(str, SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(25.0f));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        box.setBorder(BorderFactory.createBevelBorder(10));
        box.setBackground(Color.white);
        box.setMaximumSize(new Dimension(80, 80));
        box.setPreferredSize(new Dimension(80, 80));
        box.setOpaque(true);

        container.add(label);
        container.add(Box.createVerticalStrut(10));
        container.add(box);

        return container;
    }

    public RockPaperScissors(Display_Panel win, String gamename) {
        this.win = win;
        this.title = new JLabel(gamename);

        SetTitle(gamename);

        content.setBackground(Color.blue);
        content.setMaximumSize(new Dimension(Define.MAX_WIDTH, 200));
        content.add(SetCon("User"));
        content.add(Box.createHorizontalStrut(150));
        content.add(SetCon("Computer"));

        result = new JLabel("Are U Ready?");
        result.setFont(new Font("HY견고딕", Font.PLAIN, 40));
        result.setForeground(Color.white);
        result.setAlignmentX(CENTER_ALIGNMENT);

        btn.setAlignmentX(CENTER_ALIGNMENT);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(30));
        add(title);
        add(Box.createVerticalStrut(30));
        add(content);
        add(result);
        add(btn);

        btn.addActionListener(new MyActionListener());
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn) {
                win.change("MainWindow");
            }
        }
    }
}

class Display_Panel extends JFrame {
    public MainWindow mainWindow = null;
    public RockPaperScissors rps1 = null;
    public RockPaperScissors rps2 = null;

    public void change(String panelname) {
        if (panelname.equals("MainWindow")) {
            getContentPane().removeAll();
            getContentPane().add(mainWindow);
            revalidate();
            repaint();
        } else if (panelname.equals("RPS1")) {
            getContentPane().removeAll();
            getContentPane().add(rps1);
            revalidate();
            repaint();
        } else if (panelname.equals("RPS2")) {
            getContentPane().removeAll();
            getContentPane().add(rps2);
            revalidate();
            repaint();
        }
    }
}

public class Main extends JFrame {

    public static void main(String[] args) {
        Display_Panel win = new Display_Panel();
        win.setLayout(new FlowLayout(FlowLayout.CENTER));
        win.setTitle("미니 게임");
        win.mainWindow = new MainWindow(win);
        win.rps1 = new RockPaperScissors(win, "가위 바위 보");
        win.rps2 = new RockPaperScissors(win, "묵 찌 빠");

        win.add(win.mainWindow);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setSize(Define.MAX_WIDTH, Define.MAX_HEIGHT);
        win.setVisible(true);
        win.setResizable(false);

    }

}
