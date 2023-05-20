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

    public static class Main_Util extends JFrame {
        JButton rpS = new JButton("가위 바위 보");
        JButton mJB = new JButton("묵 찌 빠");

        public void main_click() {
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

    public static class RPS_Util extends JFrame {
        JButton rock = new Button("바위");
        JButton paper = new Button("보");
        JButton scissors = new Button("가위");
        public void rps_click() {
            rock.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    System.out.println("바위");
                }
            });
            paper.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    System.out.println("바위");
                }
            });
            scissors.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    System.out.println("바위");
                }
            });
        }


    }

}

class Button extends JButton {
    public Button(String str) {
        super(str);
        setFont(getFont().deriveFont(20.0f));
        setBackground(Color.white);
        setPreferredSize(new Dimension(80, 80));
    }
}