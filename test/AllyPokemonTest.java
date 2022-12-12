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
    void assertThatEnemyPokemonHasHisLevel() {
        EnemyPokemon grumpig = new EnemyPokemon(PokemonList.GRUMPIG);
        assertEquals(grumpig.getLevel(), 7);
    }

    @org.junit.jupiter.api.Test
    void assertThatEnemyPokemonHasHisName() {
        EnemyPokemon grumpig = new EnemyPokemon(PokemonList.GRUMPIG);
        assertEquals(grumpig.getName(), "GRUMPIG");
    }

    @org.junit.jupiter.api.Test
    void assertThatEnemyPokemonHasHisHp() {
        EnemyPokemon melmetal = new EnemyPokemon(PokemonList.MELMETAL);
        assertEquals(melmetal.getHp(), melmetal.getLevel()*1.9);
    }

    @org.junit.jupiter.api.Test
    void assertThatMewTwoHasInsaneDamage() {
        EnemyPokemon mewtwo = new EnemyPokemon(PokemonList.MEWTWO);
        assertEquals(mewtwo.getAttackDmg(), mewtwo.getLevel()*3);
    }

    @org.junit.jupiter.api.Test
    void assertThatCharmanderLevelUp() {
        FireType charmander = new FireType(9);
        charmander.levelUp();
        assertEquals(charmander.getLevel(), 10);
    }

    @org.junit.jupiter.api.Test
    void assertThatGrumpigDie() {
        EnemyPokemon grumpig = new EnemyPokemon(PokemonList.GRUMPIG);
        FireType charmander = new FireType(100);
        while(grumpig.getLostHp() == 0){
            charmander.attack(grumpig);
        }
        assertEquals(grumpig.isAlive(), false);
    }

    @org.junit.jupiter.api.Test
    void assertThatDarkraiLoseHp() {
        EnemyPokemon darkrai = new EnemyPokemon(PokemonList.DARKRAI);
        FireType charmander = new FireType(1);
        while(darkrai.getLostHp() == 0){
            charmander.attack(darkrai);
        }
        assertEquals(darkrai.isAlive(), true);
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
        zubat.attack(turtwig);
        assertEquals(zubat.getAttackDmg(), turtwig.getLostHp());
}

    @org.junit.jupiter.api.Test
    void assertThatEnnemyPokemonHasGoodHpRemaining(){
        GrassType turtwig = new GrassType(5);
        EnemyPokemon zubat = new EnemyPokemon(PokemonList.ZUBAT);
        turtwig.attack(zubat);
        assertEquals(turtwig.getLevel()*2, zubat.getLostHp()); //On vérifie que les pv perdus valent au niveau de turtwug * son coeff d'attaque (2)
    }


}
