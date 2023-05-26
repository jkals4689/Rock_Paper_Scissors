import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Util extends JFrame {
    JFrame frame = new JFrame();
    public MainWindow mainWindow = new MainWindow();
    public RockPaperScissors rps = new RockPaperScissors(null);

    public void Util() {
        new Main_Util();
    }

    static class Main_Util extends JFrame implements ActionListener {
        RockPaperScissors rps = new RockPaperScissors(null);
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            if (btn.getActionCommand().equals("가위 바위 보")) {
                System.out.println("가위 바위 보");
                getContentPane().removeAll();
                getContentPane().add(rps);
                revalidate();
                repaint();
            } else if (btn.getActionCommand().equals("묵 찌 빠"))
                System.out.println("묵 찌 빠");
        }
    }

    // public static class Main_Util extends JFrame implements ActionListener {
    // JButton rpS = new JButton("가위 바위 보");
    // JButton mJB = new JButton("묵 찌 빠");

    // public void actionPerformed(ActionEvent e) {
    // if (e.getSource() == rpS) {
    // System.out.println("가위 바위 보");

    // Main_Window.mainPan.removeAll();
    // new RockPaperScissors_old("가위 바위 보");
    // Main_Window.mainPan.updateUI();

    // } else if (e.getSource() == mJB) {
    // System.out.println("묵 찌 빠");
    // }
    // }
    // }

    // public static class RPS_Util extends JFrame implements ActionListener {
    // JButton rock = new Button("바위");
    // JButton paper = new Button("보");
    // JButton scissors = new Button("가위");
    // int num = 1;

    // public void actionPerformed(ActionEvent e) {
    // JButton btn = (JButton) e.getSource();
    // JPanel pan = (JPanel)e.getSource();
    // System.out.println(pan);
    // if (btn.getActionCommand().equals("준비 완료")) {
    // System.out.println("I'm Ready");

    // }

    // if (e.getSource() == rock) {
    // System.out.println("바위");
    // new RpsButtonPan(2);
    // } else if (e.getSource() == paper) {
    // System.out.println("보");
    // num = 3;
    // } else if (e.getSource() == scissors) {
    // System.out.println("가위");
    // num = 3;

    // }

    // if (btn.getActionCommand().equals("다시하기")) {
    // System.out.println("Retry");
    // num = 1;
    // } else if (btn.getActionCommand().equals("나가기"))
    // System.out.println("Exit");
    // }
    // public void Panchange(String panname) {

    // }
    // }
}


// class Button extends JButton {
// public Button(String str) {
// super(str);
// setFont(getFont().deriveFont(20.0f));
// setBackground(Color.white);
// setMaximumSize(new Dimension(80, 80));
// }
// }