import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
            icon[i] = new ImageIcon("src\\img\\" + str[(str.length - 1) - i] + ".jpg");
            Image img = icon[i].getImage();
            Image changeImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            icon[i] = new ImageIcon(changeImg);
        }
    }
}

class MainWindow extends JPanel implements ActionListener {
    private JButton rpS = new JButton("가위 바위 보");
    private JButton mJB = new JButton("묵 찌 빠");
    private Display_Panel win;

    public MainWindow(Display_Panel win) {
        this.win = win;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel selGame = new JLabel("게임을 선택하시오");
        selGame.setFont(new Font("HY견고딕", Font.BOLD, 40));
        selGame.setAlignmentX(Component.CENTER_ALIGNMENT);

        Box buttonBox = Box.createHorizontalBox();
        rpS.setFont(new Font("HY견고딕", Font.PLAIN, 20));
        mJB.setFont(new Font("HY견고딕", Font.PLAIN, 20));
        buttonBox.add(rpS).setMaximumSize(new Dimension(150, 150));
        buttonBox.add(Box.createHorizontalStrut(50));
        buttonBox.add(mJB).setMaximumSize(new Dimension(150, 150));
        buttonBox.setPreferredSize(new Dimension(200, 200));
        add(Box.createVerticalStrut(100));
        add(selGame);
        add(buttonBox);

        rpS.addActionListener(this);
        mJB.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rpS)
            win.change("RPS1");
        else if (e.getSource() == mJB)
            win.change("RPS2");
    }
}

class RpsButtonPan extends JPanel implements ActionListener {
    private JButton ready = new JButton("준비 완료");
    private JButton rpsBtnp[] = new JButton[3];
    private JButton rtNex[] = new JButton[2];
    private String[] str2 = { "다시하기", "나가기" };
    private Random random = new Random();
    private ContentPanel content;
    private Display_Panel win;
    private String gamename;
    private String atk = "U";
    private Timer timer;
    private int count;

    public RpsButtonPan(Display_Panel win, ContentPanel content, String gamename) {
        this.win = win;
        this.content = content;
        this.gamename = gamename;
        this.startGame();

        ready.addActionListener(this);
        ready.setFont(new Font("HY견고딕", Font.PLAIN, 20));
        ready.setPreferredSize(new Dimension(150, 40));

        for (int i = 0; i < rpsBtnp.length; i++) {
            rpsBtnp[i] = new JButton("");
            rpsBtnp[i].setIcon(win.util.icon[i]);
            rpsBtnp[i].addActionListener(this);
            rpsBtnp[i].setFont(new Font("HY견고딕", Font.PLAIN, 20));
            rpsBtnp[i].setPreferredSize(new Dimension(80, 80));
        }

        for (int i = 0; i < rtNex.length; i++) {
            rtNex[i] = new JButton(str2[i]);
            rtNex[i].addActionListener(this);
            rtNex[i].setFont(new Font("HY견고딕", Font.PLAIN, 20));
            rtNex[i].setPreferredSize(new Dimension(150, 40));
        }

        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        setMaximumSize(new Dimension(Define.MAX_WIDTH, 100));
        this.change("ready");
    }

    public void change(String str) {

        if (str.equals("ready")) {
            removeAll();
            add(ready);
            add(rtNex[1]);
            updateUI();
        } else if (str.equals("start")) {
            removeAll();
            add(rpsBtnp[0]);
            add(rpsBtnp[1]);
            add(rpsBtnp[2]);
            updateUI();
        } else if (str.equals("end")) {
            removeAll();
            add(rtNex[0]);
            add(rtNex[1]);
            updateUI();
        }
    }

    private final void rpsgame(int user, int com) {
        if (user == com) {
            System.out.println("Tie.");
            win.setLabel("비겼습니다");
            change("end");
        } else if (user == 0 && com == 1 || user == 1 && com == 2 || user == 2 && com == 0) {
            System.out.println("Lose.");
            win.setLabel("당신이 졌습니다");
            change("end");
        } else if (user == 0 && com == 2 || user == 1 && com == 0 || user == 2 && com == 1) {
            System.out.println("Win.");
            win.setLabel("당신이 이겼습니다");
            change("end");
        }
    }

    private final void mjbgame(int user, int com) {

        if (atk.equals("U")) {
            if (user == com) {
                System.out.println("Win");
                System.out.println("Atk : " + atk);
                win.setLabel("당신이 이겼습니다");
                this.timer.stop();
                change("end");
            } else if (user == Define.PAPER && com == Define.ROCK || user == Define.ROCK && com == Define.SCISSORS
                    || user == Define.SCISSORS && com == Define.PAPER) {
                this.atk = "U";
                this.count = 3;
                this.content.countdown.setText(String.valueOf(count));
                change("start");
                System.out.println("Continue");
            } else if (user == Define.PAPER && com == Define.SCISSORS || user == Define.ROCK && com == Define.PAPER
                    || user == Define.SCISSORS && com == Define.ROCK) {
                this.atk = "C";
                this.count = 3;
                this.content.countdown.setText(String.valueOf(count));
                change("start");
                System.out.println("Continue");
            }
        } else if (atk.equals("C")) {
            if (user == com) {
                System.out.println("Lose");
                System.out.println("Atk : " + atk);
                win.setLabel("당신이 졌습니다");
                this.timer.stop();
                change("end");
            } else if (user == Define.PAPER && com == Define.ROCK || user == Define.ROCK && com == Define.SCISSORS
                    || user == Define.SCISSORS && com == Define.PAPER) {
                this.atk = "U";
                this.count = 3;
                this.content.countdown.setText(String.valueOf(count));
                change("start");
                System.out.println("Continue");
            } else if (user == Define.PAPER && com == Define.SCISSORS || user == Define.ROCK && com == Define.PAPER
                    || user == Define.SCISSORS && com == Define.ROCK) {
                this.atk = "C";
                this.count = 3;
                this.content.countdown.setText(String.valueOf(count));
                change("start");
                System.out.println("Continue");
            }
        }

    }

    private void startGame() {
        count = 3;
        // content.countdown.setText(String.valueOf(count));

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(count);
                count--;
                content.countdown.setText(String.valueOf(count));

                if (count == 0) {
                    System.out.println("Time Out");
                    win.setLabel("시간 초과");
                    change("end");
                    timer.stop();
                }
            }
        });
    }

    public void result(int user) {
        int com = random.nextInt(3);

        System.out.println("user : " + user + " com : " + com);
        content.setIconlabel(user, com);
        if (gamename.equals("가위 바위 보"))
            this.rpsgame(user, com);
        else if (gamename.equals("묵 찌 빠"))
            this.mjbgame(user, com);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ready) {
            System.out.println("Ready");
            if (gamename.equals("가위 바위 보")) {
                win.setLabel("선택 하세요");
            } else if (gamename.equals("묵 찌 빠")) {
                win.setLabel("3초 내로 선택하세요");
                count = 3;
                this.content.countdown.setText(String.valueOf(count));
                timer.start();
            }
            change("start");
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
            count = 3;
            content.setIconlabel(Define.CLEAR, Define.CLEAR);
            content.countdown.setText("");
            change("ready");
        } else if (e.getSource() == rtNex[1]) {
            System.out.println("Exit");
            this.timer = null;
            win.change("MainWindow");
        }
    }

}

class ContentPanel extends JPanel {
    private Display_Panel win;
    private int connum = 0;
    private JLabel iconlabel = new JLabel("");
    private JLabel usericonlabel = new JLabel("");
    public JLabel countdown = new JLabel("");

    public void setIconlabel(int user, int com) {
        if (user != Define.CLEAR && com != Define.CLEAR) {
            this.usericonlabel.setIcon(win.util.icon[user]);
            this.iconlabel.setIcon(win.util.icon[com]);
        } else if (user == Define.CLEAR && com == Define.CLEAR) {
            this.usericonlabel.setIcon(null);
            this.iconlabel.setIcon(null);
        }
    }

    private Box box() {
        Box box = Box.createHorizontalBox();

        if (this.connum == 0)
            box.add(this.usericonlabel);
        else
            box.add(this.iconlabel);

        box.setBorder(BorderFactory.createBevelBorder(10));
        box.setBackground(Color.white);
        box.setMaximumSize(new Dimension(80, 80));
        box.setPreferredSize(new Dimension(80, 80));
        box.setOpaque(true);
        this.connum++;

        return box;
    }

    private Box Con(String user) {
        Box container = Box.createVerticalBox();

        container.setAlignmentX(CENTER_ALIGNMENT);
        container.setPreferredSize(new Dimension(150, 150));
        container.setMaximumSize(new Dimension(150, 150));

        JLabel label = new JLabel(user, SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(25.0f));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        Box box = box();

        container.add(label);
        container.add(Box.createVerticalStrut(10));
        container.add(box);

        return container;
    }

    public ContentPanel(Display_Panel win, String gamename) {
        this.win = win;

        setMaximumSize(new Dimension(Define.MAX_WIDTH, 150));
        setOpaque(true);

        countdown.setFont(new Font("HY견고딕", Font.PLAIN, 40));
        countdown.setPreferredSize(new Dimension(40, 100));
        countdown.setForeground(Color.black);

        add(Con("User"));
        add(Box.createHorizontalStrut(30));
        add(countdown);
        add(Box.createHorizontalStrut(30));
        add(Con("Computer"));
    }
}

class RockPaperScissors extends JPanel {
    private RpsButtonPan rpsButtonPan = null;
    private JLabel title;
    public JLabel result = new JLabel("준비 되셨습니까?");
    public JLabel timeout;
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
        this.content = new ContentPanel(win, gamename);
        this.rpsButtonPan = new RpsButtonPan(win, content, gamename);

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
    private String sel;

    public Display_Panel() {
        util.setIcon();
    }

    public void change(String panelname) {
        if (panelname.equals("MainWindow")) {
            this.sel = "Main";
            getContentPane().removeAll();
            getContentPane().add(mainWindow);
            revalidate();
            repaint();
        } else if (panelname.equals("RPS1")) {
            this.sel = "RPS1";
            rps1 = new RockPaperScissors(this, "가위 바위 보");
            getContentPane().removeAll();
            getContentPane().add(rps1);
            revalidate();
            repaint();
        } else if (panelname.equals("RPS2")) {
            this.sel = "RPS2";
            rps2 = new RockPaperScissors(this, "묵 찌 빠");
            getContentPane().removeAll();
            getContentPane().add(rps2);
            revalidate();
            repaint();
        }
    }

    public void setLabel(String str) {
        if (sel.equals("RPS1"))
            rps1.result.setText(str);
        else if (sel.equals("RPS2"))
            rps2.result.setText(str);
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
