import java.lang.Math;
public class Charizard extends AllyPokemon{

    private final double coeffAttack = 3;
    private final int coeffHp = 4;

    private final double accuracy = 0.1;

    public Charizard(int level) {
        super(level);
        super.setHp(getLevel()*coeffHp);
    }

    @Override
    public void attack(EnemyPokemon enemyPokemon) {
        if (Math.random() <= accuracy){
            System.out.println("Charizard missed his attack");
        }
        else {
            System.out.println("Charizard use Inferno !");
            enemyPokemon.setLostHp(getLostHp()+((int)(coeffAttack*super.getLevel())));
    } }

    @Override
    public void levelUp() {

    }

    @Override
    public boolean isAlive() {
        return super.getHp()-super.getLostHp()>0;
    }
}
