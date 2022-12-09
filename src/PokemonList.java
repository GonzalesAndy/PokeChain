public enum PokemonList {

    ZUBAT(5, 0.2, 1),
    EKANS(5, 0.2, 1.2),
    GRUMPIG(7, 0.3, 1.4),
    MISMAGIUS(8, 0.5, 1.2),
    TOXICROAK(10, 0.4, 1.5),
    SCOLIPEDE(11, 0.5, 1.7),
    ZOROARK(14, 0.7, 1.7),
    BISHARP(16, 0.3, 1.4),
    MELMETAL(18, 0.1, 2.1),
    COALOSSAL(20, 0.4, 1.4),
    TOXTRICITY(23, 0.3, 1.4),
    BAXCALIBUR(25, 0.2, 2),
    VOLCARONA(25, 0.2, 2),
    SEISMITOAD(26, 0.3, 1.2),
    DUSKNOIR(28, 0.5, 1.1),
    MAGMORTAR(25, 0.2, 2),
    GARCHOMP(26, 0.3, 1.3),
    TYRANITAR(27, 0.2, 2),
    DARKRAI(28, 0.3, 2.1),
    MEWTWO(30, 3, 0.5);

    private final int level;
    private final double coeffAttack;
    private final double coeffHP;


    PokemonList(int level , double coeffAttack, double coeffHP) {
        this.level = level;
        this.coeffAttack = coeffAttack;
        this.coeffHP = coeffHP;

    }

}
