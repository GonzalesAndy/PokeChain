/**
 * Class used to manage all of the ally pokemons
 */
public abstract class AllyPokemon implements Pokemon<EnemyPokemon>{
    private int level;

    private String attackName;
    private String name;
    private double hp = 1;
    private double lostHp = 0;

    /**
     * Class constructor of AllyPokemon
     * @param level corresponds to the level of the ally pokemon
     */
    public AllyPokemon(int level) {
        this.level = level;
    }

    /**
     * Function used to attack an ennemy pokemon as an ally pokemon
     * @param enemyPokemon corresponds to the ennemy pokemon attacked
     */
    public abstract void attack(EnemyPokemon enemyPokemon);

    /**
     * Create a thread that checks if the ally pokemon reach a certains level to change his statistics
     */
    protected abstract void changeStats();

    /**
     * Function that add a level to the ally pokemon when he wins a fight
     */
    public abstract void levelUp();


    /**
     * Getter of the level of the ally pokemon
     * @return the level of the ally pokemon
     */
    public int getLevel() {
        return level;
    }

    /**
     * Setter of the level of the ally pokemon
     * @param level corresponds to the level of the ally pokemon
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Getter of the number of health points of the ally pokemon
     * @return the number of health points of the ally pokemon
     */
    public double getHp() {
        return hp;
    }

    /**
     * Setter of the number of health points of the ally pokemon
     * @param hp corresponds to the number of ally pokemon health points
     */
    public void setHp(double hp) {
        this.hp = hp;
    }

    /**
     * Getter of the number of Health points lost by the ally pokemon after an ennemy pokemon attack
     * @return the number of Health points lost by the ally pokemon after an ennemy pokemon attack
     */
    public double getLostHp() {
        return lostHp;
    }

    /**
     * Setter of the number of Health points lost by the ally pokemon after an ennemy pokemon attack
     * @param lostHp corresponds to the number of Health points lost by the ally pokemon after an ennemy pokemon attack
     */
    public void setLostHp(double lostHp) {
        this.lostHp = lostHp;
    }

    /**
     * Getter of the name of the ally pokemon used by the player
     * @return the name of the ally pokemon used by the player
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of the name of the ally pokemon used by the player
     * @param name that corresponds to the name of the ally pokemon used by the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of the attack used by the ally pokemon
     * @return the name of the attack used by the ally pokemon
     */
    public String getAttackName() {
        return attackName;
    }

    /**
     * Setter of the attack used by the ally pokemon
     * @param attackName that corresponds to the name of the attack used by the ally pokemon
     */
    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    /**
     * Function that calculate the Health points remaining on the ally pokemon after he took an attack of an ennemy pokemon
     * @return the number of the health points remaining on the ally pokemon after he took an attack of an ennemy pokemon
     */
    public String remainingHp() {
        double remaining = this.getHp()-this.getLostHp();
        return String.format("%.2f", remaining);
    }

}
