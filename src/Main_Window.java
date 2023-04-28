import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Window extends JFrame {
    Util util = new Util();

    JPanel pan = new JPanel();
    JPanel contentPanel = new JPanel();
    JLabel sel_Game = new JLabel("Select Game");

    public Main_Window(String str) {
        super(str);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        util.click();

        Box buttonBox = Box.createHorizontalBox();
        Box labelBox = Box.createHorizontalBox();

        sel_Game.setFont(sel_Game.getFont().deriveFont(30.0f));
        labelBox.add(sel_Game);

        buttonBox.add(util.rpS).setMaximumSize(new Dimension(150, 150));
        buttonBox.add(Box.createHorizontalStrut(50));
        buttonBox.add(util.mJB).setMaximumSize(new Dimension(150, 150));

        pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
        pan.add(Box.createVerticalStrut(50));
        pan.add(labelBox);
        pan.add(buttonBox);

        add(pan);

        setResizable(false);
        setSize(500, 500);
        setVisible(true);
    }
}
