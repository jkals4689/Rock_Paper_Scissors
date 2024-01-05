package com.rock_paper_scissros.define;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Define {
    public static final int MAX_WIDTH = 500; // 프레임 너비
    public static final int MAX_HEIGHT = 500; // 프레임 높이
    public static final Map<Integer, ImageIcon> ROCK = new HashMap<Integer, ImageIcon>();
    public static final Map<Integer, ImageIcon> PAPER = new HashMap<Integer, ImageIcon>();
    public static final Map<Integer, ImageIcon> SCISSORS = new HashMap<Integer, ImageIcon>();
    public static final int CLEAR = -1;
}
