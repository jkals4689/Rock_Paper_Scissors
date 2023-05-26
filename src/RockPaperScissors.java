import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissors extends JPanel {
    private JButton btn = new JButton("준비 완료");
    private Panels pan = new Panels();

    public RockPaperScissors(String gamename) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(30));
        add(pan.titlePan(gamename));
        add(Box.createVerticalStrut(20));
        add(pan.contentPan());
        add(btn);

    }

    // public void actionPerformed(ActionEvent e) {
    //     if (btn.getActionCommand().equals("준비 완료"))
    //         win.change("MainWindow");
    // }
}