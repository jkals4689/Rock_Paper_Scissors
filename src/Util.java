import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Util extends JFrame {
    JFrame frame = new JFrame();
    JButton rpS = new JButton("가위 바위 보");
    JButton mJB = new JButton("묵 찌 빠");
    // JPanel mainPan = Main_Window.mainPan;

    public void click() {
        rpS.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main_Window.mainPan.removeAll();
                new RockPaperScissors("가위 바위 보");
                Main_Window.mainPan.updateUI();
            }

        });

        mJB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }

        });
    }
}