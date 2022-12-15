import java.util.Arrays;
import java.util.Optional;

/**
 * Enum of all ennemy pokemons that the player can confront with his pokemon
 */
public enum PokemonList {

    ZUBAT(5, 0.2, 1, 0.05),
    EKANS(6, 0.2, 1.2, 0.05),
    GRUMPIG(7, 0.3, 1.4, 0.05),
    MISMAGIUS(8, 0.5, 1.2, 0.1),
    TOXICROAK(9, 0.4, 1.5, 0.1),
    SCOLIPEDE(10, 0.45, 1.6, 0.1),
    ZOROARK(11, 0.5, 1.6, 0.1),
    BISHARP(12, 0.3, 1.4, 0.15),
    MELMETAL(13, 0.1, 1.9, 0.2),
    COALOSSAL(14, 0.4, 1.4, 0.2),
    TOXTRICITY(15, 0.3, 1.4, 0.2),
    BAXCALIBUR(16, 0.2, 2, 0.2),
    VOLCARONA(17, 0.2, 2, 0.2),
    SEISMITOAD(18, 0.3, 1.2, 0.2),
    DUSKNOIR(19, 0.35, 1.1, 0.25),
    MAGMORTAR(20, 0.2, 2, 0.25),
    GENGAR(21, 0.15, 2, 0.3),
    GARCHOMP(22, 0.3, 1.3, 0.3),
    TYRANITAR(23, 0.2, 2, 0.4),
    DARKRAI(24, 0.3, 2, 0.4),
    MEWTWO(25, 3, 1.2, 0.5);


    private final int level;
    private final double coeffAttack;
    private final double coeffHP;
    private final double critProba;


    /**
     * Class constructor of PokemonList
     * @param level that corresponds to the level of the ennemy pokemon
     * @param coeffAttack that corresponds to the attack coefficient of the ennemy pokemon
     * @param coeffHP that corresponds to the Health Points of the ennemy pokemon
     * @param critProba that corresponds to the probability of inflicting a critical attack for an ennemy pokemon
     */
    PokemonList(int level , double coeffAttack, double coeffHP, double critProba) {
        this.level = level;
        this.coeffAttack = coeffAttack;
        this.coeffHP = coeffHP;
        this.critProba = critProba;

    }

    /**
     * Getter of the level of an ennemy pokemon
     * @return the level of an ennemy pokemon
     */
    public int getLevel() {
        return level;
    }

    /**
     * Getter of the attack coefficient of an ennemy pokemon
     * @return the attack coefficient of an ennemy pokemon
     */
    public double getCoeffAttack() {
        return coeffAttack;
    }

    /**
     *Getter of the Health Points coefficient of an ennemy pokemon
     * @return the Health Points coefficient of an ennemy pokemon
     */
    public double getCoeffHP() {
        return coeffHP;
    }

    /**
     * Getter of the probability of inflicting a critical attack for an ennemy pokemon
     * @return the probability of inflicting a critical attack for an ennemy pokemon
     */
    public double getCritProba() {
        return critProba;
    }

    /**
     * Function that filters the level of ennemy pokemons to select them as opponents in function of the ally pokemon level
     * @param level that corresponds to the level of the ally pokemon
     * @return the chosen pokemon to confront the ally pokemon
     */
    public static Optional<PokemonList> valueOf(double level) {
        return Arrays.stream(values())
                .filter(PokemonList -> PokemonList.level == level)
                .findFirst();
    }

}
