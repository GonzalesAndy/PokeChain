import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @org.junit.jupiter.api.Test
    void assertThatScoreWork(){
        Score scoreBoard = new Score("LUCAS18");
        for (int i=0; i<3; i++){
            scoreBoard.addScore();
        }
        assertEquals(scoreBoard.getScore(), 3); // 3 score points
    }

    @org.junit.jupiter.api.Test
    void assertThatWinSreakWork(){
        Score scoreBoard = new Score("LUCAS18");
        for (int i=0; i<5; i++){
            scoreBoard.addScore();
        }
        assertEquals(scoreBoard.getScore(), 6); // 5 score points + 1 from the 5 win streaks
    }

}