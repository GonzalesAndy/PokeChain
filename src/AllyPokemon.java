public abstract class AllyPokemon implements Pokemon<EnemyPokemon>{
    private int level;

    private String attackName;
    private String name;
    private double hp = 1;
    private double lostHp = 0;
    public AllyPokemon(int level) {
        this.level = level;
    }

    public abstract void attack(EnemyPokemon enemyPokemon);

    protected abstract void changeStats();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttackName() {
        return attackName;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    public String remainingHp() {
        double remaining = this.getHp()-this.getLostHp();
        return String.format("%.2f", remaining);
    }






}
