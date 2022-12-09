public class EnemyPokemon implements Pokemon{

    private String name;
    private double lostHp;
    private double hp;
    private int level;



    public EnemyPokemon(PokemonList pokemonList) {
        this.name = pokemonList.name();
        this.lostHp = 0;
        this.level = pokemonList.getLevel();
        this.hp = pokemonList.getCoeffHP()*level;
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

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

}
