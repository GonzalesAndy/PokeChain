import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to manage the ally pokemons with water type
 */
public class WaterType extends AllyPokemon{


    private final double bonusAccuracy = 0.1;
    private double coeffAttack = 2.5;
    private double coeffHp = 2;
    private double accuracy = 0.3-bonusAccuracy;

    private final List<Boolean> evolutionState = new ArrayList<>();

    /**
     * Class constructor of WaterType
     * @param level that corresponds to the level of the ally pokemon used
     */
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
                    this.setCoeffHp(2.5);
                    super.setHp(getLevel()*coeffHp);
                    coeffAttack = 3.5;
                    accuracy = 0.15-bonusAccuracy;
                    evolutionState.set(0,true);
                } else if (this.getLevel() >= 15 && !evolutionState.get(1)) {
                    System.out.println("\n" + ConsoleColors.PURPLE_BOLD + "Your pokemon has evolved to Swampert \n" + ConsoleColors.RESET);
                    super.setName("Swampert");
                    super.setAttackName("Hydroblast");
                    this.setCoeffHp(3);
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
