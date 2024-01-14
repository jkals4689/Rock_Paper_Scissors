package com.rock_paper_scissors.panels;

import javax.swing.*;

public class DisplayPanel extends JFrame {
    public MainWindow mainWindow = null; // 메인 화면
    public RockPaperScissors rps1 = null;
    public RockPaperScissors rps2 = null;
    private String panelName;

    public DisplayPanel() {
    }

    public void change(String panelName) {
        if(panelName.equals("MainWindow")) {
            this.panelName = "Main";
            getContentPane().removeAll();
            getContentPane().add(mainWindow);
            revalidate();
            repaint();
        } else if (panelName.equals("RPS1")) {
            this.panelName = "RPS1";
            rps1 = new RockPaperScissors(this, "가위 바위 보");
            getContentPane().removeAll(); // 패널의 내용을 모두 삭제
            getContentPane().add(rps1); // 패널에 rps1 추가
            revalidate(); // 패널의 내용을 변경
            repaint(); // 패널의 내용을 변경
        } else if (panelName.equals("RPS2")) {
            this.panelName = "RPS2"; // 패널의 이름 설정
            rps2 = new RockPaperScissors(this, "묵 찌 빠"); // RockPaperScissors 클래스 설정 | 묵찌빠 게임
            getContentPane().removeAll(); // 패널의 내용을 모두 삭제
            getContentPane().add(rps2); // 패널에 rps2 추가
            revalidate(); // 패널의 내용을 변경
            repaint(); // 패널의 내용을 변경
        }
    }

    public void setLabel(String string) {
        if(panelName.equals("RPS1")) {
            rps1.result.setText(string);
        } else if(panelName.equals("RPS2"));
    }

    public void setPanelName(String str) {
        this.panelName = str;
    }

    public String getPanelName() {
        return this.panelName;
    }
}
