import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the EnemyPokemon Class
 */
class EnemyPokemonTest {

    /**
     * Test if when you attack a pokemon the correct amount of health is removed
     */
    @org.junit.jupiter.api.Test
    void assertThatEnnemyPokemonHasGoodHpRemaining(){
        GrassType turtwig = new GrassType(5);
        EnemyPokemon zubat = new EnemyPokemon(PokemonList.ZUBAT);
        while(zubat.getLostHp() == 0){
            turtwig.attack(zubat);
        }
        assertEquals(turtwig.getLevel()*2.5, zubat.getLostHp()); //On vérifie que les pv perdus valent au niveau de turtwug * son coeff d'attaque (2)
    }

    /**
     * Test that the crit add 25% of damage to the attack
     */
    @org.junit.jupiter.api.Test
    void assertThatCritWork(){
        FireType charmander = new FireType(38);
        EnemyPokemon mewtwo = new EnemyPokemon(PokemonList.MEWTWO);
        while(charmander.isAlive()){
            charmander.setHp(76);
            mewtwo.attack(charmander);
        }
        assertFalse(charmander.isAlive()); // Level 25 * AtckCoeff 3.0 = 75 < 76 Hp, can only kill with critical
    }

    /**
     * Test that isAlive return false when lostHp is bigger than hp
     */
    @org.junit.jupiter.api.Test
    void assertThatGrumpigDie() {
        EnemyPokemon grumpig = new EnemyPokemon(PokemonList.GRUMPIG);
        FireType charmander = new FireType(100);
        while(grumpig.getLostHp() == 0){
            charmander.attack(grumpig);
        }
        assertFalse(grumpig.isAlive());
    }

    /**
     * Test that the pokemon has the correct level when initialized
     */
    @org.junit.jupiter.api.Test
    void assertThatEnemyPokemonHasHisLevel() {
        EnemyPokemon grumpig = new EnemyPokemon(PokemonList.GRUMPIG);
        assertEquals(grumpig.getLevel(), 7);
    }

    /**
     * Test that the correct name is givin, when using the Enum class
     */
    @org.junit.jupiter.api.Test
    void assertThatEnemyPokemonHasHisName() {
        EnemyPokemon grumpig = new EnemyPokemon(PokemonList.GRUMPIG);
        assertEquals(grumpig.getName(), "GRUMPIG");
    }

    /**
     * Test that the correct coefficient of hp is used with the Enum class
     */
    @org.junit.jupiter.api.Test
    void assertThatEnemyPokemonHasHisHp() {
        EnemyPokemon melmetal = new EnemyPokemon(PokemonList.MELMETAL);
        assertEquals(melmetal.getHp(), melmetal.getLevel()*1.9);
    }

    /**
     * Test that mewtwo has the correct damage using the Enum attack coefficient
     */
    @org.junit.jupiter.api.Test
    void assertThatMewTwoHasInsaneDamage() {
        EnemyPokemon mewtwo = new EnemyPokemon(PokemonList.MEWTWO);
        assertEquals(mewtwo.getAttackDmg(), mewtwo.getLevel()*3);
    }

}