package com.rock_paper_scissors;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Define {
    public static final int MAX_WIDTH = 500; // 프레임 너비
    public static final int MAX_HEIGHT = 500; // 프레임 높이
    public static final ImageIcon ROCK = new ImageIcon("img\\Rock.jpg");
    public static final ImageIcon PAPER = new ImageIcon("img\\Paper.jpg");
    public static final ImageIcon SCISSORS = new ImageIcon("img\\Scissors.jpg");
    public static final int CLEAR = -1;

    public static ImageIcon getImageIcon(int number) {
        if(number == 0) return ROCK;
        else if (number == 1) return PAPER;
        else if (number == 2) return SCISSORS;
        return null;
    }
}
