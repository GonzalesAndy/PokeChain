import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class GrassType extends AllyPokemon{


    private final double bonusHP = 0.5;
    private double coeffAttack = 2;
    private double coeffHp = 2+bonusHP;
    private double accuracy = 0.3;

    private final List<Boolean> evolutionState = new ArrayList<>();

    public GrassType(int level) {
        super(level);
        super.setHp(getLevel()*coeffHp);
        super.setName("TurtWig");
        super.setAttackName("Razor Leaf");
        evolutionState.add(false);
        evolutionState.add(false);
    }

    @Override
    protected void changeStats() {
        Thread thread = new Thread(() -> {
            while(true) {
                if (this.getLevel() >= 10 && !evolutionState.get(0)) {
                    System.out.println("Your pokemon has evolved to Grotle \n");
                    super.setName("Grotle");
                    super.setAttackName("Energy Ball");
                    coeffHp = 3+bonusHP;
                    coeffAttack = 2.5;
                    accuracy = 0.2;
                    evolutionState.set(0,true);
                } else if (this.getLevel() >= 15 && !evolutionState.get(1)) {
                    System.out.println("Your pokemon has evolved to Torterra \n");
                    super.setName("Torterra");
                    super.setAttackName("Leaf Storm");
                    coeffHp = 4+bonusHP;
                    coeffAttack = 3;
                    accuracy = 0.1;
                    evolutionState.set(1,true);
                }
            }
        });
        thread.start();
    }


    @Override
    public void attack(EnemyPokemon enemyPokemon) {
        if (Math.random() <= accuracy){
            System.out.println(this.getName()+" missed his attack");
        }
        else {
            System.out.println(this.getName()+" use "+ this.getAttackName()+"!");
            enemyPokemon.setLostHp(getLostHp()+((coeffAttack*super.getLevel())));
        }
    }

    @Override
    public void levelUp() { super.setLevel(super.getLevel()+1);}

    @Override
    public boolean isAlive() {
        return super.getHp()-super.getLostHp()>0;
    }

}