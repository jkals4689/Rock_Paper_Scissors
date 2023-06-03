import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import java.util.Random;

/*
 * Define 클래스
 */
class Define {
    public static final int MAX_WIDTH = 500; // 프레임 너비
    public static final int MAX_HEIGHT = 500; // 프레임 높이
    public static final int SCISSORS = 0; // 가위
    public static final int ROCK = 1; // 바위
    public static final int PAPER = 2; // 보
    public static final int CLEAR = -1; // 초기화
    public final ImageIcon[] icon = new ImageIcon[3]; // 이미지 아이콘
    private final String[] str = { "Scissors", "Rock", "Paper" }; // 이미지 이름

    /*
     * 이미지 아이콘 설정
     */
    public void setIcon() {
        for (int i = 0; i < str.length; i++) {
            icon[i] = new ImageIcon("src\\img\\" + str[(str.length - 1) - i] + ".jpg");
            Image img = icon[i].getImage();
            Image changeImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            icon[i] = new ImageIcon(changeImg);
        }
    }
}

/*
 * MainWindow 클래스
 */
class MainWindow extends JPanel implements ActionListener {
    private JButton rpS = new JButton("가위 바위 보"); // 가위 바위 보 버튼
    private JButton mJB = new JButton("묵 찌 빠"); // 묵 찌 빠 버튼
    private Display_Panel win; // Display_Panel 클래스

    public MainWindow(Display_Panel win) {
        this.win = win; // Display_Panel 클래스 설정

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // MainWindow의 레이아웃 설정(BoxLayout)
        JLabel selGame = new JLabel("게임을 선택하시오"); // "게임을 선택하시오"의 문자열 설정
        selGame.setFont(new Font("HY견고딕", Font.BOLD, 40)); // selGame의 폰트 설정
        selGame.setAlignmentX(Component.CENTER_ALIGNMENT); // selGame의 정렬 설정

        Box buttonBox = Box.createHorizontalBox(); // 가위 바위 보, 묵 찌 빠 버튼을 담을 Box 생성
        rpS.setFont(new Font("HY견고딕", Font.PLAIN, 20)); // 가위 바위 보 버튼의 폰트 설정
        mJB.setFont(new Font("HY견고딕", Font.PLAIN, 20)); // 묵 찌 빠 버튼의 폰트 설정
        buttonBox.add(rpS).setMaximumSize(new Dimension(150, 150)); // 가위 바위 보 버튼을 buttonBox에 추가
        buttonBox.add(Box.createHorizontalStrut(50)); // 가위 바위 보 버튼과 묵 찌 빠 버튼 사이의 간격 설정
        buttonBox.add(mJB).setMaximumSize(new Dimension(150, 150)); // 묵 찌 빠 버튼을 buttonBox에 추가
        buttonBox.setPreferredSize(new Dimension(200, 200)); // buttonBox의 크기 설정
        add(Box.createVerticalStrut(100)); // MainWindow의 상단과 가위 바위 보, 묵 찌 빠 버튼 사이의 간격 설정
        add(selGame); // MainWindow에 selGame 추가
        add(buttonBox); // MainWindow에 buttonBox 추가

        rpS.addActionListener(this); // 가위 바위 보 버튼에 ActionListener 추가
        mJB.addActionListener(this); // 묵 찌 빠 버튼에 ActionListener 추가
    }

    /*
     * 버튼 클릭 시 이벤트 처리
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rpS)
            win.change("RPS1"); // 가위 바위 보 버튼 클릭 시 RPS1 패널로 전환
        else if (e.getSource() == mJB)
            win.change("RPS2"); // 묵 찌 빠 버튼 클릭 시 RPS2 패널로 전환
    }
}

/*
 * RpsButtonPan 클래스
 */
class RpsButtonPan extends JPanel implements ActionListener {
    private JButton ready = new JButton("준비 완료"); // 준비 완료 버튼
    private JButton rpsBtnp[] = new JButton[3]; // 가위, 바위, 보 버튼
    private JButton rtNex[] = new JButton[2]; // 다시하기, 나가기 버튼
    private String[] str2 = { "다시하기", "나가기" }; // 다시하기, 나가기 버튼의 문자열
    private Random random = new Random(); // 랜덤 객체
    private ContentPanel content;
    private Display_Panel win;
    private String gamename;
    private String atk = "U"; // U : User, C : Computer | 묵 찌 빠 게임에서 사용 | 사용자가 먼저 공격
    private Timer timer; // 타이머
    private int count;

    public RpsButtonPan(Display_Panel win, ContentPanel content, String gamename) {
        this.win = win; // Display_Panel 클래스 설정 | Display_Panel 클래스의 메소드 사용을 위해 필요
        this.content = content; // ContentPanel 클래스 설정 | ContentPanel 클래스의 메소드 사용을 위해 필요
        this.gamename = gamename; // 게임 이름 설정 | 게임 이름에 따라 다른 동작을 하기 위해 필요
        this.startGame(); // 묵 찌 빠 게임에서 사용 | 게임 시작 시 타이머 시작

        ready.addActionListener(this); // 준비 완료 버튼에 ActionListener 추가
        ready.setFont(new Font("HY견고딕", Font.PLAIN, 20)); // 준비 완료 버튼의 폰트 설정 | 폰트, 크기 설정
        ready.setPreferredSize(new Dimension(150, 40)); // 준비 완료 버튼의 크기 설정 | 가로, 세로 크기 설정

        /*
         * 가위, 바위, 보 버튼 설정
         * 반복문 사용 | 가위, 바위, 보 버튼의 폰트, 크기, 크기 설정, ActionListener 추가
         */
        for (int i = 0; i < rpsBtnp.length; i++) {
            rpsBtnp[i] = new JButton("");
            rpsBtnp[i].setIcon(win.util.icon[i]);
            rpsBtnp[i].addActionListener(this);
            rpsBtnp[i].setFont(new Font("HY견고딕", Font.PLAIN, 20));
            rpsBtnp[i].setPreferredSize(new Dimension(80, 80));
        }

        /*
         * 다시하기, 나가기 버튼 설정
         * 반복문 사용 | 다시하기, 나가기 버튼의 폰트, 크기, 크기 설정, ActionListener 추가
         */
        for (int i = 0; i < rtNex.length; i++) {
            rtNex[i] = new JButton(str2[i]);
            rtNex[i].addActionListener(this);
            rtNex[i].setFont(new Font("HY견고딕", Font.PLAIN, 20));
            rtNex[i].setPreferredSize(new Dimension(150, 40));
        }

        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0)); // RpsButtonPan의 레이아웃 설정 | FlowLayout 사용, 가로, 세로 간격 설정
        setMaximumSize(new Dimension(Define.MAX_WIDTH, 100)); // RpsButtonPan의 크기 설정 | 가로, 세로 크기 설정
        this.change("ready"); // RpsButtonPan의 레이아웃 설정 | 패널의 내용 변경 | 준비 완료 버튼, 나가기 버튼 추가
    }

    /*
     * 패널의 내용 변경
     * 매개변수 str의 값에 따라 패널의 내용 변경
     * str = "ready" : 준비 완료 버튼, 나가기 버튼 추가
     * str = "start" : 가위, 바위, 보 버튼 추가
     * str = "end" : 다시하기, 나가기 버튼 추가
     */
    public void change(String str) {

        /*
         * removeAll() : 패널의 내용을 모두 삭제
         * add() : 패널에 컴포넌트 추가
         * updateUI() : 패널의 내용을 변경
         * str.equals() : str의 값이 매개변수와 같은지 비교
         */
        if (str.equals("ready")) {
            removeAll();
            add(ready); // 준비 완료 버튼 추가
            add(rtNex[1]); // 나가기 버튼 추가
            updateUI();
        } else if (str.equals("start")) {
            removeAll();
            add(rpsBtnp[0]); // 가위 버튼 추가
            add(rpsBtnp[1]); // 바위 버튼 추가
            add(rpsBtnp[2]); // 보 버튼 추가
            updateUI();
        } else if (str.equals("end")) {
            removeAll();
            add(rtNex[0]); // 다시하기 버튼 추가
            add(rtNex[1]); // 나가기 버튼 추가
            updateUI();
        }
    }

    /*
     * 가위 바위 보 게임
     * 매개변수 user, com의 값에 따라 게임 결과 출력
     * user = com : 비김
     * user = 0, com = 1 || user = 1, com = 2 || user = 2, com = 0 : 짐
     * user = 0, com = 2 || user = 1, com = 0 || user = 2, com = 1 : 이김
     * 매개변수 user : 사용자가 선택한 가위, 바위, 보
     * 매개변수 com : 컴퓨터가 선택한 가위, 바위, 보
     * 매개변수 user, com의 값은 Define 클래스의 상수 사용
     */
    private final void rpsgame(int user, int com) {
        if (user == com) {
            System.out.println("Tie.");
            win.setLabel("비겼습니다"); // Display_Panel 클래스의 메소드 사용 | 문자열의 내용 변경
            change("end"); // 패널의 내용 변경 | 다시하기, 나가기 버튼 추가
        } else if (user == 0 && com == 1 || user == 1 && com == 2 || user == 2 && com == 0) {
            System.out.println("Lose.");
            win.setLabel("당신이 졌습니다"); // Display_Panel 클래스의 메소드 사용 | 문자열의 내용 변경
            change("end"); // 패널의 내용 변경 | 다시하기, 나가기 버튼 추가
        } else if (user == 0 && com == 2 || user == 1 && com == 0 || user == 2 && com == 1) {
            System.out.println("Win.");
            win.setLabel("당신이 이겼습니다"); // Display_Panel 클래스의 메소드 사용 | 문자열의 내용 변경
            change("end"); // 패널의 내용 변경 | 다시하기, 나가기 버튼 추가
        }
    }

    /*
     * 묵 찌 빠 게임
     * 매개변수 user, com의 값에 따라 게임 결과 출력
     * 매개변수 atk의 값은 "U", "C" 사용
     * atk이 "U"면 "사용자가 공격" | atk이 "C"면 "컴퓨터가 공격"
     * atk이 "U"이고 user == com 이면 사용자 승리
     * atk이 "C"이고 user == com 이면 컴퓨터 승리
     * 매개변수 user : 사용자가 선택한 가위, 바위, 보
     * 매개변수 com : 컴퓨터가 선택한 가위, 바위, 보
     * 매개변수 user, com의 값은 Define 클래스의 상수 사용
     * 매개변수 atk : 사용자가 공격, 컴퓨터가 공격
     */
    private final void mjbgame(int user, int com) {

        /*
         * 사용자 승리 조건
         */
        if (atk.equals("U")) {
            if (user == com) {
                System.out.println("Win"); // "Win" 출력
                System.out.println("Atk : " + atk); // "Atk : U" 출력
                win.setLabel("당신이 이겼습니다"); // Display_Panel 클래스의 메소드 사용 | 문자열의 내용 변경
                this.timer.stop(); // 타이머 중지
                change("end"); // 패널의 내용 변경 | 다시하기, 나가기 버튼 추가
            } else if (user == Define.PAPER && com == Define.ROCK || user == Define.ROCK && com == Define.SCISSORS
                    || user == Define.SCISSORS && com == Define.PAPER) {
                this.atk = "U"; // atk의 값을 "U"로 변경 | 사용자가 공격
                this.count = 3; // count의 값을 3으로 변경 | 타이머의 시간을 3초로 변경
                this.content.countdown.setText(String.valueOf(count)); // ContentPanel 클래스의 메소드 사용 | 문자열의 내용 변경
                System.out.println("Continue"); // "Continue" 출력
            } else if (user == Define.PAPER && com == Define.SCISSORS || user == Define.ROCK && com == Define.PAPER
                    || user == Define.SCISSORS && com == Define.ROCK) {
                this.atk = "C"; // atk의 값을 "C"로 변경 | 컴퓨터가 공격
                this.count = 3; // count의 값을 3으로 변경 | 타이머의 시간을 3초로 변경
                this.content.countdown.setText(String.valueOf(count)); // ContentPanel 클래스의 메소드 사용 | 문자열의 내용 변경
                System.out.println("Continue"); // "Continue" 출력
            }
        } else if (atk.equals("C")) {
            if (user == com) {
                System.out.println("Lose"); // "Lose" 출력
                System.out.println("Atk : " + atk); // "Atk : C" 출력
                win.setLabel("당신이 졌습니다"); // Display_Panel 클래스의 메소드 사용 | 문자열의 내용 변경
                this.timer.stop(); // 타이머 중지
                change("end"); // 패널의 내용 변경 | 다시하기, 나가기 버튼 추가
            } else if (user == Define.PAPER && com == Define.ROCK || user == Define.ROCK && com == Define.SCISSORS
                    || user == Define.SCISSORS && com == Define.PAPER) {
                this.atk = "U"; // atk의 값을 "U"로 변경 | 사용자가 공격
                this.count = 3; // count의 값을 3으로 변경 | 타이머의 시간을 3초로 변경
                this.content.countdown.setText(String.valueOf(count)); // ContentPanel 클래스의 메소드 사용 | 문자열의 내용 변경
                System.out.println("Continue");
            } else if (user == Define.PAPER && com == Define.SCISSORS || user == Define.ROCK && com == Define.PAPER
                    || user == Define.SCISSORS && com == Define.ROCK) {
                this.atk = "C"; // atk의 값을 "C"로 변경 | 컴퓨터가 공격
                this.count = 3; // count의 값을 3으로 변경 | 타이머의 시간을 3초로 변경
                this.content.countdown.setText(String.valueOf(count)); // ContentPanel 클래스의 메소드 사용 | 문자열의 내용 변경
                System.out.println("Continue"); // "Continue" 출력
            }
        }

    }

    /*
     * 묵 찌 빠 게임 시작 시 타이머 시작
     * 타이머의 시간을 3초로 설정
     * 1초마다 count의 값을 1씩 감소
     * count의 값이 0외 되면 타이머 중지와 함쎄 게임 종료
     * 동시에 "Time Out" 메세지 출력
     */
    private void startGame() {
        count = 3;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(count); // count의 값 출력
                count--; // count의 값을 1씩 감소
                content.countdown.setText(String.valueOf(count)); // ContentPanel 클래스의 메소드 사용 | 문자열의 내용 변경

                if (count == 0) {
                    System.out.println("Time Out"); // "Time Out" 출력
                    win.setLabel("시간 초과"); // Display_Panel 클래스의 메소드 사용 | 문자열의 내용 변경
                    change("end"); // 패널의 내용 변경 | 다시하기, 나가기 버튼 추가
                    timer.stop(); // 타이머 중지
                }
            }
        });
    }

    /*
     * 결과 출력
     */
    public void result(int user) {
        int com = random.nextInt(3);

        System.out.println("user : " + user + " com : " + com);
        content.setIconlabel(user, com); // ContentPanel 클래스의 메소드 사용 | 사용자, 컴퓨터가 선택한 가위, 바위, 보 이미지 출력
        if (gamename.equals("가위 바위 보"))
            this.rpsgame(user, com); // 가위 바위 보 게임
        else if (gamename.equals("묵 찌 빠"))
            this.mjbgame(user, com); // 묵 찌 빠 게임

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ready) {
            System.out.println("Ready"); // "Ready" 출력
            if (gamename.equals("가위 바위 보")) {
                win.setLabel("선택 하세요"); // Display_Panel 클래스의 메소드 사용 | 문자열의 내용 변경
            } else if (gamename.equals("묵 찌 빠")) {
                win.setLabel("3초 내로 선택하세요"); // Display_Panel 클래스의 메소드 사용 | 문자열의 내용 변경
                count = 3; // count의 값을 3으로 변경 | 타이머의 시간을 3초로 변경
                this.content.countdown.setText(String.valueOf(count)); // ContentPanel 클래스의 메소드 사용 | 문자열의 내용 변경
                timer.start(); // 타이머 시작
            }
            change("start"); // 패널의 내용 변경 | 가위, 바위, 보 버튼 추가
        }

        if (e.getSource() == rpsBtnp[0]) {
            System.out.println("Scissors"); // "Scissors" 출력
            result(Define.SCISSORS); // 결과 출력
        } else if (e.getSource() == rpsBtnp[1]) {
            System.out.println("Rock"); // "Rock" 출력
            result(Define.ROCK); // 결과 출력
        } else if (e.getSource() == rpsBtnp[2]) {
            System.out.println("Paper"); // "Paper" 출력
            result(Define.PAPER); // 결과 출력
        }

        if (e.getSource() == rtNex[0]) {
            System.out.println("Retry"); // "Retry" 출력
            win.setLabel("준비 되셨습니까?"); // Display_Panel 클래스의 메소드 사용 | 문자열의 내용 변경
            if (gamename.equals("묵 찌 빠")) {
                this.atk = "U"; // atk의 값을 "U"로 변경 | 사용자가 공격
                count = 3; // count의 값을 3으로 변경 | 타이머의 시간을 3초로 변경
                content.setIconlabel(Define.CLEAR, Define.CLEAR); // ContentPanel 클래스의 메소드 사용 | 사용자, 컴퓨터가 선택한 가위, 바위, 보
                                                                  // 이미지 초기화
                content.countdown.setText(""); // ContentPanel 클래스의 메소드 사용 | 문자열의 내용 변경
            }
            change("ready"); // 패널의 내용 변경 | 준비 완료 버튼, 나가기 버튼 추가
        } else if (e.getSource() == rtNex[1]) {
            System.out.println("Exit"); // "Exit" 출력
            this.timer = null; // 타이머 초기화
            win.change("MainWindow");
        }
    }

}

/*
 * ContentPanel 클래스
 */
class ContentPanel extends JPanel {
    private Display_Panel win; // Display_Panel 클래스
    private int connum = 0; // 가위 바위 보 게임에서 사용 | 가위 바위 보 게임에서 사용자, 컴퓨터가 선택한 가위, 바위, 보 이미지 출력을 위해 필요
    private JLabel iconlabel = new JLabel(""); // 가위 바위 보 게임에서 사용 | 컴퓨터가 선택한 가위, 바위, 보 이미지 출력을 위해 필요
    private JLabel usericonlabel = new JLabel(""); // 가위 바위 보 게임에서 사용 | 사용자가 선택한 가위, 바위, 보 이미지 출력을 위해 필요
    public JLabel countdown = new JLabel(""); // 묵 찌 빠 게임에서 사용 | 타이머의 시간 출력을 위해 필요

    public void setIconlabel(int user, int com) {
        if (user != Define.CLEAR && com != Define.CLEAR) {
            this.usericonlabel.setIcon(win.util.icon[user]); // 사용자가 선택한 가위, 바위, 보 이미지 출력
            this.iconlabel.setIcon(win.util.icon[com]); // 컴퓨터가 선택한 가위, 바위, 보 이미지 출력
        } else if (user == Define.CLEAR && com == Define.CLEAR) {
            this.usericonlabel.setIcon(null); // 사용자가 선택한 가위, 바위, 보 이미지 초기화
            this.iconlabel.setIcon(null); // 컴퓨터가 선택한 가위, 바위, 보 이미지 초기화
        }
    }

    /*
     * 가위 바위 보 게임에서 사용 | 사용자, 컴퓨터가 선택한 가위, 바위, 보 이미지 출력
     */
    private Box box() {
        Box box = Box.createHorizontalBox(); // Box 생성

        if (this.connum == 0)
            box.add(this.usericonlabel); // 사용자가 선택한 가위, 바위, 보 이미지 출력
        else
            box.add(this.iconlabel); // 컴퓨터가 선택한 가위, 바위, 보 이미지 출력

        box.setBorder(BorderFactory.createBevelBorder(10)); // Box의 테두리 설정
        box.setBackground(Color.white); // Box의 배경색 설정
        box.setMaximumSize(new Dimension(80, 80)); // Box의 크기 설정
        box.setPreferredSize(new Dimension(80, 80)); // Box의 크기 설정
        box.setOpaque(true); // Box의 투명도 설정
        this.connum++; // connum의 값을 1 증가

        return box; // Box 반환
    }

    /*
     * 사용자, 컴퓨터 이름 출력
     */
    private Box Con(String user) {
        Box container = Box.createVerticalBox(); // Box 생성

        container.setAlignmentX(CENTER_ALIGNMENT); // Box의 정렬 설정
        container.setPreferredSize(new Dimension(150, 150)); // Box의 크기 설정
        container.setMaximumSize(new Dimension(150, 150)); // Box의 크기 설정

        JLabel label = new JLabel(user, SwingConstants.CENTER); // 사용자, 컴퓨터 이름 출력
        label.setFont(label.getFont().deriveFont(25.0f)); // 사용자, 컴퓨터 이름의 폰트 설정
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // 사용자, 컴퓨터 이름의 정렬 설정

        Box box = box(); // Box 생성

        container.add(label); // Box에 사용자, 컴퓨터 이름 추가
        container.add(Box.createVerticalStrut(10)); // Box에 사용자, 컴퓨터 이름과 가위 바위 보 이미지 사이의 간격 설정
        container.add(box); // Box에 가위 바위 보 이미지 추가

        return container; // Box 반환
    }

    /*
     * ContentPanel 클래스
     */
    public ContentPanel(Display_Panel win, String gamename) {
        this.win = win; // Display_Panel 클래스 설정

        setMaximumSize(new Dimension(Define.MAX_WIDTH, 150)); // ContentPanel의 크기 설정
        setOpaque(true); // ContentPanel의 투명도 설정

        countdown.setFont(new Font("HY견고딕", Font.PLAIN, 40)); // 타이머의 폰트 설정
        countdown.setPreferredSize(new Dimension(40, 100)); // 타이머의 크기 설정
        countdown.setForeground(Color.black); // 타이머의 글자색 설정

        add(Con("User")); // Con함수를 이용해 Box 생성 | 사용자 이름 출력 및 box 추가
        add(Box.createHorizontalStrut(30)); // 사용자 이름과 컴퓨터 이름 사이의 간격 설정
        add(countdown); // 타이머 추가 | 단, 묵 찌 빠 게임에서만 사용
        add(Box.createHorizontalStrut(30)); // 타이머와 가위 바위 보 이미지 사이의 간격 설정
        add(Con("Computer")); // Con함수를 이용해 Box 생성 | 컴퓨터 이름 출력 및 box 추가
    }
}

/*
 * RockPaperScissors 클래스
 */
class RockPaperScissors extends JPanel {
    private RpsButtonPan rpsButtonPan = null; // RpsButtonPan 클래스
    private JLabel title; // 게임 이름 출력
    public JLabel result = new JLabel("준비 되셨습니까?"); // 게임 결과 출력
    public JLabel timeout; // 타이머 출력
    private ContentPanel content = null; // ContentPanel 클래스

    final void SetTitle(String str) {
        title = new JLabel(str); // 게임 이름 출력
        title.setFont(new Font("HY견고딕", Font.BOLD, 30)); // 게임 이름의 폰트 설정
        title.setForeground(new Color(41, 158, 57)); // 게임 이름의 글자색 설정
        title.setBackground(Color.white); // 게임 이름의 배경색 설정
        title.setMaximumSize(new Dimension(230, 50)); // 게임 이름의 크기 설정
        title.setAlignmentX(CENTER_ALIGNMENT); // 게임 이름의 정렬 설정
        title.setHorizontalAlignment(SwingConstants.CENTER); // 게임 이름의 정렬 설정
        title.setOpaque(true); // 게임 이름의 투명도 설정
    }

    /*
     * RockPaperScissors 클래스 생성자
     */
    public RockPaperScissors(Display_Panel win, String gamename) {
        this.title = new JLabel(gamename); // 게임 이름 출력
        this.content = new ContentPanel(win, gamename); // ContentPanel 클래스 설정
        this.rpsButtonPan = new RpsButtonPan(win, content, gamename); // RpsButtonPan 클래스 설정

        SetTitle(gamename); // 게임 이름 출력

        result.setFont(new Font("HY견고딕", Font.PLAIN, 40)); // 게임 결과의 폰트 설정
        result.setForeground(Color.black); // 게임 결과의 글자색 설정
        result.setAlignmentX(CENTER_ALIGNMENT); // 게임 결과의 정렬 설정

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // RockPaperScissors의 레이아웃 설정 | BoxLayout 사용
        add(Box.createVerticalStrut(30)); // RockPaperScissors의 상단과 게임 이름 사이의 간격 설정
        add(title); // 게임 이름 추가
        add(Box.createVerticalStrut(30)); // 게임 이름과 게임 결과 사이의 간격 설정
        add(content); // ContentPanel 클래스 추가
        add(Box.createVerticalStrut(20)); // ContentPanel 클래스와 게임 결과 사이의 간격 설정
        add(result); // 게임 결과 추가
        add(Box.createVerticalStrut(20)); // 게임 결과와 RpsButtonPan 클래스 사이의 간격 설정
        add(rpsButtonPan); // RpsButtonPan 클래스 추가
    }
}

/*
 * Display_Panel 클래스
 */
class Display_Panel extends JFrame {
    public MainWindow mainWindow = null; // MainWindow 클래스
    public RockPaperScissors rps1 = null; // RockPaperScissors 클래스
    public RockPaperScissors rps2 = null; // RockPaperScissors 클래스
    public Define util = new Define(); // Define 클래스
    private String sel; // 패널의 이름

    /*
     * Display_Panel 클래스 생성자
     * Define 클래스의 메소드 사용 | 이미지 아이콘 설정
     */
    public Display_Panel() {
        util.setIcon();
    }

    /*
     * 패널의 내용 변경
     * 매개변수 panelname의 값에 따라 패널의 내용 변경
     */
    public void change(String panelname) {
        if (panelname.equals("MainWindow")) {
            this.sel = "Main"; // 패널의 이름 설정
            getContentPane().removeAll(); // 패널의 내용을 모두 삭제
            getContentPane().add(mainWindow); // 패널에 mainWindow 추가
            revalidate(); // 패널의 내용을 변경
            repaint(); // 패널의 내용을 변경
        } else if (panelname.equals("RPS1")) {
            this.sel = "RPS1"; // 패널의 이름 설정
            rps1 = new RockPaperScissors(this, "가위 바위 보"); // RockPaperScissors 클래스 설정 | 가위 바위 보 게임
            getContentPane().removeAll(); // 패널의 내용을 모두 삭제
            getContentPane().add(rps1); // 패널에 rps1 추가
            revalidate(); // 패널의 내용을 변경
            repaint(); // 패널의 내용을 변경
        } else if (panelname.equals("RPS2")) {
            this.sel = "RPS2"; // 패널의 이름 설정
            rps2 = new RockPaperScissors(this, "묵 찌 빠"); // RockPaperScissors 클래스 설정 | 묵찌빠 게임
            getContentPane().removeAll(); // 패널의 내용을 모두 삭제
            getContentPane().add(rps2); // 패널에 rps2 추가
            revalidate(); // 패널의 내용을 변경
            repaint(); // 패널의 내용을 변경
        }
    }

    /*
     * Display_Panel 클래스의 메소드
     * 매개변수 str의 값에 따라 문자열의 내용 변경
     */
    public void setLabel(String str) {
        if (sel.equals("RPS1"))
            rps1.result.setText(str); // RPS1 패널의 문자열의 내용 변경
        else if (sel.equals("RPS2"))
            rps2.result.setText(str); // RPS2 패널의 문자열의 내용 변경
    }
}

/*
 * MainWindow 클래스
 * 게임 선택 화면
 * 가위 바위 보, 묵 찌 빠 게임 선택
 */
public class Main extends JFrame {

    public static void main(String[] args) {
        Display_Panel win = new Display_Panel(); // Display_Panel 클래스 생성

        win.setTitle("미니 게임"); // Display_Panel 클래스의 메소드 사용 | 게임 이름 설정
        win.mainWindow = new MainWindow(win); // MainWindow 클래스 설정

        win.add(win.mainWindow); // Display_Panel 클래스에 mainWindow 추가
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Display_Panel 클래스의 메소드 사용 | 프로그램 종료 시 프로그램 종료
        win.setSize(Define.MAX_WIDTH, Define.MAX_HEIGHT); // Display_Panel 클래스의 메소드 사용 | 프로그램의 크기 설정
        win.setVisible(true); // Display_Panel 클래스의 메소드 사용 | 프로그램 실행 시 프로그램 실행
        win.setResizable(false); // Display_Panel 클래스의 메소드 사용 | 프로그램의 크기 변경 불가

    }

}
