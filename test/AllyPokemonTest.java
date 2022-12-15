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
    void assertThatCharmanderLevelUp() {
        FireType charmander = new FireType(9);
        charmander.levelUp();
        assertEquals(charmander.getLevel(), 10);
    }

    @org.junit.jupiter.api.Test
    void assertThatCharmanderAttackHasTheRightName(){
        FireType charmander = new FireType(5);
        assertEquals(charmander.getAttackName(), "Flameech");
    }

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