import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used to manage the ally pokemons with grass type
 */
public class GrassType extends AllyPokemon{

    private final double bonusHP = 0.5;
    private double coeffAttack = 2.5;
    private double coeffHp = 2.5+bonusHP;
    private double accuracy = 0.3;

    private final List<Boolean> evolutionState = new ArrayList<>();

    /**
     * Class constructor of GrassType
     * @param level that corresponds to the level of the ally pokemon used
     */
    public GrassType(int level) {
        super(level);
        super.setHp(getLevel()*coeffHp);
        super.setName("Turtwig");
        super.setAttackName("Razor Leaf");
        evolutionState.add(false);
        evolutionState.add(false);
    }

    @Override
    protected void changeStats() {
        Thread thread = new Thread(() -> {
            while(true) {
                if (this.getLevel() >= 10 && !evolutionState.get(0)) {
                    System.out.println("\n" + ConsoleColors.PURPLE_BOLD + "Your pokemon has evolved to Grotle \n" + ConsoleColors.RESET);
                    super.setName("Grotle");
                    super.setAttackName("Energy Ball");
                    this.setCoeffHp(3.5+bonusHP);
                    super.setHp(getLevel()*coeffHp);
                    coeffAttack = 3.5;
                    accuracy = 0.15;
                    evolutionState.set(0,true);
                } else if (this.getLevel() >= 15 && !evolutionState.get(1)) {
                    System.out.println("\n" + ConsoleColors.PURPLE_BOLD + "Your pokemon has evolved to Torterra \n" + ConsoleColors.RESET);
                    super.setName("Torterra");
                    super.setAttackName("Leaf Storm");
                    this.setCoeffHp(5+bonusHP);
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
            System.out.println(ConsoleColors.WHITE_BOLD + this.getName()+ ConsoleColors.RESET +" missed his attack");
        }
        else {
            System.out.println(ConsoleColors.WHITE_BOLD + this.getName()+ ConsoleColors.RESET +" use "+ this.getAttackName()+"!");
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
