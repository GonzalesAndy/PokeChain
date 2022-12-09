public abstract class AllyPokemon implements Pokemon{
    private int level;
    private double hp = 1;
    private double lostHp;
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

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getLostHp() {
        return lostHp;
    }

    public void setLostHp(double lostHp) {
        this.lostHp = lostHp;
    }


}
