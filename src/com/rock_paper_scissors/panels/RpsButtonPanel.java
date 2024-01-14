package com.rock_paper_scissors.panels;

import com.rock_paper_scissors.Define;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RpsButtonPanel extends JPanel implements ActionListener {
    private JButton ready = new JButton("준비 완료");
    private JButton rpsBtnp[] = new JButton[3];
    private JButton rtNex[] = new JButton[2];
    private String[] str2 = {"다시하기", "나가기"};
    private Random random = new Random();
    private ContentPanel content;
    private DisplayPanel win;
    private String gameName;
    private String atk = "U";
    private Timer timer;
    private int count;

    public RpsButtonPanel(DisplayPanel win, ContentPanel content, String gameName) {
        this.win = win;
        this.content = content;
        this.gameName = gameName;
        this.startGame();
        setBackground(Color.lightGray);

        ready.addActionListener(this);
        ready.setBackground(Color.white);
        ready.setFont(new Font("HY견고딕", Font.PLAIN, 20));
        ready.setPreferredSize(new Dimension(150, 40));

        for (int i = 0; i < rpsBtnp.length; i++) {
            rpsBtnp[i] = new JButton("");
            rpsBtnp[i].setIcon(Define.getImageIcon(i));
            rpsBtnp[i].addActionListener(this);
            rpsBtnp[i].setFont(new Font("HY견고딕", Font.PLAIN, 20));
            rpsBtnp[i].setPreferredSize(new Dimension(80, 80));
        }

        for (int i = 0; i < rtNex.length; i++) {
            rtNex[i] = new JButton(str2[i]);
            rtNex[i].addActionListener(this);
            rtNex[i].setBackground(Color.white);
            rtNex[i].setFont(new Font("HY견고딕", Font.PLAIN, 20));
            rtNex[i].setPreferredSize(new Dimension(80, 80));
        }

        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        setMaximumSize(new Dimension(Define.MAX_WIDTH, 100));
        this.change("ready");
    }

    private void change(String string) {
        switch (string) {
            case "ready" -> {
                removeAll();
                add(ready);
                add(rtNex[1]);
                updateUI();
            }
            case "start" -> {
                removeAll();
                add(rpsBtnp[0]);
                add(rpsBtnp[1]);
                add(rpsBtnp[2]);
                updateUI();
            }
            case "end" -> {
                removeAll();
                add(rtNex[0]);
                add(rtNex[1]);
                updateUI();
            }
        }
    }

    private void rpsGame(int user, int com) {
        if (user == com) {
            System.out.println("Tie.");
            RockPaperScissors.result.setText("비겼습니다.");
            change("end");
        } else if (user == 0 && com == 1 || user == 1 && com == 2 || user == 2 && com == 0) {
            System.out.println("Lose.");
            RockPaperScissors.result.setText("당신지 졌습니다.");
            change("end");
        } else if (user == 0 && com == 2 || user == 1 && com == 0 || user == 2 && com == 1) {
            System.out.println("Win.");
            RockPaperScissors.result.setText("당신이 이겼습니다.");
            change("end");
        }
    }

    private void mjbGame(int user, int com) {
        if (atk.equals("U")) {
            if (user == com) {
                System.out.println("Win"); // "Win" 출력
                System.out.println("Atk : " + atk); // "Atk : U" 출력
                win.setLabel("당신이 이겼습니다"); // Display_Panel 클래스의 메소드 사용 | 문자열의 내용 변경
                this.timer.stop(); // 타이머 중지
                change("end"); // 패널의 내용 변경 | 다시하기, 나가기 버튼 추가
            } else if (user == 2 && com == 1 || user == 1 && com == 0 || user == 0 && com == 2) {
                this.atk = "U"; // atk의 값을 "U"로 변경 | 사용자가 공격
                this.count = 3; // count의 값을 3으로 변경 | 타이머의 시간을 3초로 변경
                this.content.countdown.setText(String.valueOf(count)); // ContentPanel 클래스의 메소드 사용 | 문자열의 내용 변경
                System.out.println("Continue"); // "Continue" 출력
            } else if (user == 2 && com == 0 || user == 1 && com == 2 || user == 0 && com == 1) {
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
            } else if (user == 2 && com == 1 || user == 1 && com == 0 || user == 0 && com == 2) {
                this.atk = "U"; // atk의 값을 "U"로 변경 | 사용자가 공격
                this.count = 3; // count의 값을 3으로 변경 | 타이머의 시간을 3초로 변경
                this.content.countdown.setText(String.valueOf(count)); // ContentPanel 클래스의 메소드 사용 | 문자열의 내용 변경
                System.out.println("Continue");
            } else if (user == 2 && com == 0 || user == 1 && com == 2 || user == 0 && com == 1) {
                this.atk = "C"; // atk의 값을 "C"로 변경 | 컴퓨터가 공격
                this.count = 3; // count의 값을 3으로 변경 | 타이머의 시간을 3초로 변경
                this.content.countdown.setText(String.valueOf(count)); // ContentPanel 클래스의 메소드 사용 | 문자열의 내용 변경
                System.out.println("Continue"); // "Continue" 출력
            }
        }
    }

    private void startGame() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
