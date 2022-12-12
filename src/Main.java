import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String playerUsername = "";
        do {
            System.out.println("Write your player name with a lenght less than 9 !");
            playerUsername = scanner.nextLine();
        } while (playerUsername.length() >=9);
        Score player = new Score(playerUsername);
        Score.showScoreboard();
        Combat.start(player);
        System.exit(0);
    }
}
