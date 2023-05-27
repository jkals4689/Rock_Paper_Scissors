import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

class Define {
    public static final int MAX_WIDTH = 500;
    public static final int MAX_HEIGHT = 500;
}


public class Main extends JFrame {

    Main() {
        super("미니 게임");
        add(new MainWindow());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Define.MAX_WIDTH, Define.MAX_HEIGHT);
        setVisible(true);
        setResizable(false);

    }
    public static void main(String[] args) {
        new Main();
    }

}
