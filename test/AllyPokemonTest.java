import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the AllPokemon Class
 */
class AllyPokemonTest {


    /**
     * Test the expected level of a pokemon corresponds to his actual level
     */
    @org.junit.jupiter.api.Test
    void assertThatExpectedLevelIsEqualToActualLevel() {
        FireType charmander = new FireType(5);
        assertEquals(charmander.getLevel(), 5);
    }

    /**
     * Test that the expected level setted up corresponds to his new level
     */
    @org.junit.jupiter.api.Test
    void assertThatSetLevelActuallySetPokemonLevel() {
        FireType charmander = new FireType(5);
        charmander.setLevel(10);
        assertEquals(charmander.getLevel(), 10);
    }

    /**
     * test that the function getLevel makes the pokemon getting a superior level
     */
    @org.junit.jupiter.api.Test
    void assertThatCharmanderLevelUp() {
        FireType charmander = new FireType(9);
        charmander.levelUp();
        assertEquals(charmander.getLevel(), 10);
    }

    /**
     * Test that a pokemon attack has the right name
     */
    @org.junit.jupiter.api.Test
    void assertThatCharmanderAttackHasTheRightName(){
        FireType charmander = new FireType(5);
        assertEquals(charmander.getAttackName(), "Flameech");
    }

    /**
     * Test that the ally pokemon has the good Health Points remaining after he took an ennemy attack
     */
    @org.junit.jupiter.api.Test
    void assertThatAllyPokemonHasGoodHpRemaining(){
        GrassType turtwig = new GrassType(5);
        EnemyPokemon zubat = new EnemyPokemon(PokemonList.ZUBAT);
        while(turtwig.getLostHp() != 1){
            zubat.attack(turtwig);
        }
        assertEquals(zubat.getAttackDmg(), turtwig.getLostHp());
    }
}