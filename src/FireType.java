import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to manage the ally pokemons with fire type
 */
public class FireType extends AllyPokemon{


    private double coeffAttack = 2.5;
    private double coeffHp = 2.5;
    private double accuracy = 0.3;

    private final List<Boolean> evolutionState = new ArrayList<>();

    /**
     * Class used to manage the ally pokemons with fire type
     */
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
                    System.out.println("\n" + ConsoleColors.PURPLE_BOLD + "Your pokemon has evolved to Charmeleon \n" + ConsoleColors.RESET);
                    super.setName("Charmeleon");
                    super.setAttackName("FlameThrower");
                    this.setCoeffHp(3.5);
                    super.setHp(getLevel()*coeffHp);
                    coeffAttack = 3.5;
                    accuracy = 0.15;
                    evolutionState.set(0,true);
                } else if (this.getLevel() >= 15 && !evolutionState.get(1)) {
                    System.out.println("\n" + ConsoleColors.PURPLE_BOLD + "Your pokemon has evolved to Charizard \n" + ConsoleColors.RESET);
                    super.setName("Charizard");
                    super.setAttackName("Inferno");
                    this.setCoeffHp(3.5);
                    super.setHp(getLevel()*coeffHp);
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

    /**
     * Setters to change the coefficient of HP
     * @param coeffHp corresponds to the new Hp coefficient
     */
    public void setCoeffHp(double coeffHp) {
        this.coeffHp = coeffHp;
    }

    @Override
    public void levelUp() { super.setLevel(super.getLevel()+1);}

    /**
     * Used to check if the ally pokemon is still alive or dead after an attack
     * @return true if the Health Points of the ally pokemon are still superior to 0 after he lost life because of an attack
     */
    @Override
    public boolean isAlive() {
        return super.getHp()-super.getLostHp()>0;
    }

}
