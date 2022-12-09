import java.lang.Math;
public class Grotle extends AllyPokemon{

    private final double coeffAttack = 2.5;
    private final int coeffHp = 3;

    private final double accuracy = 0.2;

    public Grotle(int level) {
        super(level);
        super.setHp(getLevel()*coeffHp);
    }

    @Override
    public void attack(EnemyPokemon enemyPokemon) {
        if (Math.random() <= accuracy){
            System.out.println("Grotle missed his attack");
        }
        else {
            System.out.println("Grotle use Energy Ball !");
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
