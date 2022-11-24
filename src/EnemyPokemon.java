public class EnemyPokemon implements Pokemon{


    private int lostHp;
    private int hp;
    private int level;

    public EnemyPokemon(int level, int hp, int lostHp) {
        this.lostHp = lostHp;
        this.hp = hp;
        this.level = level;
    }

    @Override
    public boolean isAlive() {
        return hp - lostHp > 0;
    }

    public int getLostHp() {
        return lostHp;
    }

    public void setLostHp(int lostHp) {
        this.lostHp = lostHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
