public class Turtwig extends AllyPokemon{

    private final double coeffAttack = 2;
    private final int coeffHp = 2;

    private final double accuracy = 0.3;
    public Turtwig(int level) {
        super(level);
        super.setHp(getLevel()*coeffHp);
    }

    @Override
    public void attack(EnemyPokemon enemyPokemon) {
        System.out.println("Turtwig use Razor Leaf !");
        enemyPokemon.setLostHp(getLostHp()+((int)(coeffAttack*super.getLevel())));
    }

    @Override
    public void levelUp() {
        super.setLevel(super.getLevel()+1);
    }

    @Override
    public boolean isAlive() {
        return super.getHp()-super.getLostHp()>0;
    }

}
