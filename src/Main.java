import com.rock_paper_scissors.panels.DisplayPanel;
import com.rock_paper_scissors.panels.MainWindow;
import com.rock_paper_scissors.Define;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        DisplayPanel win = new DisplayPanel();

        win.setTitle("미니 게임");
        win.mainWindow = new MainWindow(win);

        win.add(win.mainWindow);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setSize(Define.MAX_WIDTH, Define.MAX_HEIGHT);
        win.setVisible(true);
        win.setResizable(false);
    }
}
