public abstract class AllyPokemon implements Pokemon{
    private int level;
    private int hp = 1;
    private int lostHp;
    public AllyPokemon(int level) {
        this.level = level;
        this.hp = hp;
        this.lostHp = lostHp;
    }

    public abstract void attack(EnemyPokemon enemyPokemon);

    public abstract void levelUp();

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLostHp() {
        return lostHp;
    }

    public void setLostHp(int lostHp) {
        this.lostHp = lostHp;
    }


}
