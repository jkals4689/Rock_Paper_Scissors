package com.rock_paper_scissros.define;

import javax.swing.*;

public class SetImgIcon {
    public void setIcon() {
        Define.ROCK.put(0, new ImageIcon("img\\Rock.jpg"));
        Define.PAPER.put(1, new ImageIcon("img\\Paper.jpg"));
        Define.SCISSORS.put(2, new ImageIcon("img\\Scissors.jpg"));
    }
}
