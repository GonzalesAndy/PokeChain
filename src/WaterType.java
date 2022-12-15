import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class WaterType extends AllyPokemon{


    private final double bonusAccuracy = 0.1;
    private double coeffAttack = 2.5;
    private double coeffHp = 2.5;
    private double accuracy = 0.3-bonusAccuracy;

    private final List<Boolean> evolutionState = new ArrayList<>();

    public WaterType(int level) {
        super(level);
        super.setHp(getLevel()*coeffHp);
        super.setName("Mudkip");
        super.setAttackName("Pisstolow");
        evolutionState.add(false);
        evolutionState.add(false);
    }

    @Override
    protected void changeStats() {
        Thread thread = new Thread(() -> {
            while(true) {
                if (this.getLevel() >= 10 && !evolutionState.get(0)) {
                    System.out.println("\n" + ConsoleColors.PURPLE_BOLD + "Your pokemon has evolved to Marshtomp \n" + ConsoleColors.RESET);
                    super.setName("Marshtomp");
                    super.setAttackName("Surf");
                    this.setCoeffHp(3.5);
                    super.setHp(getLevel()*coeffHp);
                    coeffAttack = 3.5;
                    accuracy = 0.15-bonusAccuracy;
                    evolutionState.set(0,true);
                } else if (this.getLevel() >= 15 && !evolutionState.get(1)) {
                    System.out.println("\n" + ConsoleColors.PURPLE_BOLD + "Your pokemon has evolved to Swampert \n" + ConsoleColors.RESET);
                    super.setName("Swampert");
                    super.setAttackName("Hydroblast");
                    this.setCoeffHp(5);
                    super.setHp(getLevel()*coeffHp);
                    coeffAttack = 5;
                    accuracy = 0.1-bonusAccuracy;
                    evolutionState.set(1,true);
                }
            }
        });
        thread.start();
    }


    @Override
    public void attack(EnemyPokemon enemyPokemon) {
        if (Math.random() <= accuracy){
            System.out.println(ConsoleColors.WHITE_BOLD + this.getName()+ ConsoleColors.RESET +" missed his attack");
        }
        else {
            System.out.println(ConsoleColors.WHITE_BOLD +this.getName()+ ConsoleColors.RESET +" use "+ this.getAttackName()+"!");
            enemyPokemon.setLostHp(getLostHp()+((coeffAttack*super.getLevel())));
        }
    }

    public void setCoeffAttack(double coeffAttack) {
        this.coeffAttack = coeffAttack;
    }

    public void setCoeffHp(double coeffHp) {
        this.coeffHp = coeffHp;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public void levelUp() { super.setLevel(super.getLevel()+1);}

    @Override
    public boolean isAlive() {
        return super.getHp()-super.getLostHp()>0;
    }

}
