import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.*;

import java.util.Random;

class Define {
    public static final int MAX_WIDTH = 500;
    public static final int MAX_HEIGHT = 500;
    public static final int SCISSORS = 0;
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int CLEAR = -1;
    public static final int NULL = -2;
    public final ImageIcon[] icon = new ImageIcon[3];
    private final String[] str = { "Scissors", "Rock", "Paper" };

    public void setIcon() {
        for (int i = 0; i < str.length; i++) {
            icon[i] = new ImageIcon("src\\img\\" + str[(str.length-1) - i] + ".jpg");
            Image img = icon[i].getImage();
            Image changeImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            icon[i] = new ImageIcon(changeImg);
        }
    }
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

class RpsButtonPan extends JPanel implements ActionListener {
    private JButton ready = new JButton("준비 완료");
    private JButton rpsBtnp[] = new JButton[3];
    private JButton rtNex[] = new JButton[2];
    private String[] str = { "Scissors", "Rock", "Paper" };
    private String[] str2 = { "다시하기", "나가기" };
    private Random random = new Random();
    private ContentPanel content;
    private Display_Panel win;

    public RpsButtonPan(Display_Panel win, ContentPanel content) {
        this.win = win;
        this.content = content;
        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        setMaximumSize(new Dimension(Define.MAX_WIDTH, 100));
        this.change("ready");
    }

    private void change(String str) {

        if (str.equals("ready")) {
            removeAll();
            ready.addActionListener(this);
            ready.setFont(new Font("HY견고딕", Font.PLAIN, 20));
            ready.setPreferredSize(new Dimension(150, 40));
            add(ready);
            updateUI();
        } else if (str.equals("start")) {
            removeAll();
            RpsButton();
            updateUI();
        } else if (str.equals("end")) {
            removeAll();
            Retry();
            updateUI();
        }
    }

    public void RpsButton() {
        for (int i = 0; i < rpsBtnp.length; i++) {
            rpsBtnp[i] = new JButton("");
            rpsBtnp[i].setIcon(win.util.icon[i]);
            rpsBtnp[i].addActionListener(this);
            rpsBtnp[i].setFont(new Font("HY견고딕", Font.PLAIN, 20));
            rpsBtnp[i].setPreferredSize(new Dimension(80, 80));
            add(rpsBtnp[i]);
        }
    }

    public void Retry() {
        for (int i = 0; i < rtNex.length; i++) {
            rtNex[i] = new JButton(str2[i]);
            rtNex[i].addActionListener(this);
            rtNex[i].setFont(new Font("HY견고딕", Font.PLAIN, 20));
            rtNex[i].setPreferredSize(new Dimension(150, 40));
            add(rtNex[i]);
        }
    }

    public void result(int user) {
        int com = random.nextInt(3);
        String str[] = { "Scissors", "Rock", "Paper" };

        System.out.println("user : " + user + " com : " + com);
        content.setCon(user, com);
        if (user == com) {
            System.out.println("Tie.");
            win.setLabel("비겼습니다");
            this.change("end");
        } else if (user == 0 && com == 1 || user == 1 && com == 2 || user == 2 && com == 0) {
            System.out.println("Lose.");
            win.setLabel("당신이 졌습니다");
            this.change("end");
        } else if (user == 0 && com == 2 || user == 1 && com == 0 || user == 2 && com == 1) {
            System.out.println("Win.");
            win.setLabel("당신이 이겼습니다");
            this.change("end");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ready) {
            System.out.println("Ready");
            win.setLabel("선택 하세요");
            this.change("start");
        }

        if (e.getSource() == rpsBtnp[0]) {
            System.out.println("Scissors");
            result(Define.SCISSORS);
        } else if (e.getSource() == rpsBtnp[1]) {
            System.out.println("Rock");
            result(Define.ROCK);
        } else if (e.getSource() == rpsBtnp[2]) {
            System.out.println("Paper");
            result(Define.PAPER);
        }

        if (e.getSource() == rtNex[0]) {
            System.out.println("Retry");
            win.setLabel("준비 되셨습니까?");
            content.setCon(Define.CLEAR, Define.CLEAR);
            this.change("ready");
        } else if (e.getSource() == rtNex[1]) {
            System.out.println("Exit");
            win.change("MainWindow");
        }
    }

}

class ContentPanel extends JPanel {
    private Box user;
    private Box computer;
    private JLabel iconlabel = new JLabel("");
    private Display_Panel win;

    public void setCon(int user, int com) {
        this.user = Con("User", user);
        this.computer = Con("Computer", com);

        removeAll();
        add(this.user);
        add(Box.createHorizontalStrut(100));
        add(this.computer);
        updateUI();
    }

    private Box box(int number) {
        Box box = Box.createHorizontalBox();

        if (number == Define.ROCK) {
            System.out.println("Rock");
            iconlabel.setIcon(win.util.icon[Define.ROCK]);
            box.add(iconlabel);
        } else if (number == Define.SCISSORS) {
            System.out.println("Scissors");
            iconlabel.setIcon(win.util.icon[Define.SCISSORS]);
            box.add(iconlabel);
        } else if (number == Define.PAPER) {
            System.out.println("Paper");
            iconlabel.setIcon(win.util.icon[Define.PAPER]);
            box.add(iconlabel);
        } else if (number == Define.CLEAR) {
            System.out.println("Clear");
            iconlabel.setIcon(null);
            iconlabel.setText("?");
            box.add(iconlabel);
        } else if (number == Define.NULL) {
            System.out.println("null");
            iconlabel = new JLabel("?", SwingConstants.CENTER);
            box.add(iconlabel);
        }

        box.setBorder(BorderFactory.createBevelBorder(10));
        box.setBackground(Color.white);
        box.setMaximumSize(new Dimension(80, 80));
        box.setPreferredSize(new Dimension(80, 80));
        box.setOpaque(true);

        return box;
    }

    private Box Con(String user, int num) {
        Box container = Box.createVerticalBox();

        container.setAlignmentX(CENTER_ALIGNMENT);
        container.setPreferredSize(new Dimension(150, 150));
        container.setMaximumSize(new Dimension(150, 150));

        JLabel label = new JLabel(user, SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(25.0f));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        Box box = box(num);

        container.add(label);
        container.add(Box.createVerticalStrut(10));
        container.add(box);

        return container;
    }

    public ContentPanel(Display_Panel win) {
        this.win = win;

        setMaximumSize(new Dimension(Define.MAX_WIDTH, 170));
        setOpaque(true);

        setCon(Define.NULL, Define.NULL);
    }
}

class RockPaperScissors extends JPanel {
    private RpsButtonPan rpsButtonPan = null;
    private JLabel title;
    public JLabel result = new JLabel("준비 되셨습니까?");
    private ContentPanel content = null;

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

    public RockPaperScissors(Display_Panel win, String gamename) {
        this.title = new JLabel(gamename);
        this.content = new ContentPanel(win);
        this.rpsButtonPan = new RpsButtonPan(win, content);

        SetTitle(gamename);

        result.setFont(new Font("HY견고딕", Font.PLAIN, 40));
        result.setForeground(Color.black);
        result.setAlignmentX(CENTER_ALIGNMENT);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(30));
        add(title);
        add(Box.createVerticalStrut(30));
        add(content);
        add(Box.createVerticalStrut(20));
        add(result);
        add(Box.createVerticalStrut(20));
        add(rpsButtonPan);
    }
}

class Display_Panel extends JFrame {
    public MainWindow mainWindow = null;
    public RockPaperScissors rps1 = null;
    public RockPaperScissors rps2 = null;
    public Define util = new Define();

    public Display_Panel() {
        util.setIcon();
    }

    public void change(String panelname) {
        if (panelname.equals("MainWindow")) {
            getContentPane().removeAll();
            getContentPane().add(mainWindow);
            revalidate();
            repaint();
        } else if (panelname.equals("RPS1")) {
            rps1 = new RockPaperScissors(this, "가위 바위 보");
            getContentPane().removeAll();
            getContentPane().add(rps1);
            revalidate();
            repaint();
        } else if (panelname.equals("RPS2")) {
            rps2 = new RockPaperScissors(this, "묵 찌 빠");
            getContentPane().removeAll();
            getContentPane().add(rps2);
            revalidate();
            repaint();
        }
    }

    public void setLabel(String str) {
        rps1.result.setText(str);
    }
}

public class Main extends JFrame {

    public static void main(String[] args) {
        Display_Panel win = new Display_Panel();

        win.setTitle("미니 게임");
        win.mainWindow = new MainWindow(win);

        win.add(win.mainWindow);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setSize(Define.MAX_WIDTH, Define.MAX_HEIGHT);
        win.setVisible(true);
        win.setResizable(false);

    }

}
