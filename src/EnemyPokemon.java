public class EnemyPokemon implements Pokemon{

    private double attackDmg;
    private String name;
    private double lostHp;
    private double hp;
    private int level;



    public EnemyPokemon(PokemonList pokemonList) {
        this.name = pokemonList.name();
        this.lostHp = 0;
        this.level = pokemonList.getLevel();
        this.hp = pokemonList.getCoeffHP()*level;
        this.attackDmg = pokemonList.getCoeffAttack()*level;
    }

    public void attack(AllyPokemon allyPokemon) {
        System.out.println(this.getName()+" attacked you");
        allyPokemon.setLostHp((allyPokemon.getLostHp()+this.getAttackDmg()));
    }


    @Override
    public boolean isAlive() {
        return hp - lostHp > 0;
    }

    @Override
    public String remainingHp() {
        double remaining = this.getHp()-this.getLostHp();
        return String.format("%.2f", remaining);
    }

    public double getLostHp() {
        return lostHp;
    }

    public void setLostHp(double lostHp) {
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

    public double getAttackDmg() {
        return attackDmg;
    }
}
