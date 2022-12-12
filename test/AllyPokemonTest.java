import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import static org.junit.Assert.*;

class AllyPokemonTest {

    @org.junit.jupiter.api.Test
    void assertThatExpectedLevelIsEqualToActualLevel() {
        int exeptedLevel = 5;
        FireType charmender = new FireType(exeptedLevel);
        int actualLevel = charmender.getLevel();
        assertEquals(exeptedLevel, actualLevel);
    }
}