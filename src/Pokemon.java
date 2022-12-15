/**
 * Interface of ally pokemon and ennemy pokemons
 * @param <T> Used to generalize attacks for the ennemies and ally pokemons
 */
public interface Pokemon<T> {

    /**
     * Function used to attack an ennemy pokemon as an ally pokemon
     */
    boolean isAlive();

    /**
     * Function that calculate the Health Points remaining on the ally pokemon after he took an attack of an ennemy pokemon
     */
    String remainingHp();

    /**
     * Function used to attack an ennemy pokemon as an ally pokemon
     * @param pokemon corresponds to the pokemon attacked
     */
    void attack(T pokemon);
}
