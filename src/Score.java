import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Score {
    private String playerName;
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

    public int getWinStreak() {
        return winStreak;
    }

    public void setWinStreak(int winStreak) {
        this.winStreak = winStreak;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void addPlayerToFile() throws IOException {
        try {
            FileWriter scoreFile = new FileWriter("scoreboard.txt", true);
            scoreFile.write(this.playerName + "   " + this.score + "\n");
            scoreFile.close();
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
