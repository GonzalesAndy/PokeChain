public class EnemyPokemon implements Pokemon{


    private double lostHp;
    private double hp;
    private int level;

    public EnemyPokemon(PokemonList pokemonList) {
        this.lostHp = 0;
        this.hp = pokemonList.getCoeffHP();
        this.level = pokemonList.getLevel();
    }

    @Override
    public boolean isAlive() {
        return hp - lostHp > 0;
    }

    public double getLostHp() {
        return lostHp;
    }

    public void setLostHp(int lostHp) {
        this.lostHp = lostHp;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
