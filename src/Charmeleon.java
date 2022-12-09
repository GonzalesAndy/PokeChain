public class Charmeleon extends AllyPokemon{

    private final double coeffAttack = 2.5;
    private final int coeffHp = 3;

    private final double accuracy = 0.2;

    public Charmeleon(int level) {
        super(level);
        super.setHp(getLevel()*coeffHp);
    }

    @Override
    public void attack(EnemyPokemon enemyPokemon) {
        System.out.println("Charmeleon use Flamethrower !");
        enemyPokemon.setLostHp(getLostHp()+((int)(coeffAttack*super.getLevel())));
    }

    @Override
    public void levelUp() {

    }

    @Override
    public boolean isAlive() {
        return super.getHp()-super.getLostHp()>0;
    }
}
