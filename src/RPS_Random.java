import java.util.Random;

import javax.swing.JLabel;
import java.util.concurrent.TimeUnit;

public class RPS_Random extends JLabel {
    RandomInt random = new RandomInt();
    String[] RPS = { "가위", "바위", "보" };

    public RPS_Random(Boolean b) {
        if (b == true) {
            while (b != true) {
                try {
                    int number = random.generateRandomNumber();
                    setText(RPS[number]);
                    TimeUnit.MICROSECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // }
            // do {
            // int number = random.generateRandomNumber();
            // try {
            // TimeUnit.MICROSECONDS.sleep(100);
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
            // setText(RPS[number]);
            // } while (true);
        }
    }
}

class RandomInt {
    public int generateRandomNumber() {
        Random rand = new Random();
        int number = rand.nextInt(3);
        return number;
    }
}