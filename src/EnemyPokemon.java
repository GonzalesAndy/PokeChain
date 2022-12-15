/**
 * Class used to manage all of the ennemies pokemons
 */
public class EnemyPokemon implements Pokemon<AllyPokemon>{

    private final double attackDmg;
    private final String name;
    private double lostHp;
    private final double hp;
    private final int level;
    private final double critProba;


    /**
     * Class constructor of EnemyPokemon
     * @param pokemonList enum containing the list of all enemies pokemons
     */
    public EnemyPokemon(PokemonList pokemonList) {
        this.name = pokemonList.name();
        this.lostHp = 0;
        this.level = pokemonList.getLevel();
        this.hp = pokemonList.getCoeffHP()*level;
        this.attackDmg = pokemonList.getCoeffAttack()*level;
        this.critProba = pokemonList.getCritProba();
    }

    /**
     * Function managing the attack of enemies pokemons including basical attacks and critical hits
     * @param allyPokemon class of ally pokemons targeted by the pokemon that attacks thanks to this function
     */
    public void attack(AllyPokemon allyPokemon) {
        if (Math.random() <= critProba){
            System.out.println(ConsoleColors.YELLOW +"Critical hit !" + ConsoleColors.RESET);
            allyPokemon.setLostHp(allyPokemon.getLostHp()+(this.getAttackDmg()*0.25));
        }
        System.out.println(ConsoleColors.WHITE_BOLD + this.getName()+ ConsoleColors.RESET +" attacked you");
        allyPokemon.setLostHp((allyPokemon.getLostHp()+this.getAttackDmg()));
    }

    /**
     * Used to check if the ennemy pokemon is still alive or dead after an attack
     * @return true if the Health Points of the ennemy pokemon are still superior to 0 after he lost life because of an attack
     */
    @Override
    public boolean isAlive() {
        return hp - lostHp > 0;
    }

    /**
     * Function that calculate the number of Health Points on an ennemy pokemon
     * @return the number of Health Points remaining on an enemy pokemon after he took an ally pokemon attack
     */
    @Override
    public String remainingHp() {
        double remaining = this.getHp()-this.getLostHp();
        return String.format("%.2f", remaining);
    }

    /**
     * Getter of the number of Health Points lost on an ennemy pokemon after an ally pokemon attack
      * @return the number of Health Points lost on an ennemy pokemon after an ally pokemon attack
     */
    public double getLostHp() {
        return lostHp;
    }

    /**
     *Setter of the number of Health Points lost on an ennemy pokemon after an ally pokemon attack
     * @param lostHp correspond to the number of Health Points lost on an ennemy pokemon after an ally pokemon attack
     */
    public void setLostHp(double lostHp) {
        this.lostHp = lostHp;
    }

    /**
     * Getter of the number of Health Points on an ennemy pokemon
     * @return the number of Health Points on an ennemy pokemon
     */
    public double getHp() {
        return hp;
    }

    /**
     * Getter of the level of the ennemy pokemon
     * @return the level of the ennemy pokemon
     */
    public int getLevel() {
        return level;
    }

    /**
     * Getter of the name of an ennemy pokemon
     * @return the name of an ennemy pokemon
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of the number of damages made by the attack of an ennemy pokemon
     * @return the number of damages made by the attack of an ennemy pokemon
     */
    public double getAttackDmg() {
        return attackDmg;
    }

}