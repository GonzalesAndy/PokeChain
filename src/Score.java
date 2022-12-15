import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Score {
    private final String playerName;
    private int winStreak;
    private int score;

    public Score(String playerName) {
        this.playerName = playerName;
        this.winStreak = 0;
        this.score = 0;
    }

    public void addScore() {
        this.score += 1;
        this.winStreak += 1;
        if (winStreak >= 5) {
            this.score +=1;
            if (winStreak >= 10) {
                this.score += 3;
            }
        }
    }

    public void setWinStreak(int winStreak) {
        this.winStreak = winStreak;
    }

    public void addPlayerToFile() throws IOException {
        try {
            FileWriter scoreFile = new FileWriter("scoreboard.txt", true);
            scoreFile.write(this.score +"\n");
            scoreFile.write(this.playerName +"\n");
            scoreFile.close();
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static void fileExists(File scoreFile) {
        if (!scoreFile.exists()) {
            try {
                if(scoreFile.createNewFile())
                    System.out.println("Scoreboard File created !");
                else {
                    System.out.println("Failed to create Scoreboard File");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showScoreboard() throws FileNotFoundException {
        File scoreFile = new File("scoreboard.txt");
        fileExists(scoreFile);
        Scanner reader = new Scanner(scoreFile);
        SortedMap<Integer, String> scores = new TreeMap<>(Collections.reverseOrder());
        int i = 0;
        while (reader.hasNext()) {
            if (i%2 == 0) {
                scores.put(Integer.valueOf(reader.next()), String.format("%-9s",reader.next()));
            }
            ++i;
        }
        System.out.println(" __ Username ______ Score __");
        for (Map.Entry<Integer, String> entry : scores.entrySet()) {
            System.out.println("|   "+entry.getValue()+"          "+entry.getKey()+"   |");
        }
        System.out.println(" ___________________________");
    }
}
