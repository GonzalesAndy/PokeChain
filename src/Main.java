import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Score.showScoreboard();
        Scanner scanner = new Scanner(System.in);
        String playerUsername = "";
        do {
            System.out.println("Write your player name with a lenght less than 9 !");
            playerUsername = scanner.nextLine();
        } while (playerUsername.length() >=9);
        Score player = new Score(playerUsername);
        Combat.start(player);
        System.exit(0);
    }
}
