import javax.swing.*;
import java.awt.Dimension;

public class TwoRockPaperScissors extends JFrame {
    TwoRockPaperScissors(String str) {
        super(str);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        setResizable(false);
        setSize(500, 500);
        setVisible(true);
    }
}
