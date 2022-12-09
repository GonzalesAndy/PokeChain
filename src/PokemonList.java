public enum PokemonList {

    ZUBAT(5, 0.2, 1),
    EKANS(6, 0.2, 1.2),
    GRUMPIG(7, 0.3, 1.4),
    MISMAGIUS(8, 0.5, 1.2),
    TOXICROAK(9, 0.4, 1.5),
    SCOLIPEDE(10, 0.5, 1.7),
    ZOROARK(11, 0.7, 1.7),
    BISHARP(12, 0.3, 1.4),
    MELMETAL(13, 0.1, 2.1),
    COALOSSAL(14, 0.4, 1.4),
    TOXTRICITY(15, 0.3, 1.4),
    BAXCALIBUR(16, 0.2, 2),
    VOLCARONA(17, 0.2, 2),
    SEISMITOAD(18, 0.3, 1.2),
    DUSKNOIR(19, 0.5, 1.1),
    MAGMORTAR(20, 0.2, 2),
    GENGAR(21, 0.15, 2.1),
    GARCHOMP(22, 0.3, 1.3),
    TYRANITAR(23, 0.2, 2),
    DARKRAI(24, 0.3, 2.1),
    MEWTWO(25, 3, 0.5);

    private final int level;
    private final double coeffAttack;
    private final double coeffHP;


    PokemonList(int level , double coeffAttack, double coeffHP) {
        this.level = level;
        this.coeffAttack = coeffAttack;
        this.coeffHP = coeffHP;

    }

    public int getLevel() {
        return level;
    }

    public double getCoeffAttack() {
        return coeffAttack;
    }

    public double getCoeffHP() {
        return coeffHP;
    }

}
