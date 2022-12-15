import static org.junit.jupiter.api.Assertions.*;

class EnemyPokemonTest {

    @org.junit.jupiter.api.Test
    void assertThatEnnemyPokemonHasGoodHpRemaining(){
        GrassType turtwig = new GrassType(5);
        EnemyPokemon zubat = new EnemyPokemon(PokemonList.ZUBAT);
        while(zubat.getLostHp() == 0){
            turtwig.attack(zubat);
        }
        assertEquals(turtwig.getLevel()*2.5, zubat.getLostHp()); //On vérifie que les pv perdus valent au niveau de turtwug * son coeff d'attaque (2)
    }

    @org.junit.jupiter.api.Test
    void assertThatCritWork(){
        FireType charmander = new FireType(38);
        EnemyPokemon mewtwo = new EnemyPokemon(PokemonList.MEWTWO);
        while(charmander.isAlive()){
            charmander.setHp(76);
            mewtwo.attack(charmander);
        }
        assertEquals(charmander.isAlive(), false); // Level 25 * AtckCoeff 3.0 = 75 < 76 Hp, can only kill with critical
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

}