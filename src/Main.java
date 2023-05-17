import java.util.Random;

import javax.swing.JFrame;

class RandomInt {
    public int generateRandomNumber() {
        Random rand = new Random();
        int number = rand.nextInt(3);
        return number;
    }
}

public class Main {
    public static void main(String[] args) {
        new Main_Window("Mini Game");
    }

}
