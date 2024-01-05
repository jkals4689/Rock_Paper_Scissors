package com.rock_paper_scissors.panels;

import com.rock_paper_scissros.define.SetImgIcon;

import javax.swing.*;

public class DisplayPanel extends JFrame {
    public MainWindow mainWindow = null; // 메인 화면
    private String panelName;

    public DisplayPanel() {
        SetImgIcon.setIcon();
    }

    public static void change(String panelName) {
    }

    public void setPanelName(String str) {
        this.panelName = str;
    }

    public String getPanelName() {
        return this.panelName;
    }
}
