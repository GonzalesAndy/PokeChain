import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your player name !");
        Score player = new Score(scanner.nextLine());
        Combat.start(player);
        System.exit(0);
    }
}
