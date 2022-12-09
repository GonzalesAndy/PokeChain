import java.lang.Math;
public class Torterra extends AllyPokemon{

    public final double coeffAttack = 3;
    public final int coeffHp = 4;

    private final double accuracy = 0.1;

    public Torterra(int level) {
        super(level);
        super.setHp(getLevel()*coeffHp);
    }

    @Override
    public void attack(EnemyPokemon enemyPokemon) {
        if (Math.random() <= accuracy){
            System.out.println("Torterra missed his attack");
        }
        else {
            System.out.println("Torterra use Leaf Storm !");
            enemyPokemon.setLostHp(getLostHp()+((int)(coeffAttack*super.getLevel())));
        } }

    @Override
    public void levelUp() {
        super.setLevel(super.getLevel()+1);
    }

    @Override
    public boolean isAlive() {
        return super.getHp()-super.getLostHp()>0;
    }

}
