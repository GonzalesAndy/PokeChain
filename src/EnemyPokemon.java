public class EnemyPokemon implements Pokemon{

    private int lostHp;
    private int hp;
    private int level;

    @Override
    public boolean isAlive() {
        return hp - lostHp > 0;
    }
}
