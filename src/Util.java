import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Util extends JFrame {
    JFrame frame = new JFrame();

    public void Main_clicks() {
        new Main_Util();
        new RPS_Util();
    }

    public static class Main_Util extends JFrame implements ActionListener {
        JButton rpS = new JButton("가위 바위 보");
        JButton mJB = new JButton("묵 찌 빠");

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == rpS) {
                System.out.println("가위 바위 보");
                Main_Window.mainPan.removeAll();
                new RockPaperScissors("가위 바위 보");
                Main_Window.mainPan.updateUI();

            } else if (e.getSource() == mJB) {
                System.out.println("묵 찌 빠");
            }
            // }
            // public void main_click() {
            // rpS.addActionListener(new ActionListener() {

            // @Override
            // public void actionPerformed(ActionEvent e) {
            // setVisible(false);
            // Main_Window.mainPan.removeAll();
            // new RockPaperScissors("가위 바위 보");
            // Main_Window.mainPan.updateUI();
            // }

            // });

            // mJB.addActionListener(new ActionListener() {

            // @Override
            // public void actionPerformed(ActionEvent e) {
            // setVisible(false);
            // }

            // });
            // }
        }
    }

    public static class RPS_Util extends JFrame implements ActionListener {
        JButton rock = new Button("바위");
        JButton paper = new Button("보");
        JButton scissors = new Button("가위");

        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            if (e.getSource() == rock) {
                System.out.println("바위");
            } else if (e.getSource() == paper) {
                System.out.println("보");
            } else if (e.getSource() == scissors) {
                System.out.println("가위");
            }
            if (btn.getActionCommand().equals("준비 완료")) {
                System.out.println("I'm Ready");
            }
            if (btn.getActionCommand().equals("다시하기")) {
                System.out.println("Retry");
            } else if (btn.getActionCommand().equals("나가기"))
                System.out.println("Exit");
        }

        // public void rps_click() {

        // rock.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // System.out.println("바위");

        // if(e.getSource() == rock){

        // }else if(e.getSource() == paper)
        // }
        // });
        // paper.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // System.out.println("보");
        // }
        // });
        // scissors.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // System.out.println("가위");
        // }
        // });
        // }

    }

}

class Button extends JButton {
    public Button(String str) {
        super(str);
        setFont(getFont().deriveFont(20.0f));
        setBackground(Color.white);
        setMaximumSize(new Dimension(80, 80));
    }
}