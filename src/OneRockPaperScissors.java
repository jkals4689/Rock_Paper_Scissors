import javax.swing.JFrame;

public class OneRockPaperScissors extends JFrame {
    OneRockPaperScissors(String str) {
        super(str);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false);
        setSize(500, 500);
        setVisible(true);
    }
}
