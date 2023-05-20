import javax.swing.*;

import java.awt.Dimension;

class Define {
    public static final int MAX_WIDTH = 500;
    public static final int MAX_HEIGHT = 500;
}
public class Main_Window extends JFrame {
    // Interface myPan1 = new JPanel();
    // JPanel mainPain = myPan1.getPanel(); 
    public static JPanel mainPan = new JPanel();
    Util.Main_Util util = new Util.Main_Util();
    JLabel sel_Game = new JLabel("Select Game");

    public Main_Window(String str) {
        super(str);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        util.main_click();

        Box buttonBox = Box.createHorizontalBox();
        Box labelBox = Box.createHorizontalBox();

        sel_Game.setFont(sel_Game.getFont().deriveFont(30.0f));
        labelBox.add(sel_Game);

        buttonBox.add(util.rpS).setMaximumSize(new Dimension(150, 150));
        buttonBox.add(Box.createHorizontalStrut(50));
        buttonBox.add(util.mJB).setMaximumSize(new Dimension(150, 150));

        mainPan.setLayout(new BoxLayout(mainPan, BoxLayout.Y_AXIS));
        mainPan.add(Box.createVerticalStrut(50));
        mainPan.add(labelBox);
        mainPan.add(buttonBox);

        add(mainPan);   
        
        setResizable(false);
        setSize(Define.MAX_WIDTH, 500);
        setVisible(true);
    }
}
