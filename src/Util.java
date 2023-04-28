import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Util extends JFrame {
    JFrame frame = new JFrame();
    JButton rpS = new JButton("가위 바위 보");
    JButton mJB = new JButton("묵 찌 빠");

    public void click() {
        rpS.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new OneRockPaperScissors("가위 바위 보");
            }

        });

        mJB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TwoRockPaperScissors("묵찌빠");
            }

        });
    }
}
