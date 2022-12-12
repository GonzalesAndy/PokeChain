public class EnemyPokemon implements Pokemon<AllyPokemon>{

    private double attackDmg;
    private String name;
    private double lostHp;
    private double hp;
    private int level;
    private double critProba;



    public EnemyPokemon(PokemonList pokemonList) {
        this.name = pokemonList.name();
        this.lostHp = 0;
        this.level = pokemonList.getLevel();
        this.hp = pokemonList.getCoeffHP()*level;
        this.attackDmg = pokemonList.getCoeffAttack()*level;
        this.critProba = pokemonList.getCritProba();
    }

    public void attack(AllyPokemon allyPokemon) {
        if (Math.random() <= critProba){
            System.out.println("Critical hit !");
            allyPokemon.setLostHp(allyPokemon.getLostHp()+(this.getAttackDmg()*0.25));
        }
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

    public double getCritProba() {
        return critProba;
    }

    public void setCritProba(double critProba) {
        this.critProba = critProba;
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
