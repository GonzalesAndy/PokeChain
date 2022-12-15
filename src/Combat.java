import java.io.IOException;
import java.util.Scanner;

/**
 * Class used to manage the fights beetween ally and ennemies pokemons
 */
public class Combat {
    private final AllyPokemon starter;
    private final Score player;

    /**
     * Class constructor for Combat
     * @param starter AllyPokemon choosen by the player to play the game
     * @param player Score and name registration for the game
     * @throws IOException Warn when an error occured while file write
     */
    private Combat(AllyPokemon starter, Score player) throws IOException {
        this.starter = starter;
        this.player = player;
        fight();

    }

    /**
     * Starter choice management
     * @param player Score and name registration for the game
     * @throws Exception Return an error if player enter a non existing starter name
     */
    public static void start(Score player) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your starter between Mudkip, Charmander and Turtwig");
        String name = input.nextLine();
        switch (name.toUpperCase()) {
            case "MUDKIP" -> {
                System.out.println("You chose " + ConsoleColors.WHITE_BOLD + "Mudkip" + ConsoleColors.RESET);
                new Combat(new WaterType(5), player);
            }
            case "CHARMANDER" -> {
                System.out.println("You chose " + ConsoleColors.WHITE_BOLD + "Charmander" + ConsoleColors.RESET);
                new Combat(new FireType(5), player);
            }
            case "TURTWIG" -> {
                System.out.println("You chose " + ConsoleColors.WHITE_BOLD + "TurtWig" + ConsoleColors.RESET);
                new Combat(new GrassType(5), player);
            }
            default -> throw new Exception("Didn't enter a valid Starter name...");
        }
    }

    /**
     * Course game's management :
     * - Spawn multiples enemies
     * - Score management
     * - Player's actions management
     * - Level up management
     * - Loose message printing
     * @throws IOException Warn when an error occured while file write
     */
    public void fight() throws IOException {
        starter.changeStats();
        while (starter.isAlive()) {
            EnemyPokemon enemy = spawnEnemy();
            System.out.println("Your opponent is " + ConsoleColors.WHITE_BOLD +enemy.getName() + ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE_BOLD + enemy.getName() + ConsoleColors.RESET + " has " + ConsoleColors.RED +enemy.remainingHp() + " HP" + ConsoleColors.RESET);
            while (enemy.isAlive()) {
                if (!action(enemy))
                    enemy.attack(starter);
                System.out.println("Your Pokemon has "+ConsoleColors.GREEN + starter.remainingHp()+ " HP" + ConsoleColors.RESET);
                if (!starter.isAlive()) break;
            }
            player.addScore();
            starter.levelUp();
        }
        player.addPlayerToFile();
        System.out.println("You lost cause your Pokemon died");
        Score.showScoreboard();
    }

    /**
     * Create enemy pokemon according to our level
     * @return The chosen enemy pokemon
     */
    public EnemyPokemon spawnEnemy() {
        return new EnemyPokemon(PokemonList.valueOf(starter.getLevel()).get());
    }

    /**
     * Player inputs management
     * @param enemy enemyPokemon who will be attacked if chosen
     * @return true if the player chose to defend and false if anything else is chose
     */
    public boolean action(EnemyPokemon enemy) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n What do you want to do ? \n Attack ? (enter A) \n Defend ? (enter D) \n Heal ? (enter H) \n");
        String action = input.nextLine();
        switch (action.toUpperCase()) {
            case "A":
                starter.attack(enemy);
                System.out.println(ConsoleColors.WHITE_BOLD + enemy.getName() + ConsoleColors.RESET + " has " + enemy.remainingHp()+ " HP \n");
                return false;
            case "H":
                starter.setLostHp(0);
                System.out.println("Your Pokemon is fully healed he has now "+ ConsoleColors.GREEN + starter.getHp() + " HP" + ConsoleColors.RESET);
                player.setWinStreak(0);
                return false;
            case "D":
                return true;
        }
        return false;
    }
}

