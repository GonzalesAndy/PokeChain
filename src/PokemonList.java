public enum PokemonList {

    ZUBAT(5, 1.1, 1),
    EKANS(5, 1.2, 1.2),
    GRUMPIG(7, 1.3, 1.4),
    MISMAGIUS(8, 1.5, 1.2),
    TOXICROAK(10, 1.4, 1.5),
    SCOLIPEDE(11, 1.5, 1.7),
    ZOROARK(14, 1.7, 1.7),
    BISHARP(16, 1.3, 1.4),
    MELMETAL(18, 1.1, 2.1),
    COALOSSAL(20, 1.4, 1.4),
    TOXTRICITY(7, 1.3, 1.4);


    private final int level;
    private final double coeffAttack;
    private final double coeffHP;


    PokemonList(int level , double coeffAttack, double coeffHP) {
        this.level = level;
        this.coeffAttack = coeffAttack;
        this.coeffHP = coeffHP;

    }

}
