import static org.junit.jupiter.api.Assertions.*;

class AllyPokemonTest {

    @org.junit.jupiter.api.Test
    void assertThatExpectedLevelIsEqualToActualLevel() {
        FireType charmander = new FireType(5);
        assertEquals(charmander.getLevel(), 5);
    }

    @org.junit.jupiter.api.Test
    void assertThatSetLevelActuallySetPokemonLevel() {
        FireType charmander = new FireType(5);
        charmander.setLevel(10);
        assertEquals(charmander.getLevel(), 10);
    }

    @org.junit.jupiter.api.Test
    void assertThatEnemyPokemonHaveHisLevel() {
        EnemyPokemon grumpig = new EnemyPokemon(PokemonList.GRUMPIG);
        assertEquals(grumpig.getLevel(), 7);
    }

    @org.junit.jupiter.api.Test
    void assertThatEnemyPokemonHaveHisName() {
        EnemyPokemon grumpig = new EnemyPokemon(PokemonList.GRUMPIG);
        assertEquals(grumpig.getName(), "GRUMPIG");
    }

    @org.junit.jupiter.api.Test
    void assertThatEnemyPokemonHaveHisHp() {
        EnemyPokemon melmetal = new EnemyPokemon(PokemonList.MELMETAL);
        assertEquals(melmetal.getHp(), melmetal.getLevel()*1.9);
    }

    @org.junit.jupiter.api.Test
    void assertThatMewTwoHaveInsaneDamage() {
        EnemyPokemon mewtwo = new EnemyPokemon(PokemonList.MEWTWO);
        assertEquals(mewtwo.getAttackDmg(), mewtwo.getLevel()*3);
    }
}