import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Score {
    private final String playerName;
    private int winStreak;
    private int score;

    /**
     * Class constructor of Score
     * @param playerName Name entered by the player when the game begin
     */
    public Score(String playerName) {
        this.playerName = playerName;
        this.winStreak = 0;
        this.score = 0;
    }

    /**
     * Increment score and winStreak by one when called
     * Increment score when winStreak pass 5 and 10
     */
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

    /**
     * Setter for winStreak
     * @param winStreak number of round played without using heal
     */
    public void setWinStreak(int winStreak) {
        this.winStreak = winStreak;
    }

    /**
     * Write score and player name associated in a txt file
     * @throws IOException Warn when an error occured while file write
     */
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

    /**
     * Verify if score txt file exist, if it doesn't, create one.
     * @param scoreFile txt file used to save scoreBoard
     */
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

    /**
     * Print a beautiful scoreboard sorted by highrst score to lowest one
     * @throws FileNotFoundException Error handling in case of inexisting score file
     */
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

    /**
     * Getters for score
     * @return score as an int
     */
    public int getScore() {
        return score;
    }
}
