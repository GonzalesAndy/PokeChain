public class Charmander extends AllyPokemon{
    public final double coeffAttack = 2;
    public final int coeffHp = 2;
    public Charmander(int level) {
        super(level);
        super.setHp(getLevel()*coeffHp);
    }

    @Override
    public void attack(EnemyPokemon enemyPokemon) {
        System.out.println("Charmander use Flameech !");
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
