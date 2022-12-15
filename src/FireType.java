import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class FireType extends AllyPokemon{


    private double coeffAttack = 2.5;
    private double coeffHp = 2.5;
    private double accuracy = 0.3;

    private final List<Boolean> evolutionState = new ArrayList<>();

    public FireType(int level) {
        super(level);
        super.setHp(getLevel()*coeffHp);
        super.setName("Charmander");
        super.setAttackName("Flameech");
        evolutionState.add(false);
        evolutionState.add(false);
    }

    @Override
    protected void changeStats() {
        Thread thread = new Thread(() -> {
            while(true) {
                if (this.getLevel() >= 10 && !evolutionState.get(0)) {
                    System.out.println("Your pokemon has evolved to Charmeleon \n");
                    super.setName("Charmeleon");
                    super.setAttackName("FlameThrower");
                    coeffHp = 3.5;
                    coeffAttack = 3.5;
                    accuracy = 0.15;
                    evolutionState.set(0,true);
                } else if (this.getLevel() >= 15 && !evolutionState.get(1)) {
                    System.out.println("Your pokemon has evolved to Charizard \n");
                    super.setName("Charizard");
                    super.setAttackName("Inferno");
                    coeffHp = 5;
                    coeffAttack = 5;
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
            System.out.println(ConsoleColors.WHITE_BOLD + this.getName()+ ConsoleColors.RESET+" missed his attack");
        }
        else {
            System.out.println(ConsoleColors.WHITE_BOLD + this.getName()+ ConsoleColors.RESET +" use "+ this.getAttackName()+"!");
            double bonusDamage = 5.0;
            enemyPokemon.setLostHp(getLostHp()+((coeffAttack*super.getLevel()+ bonusDamage)));
        }
    }

    @Override
    public void levelUp() { super.setLevel(super.getLevel()+1);}

    @Override
    public boolean isAlive() {
        return super.getHp()-super.getLostHp()>0;
    }

}
