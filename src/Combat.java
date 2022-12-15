import java.io.IOException;
import java.util.Scanner;

public class Combat {
    private AllyPokemon starter;
    private Score player;

    public Combat(AllyPokemon starter, Score player) throws IOException {
        this.starter = starter;
        this.player = player;
        fight();

    }

    public static void start(Score player) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your starter between Mudkip, Charmander and Turtwig");
        String name = input.nextLine();
        switch (name.toUpperCase()) {
            case "MUDKIP":
                System.out.println("You chose Mudkip");
                new Combat(new WaterType(5), player);
                break;
            case "CHARMANDER":
                System.out.println("You chose Charmander");
                new Combat(new FireType(5), player);
                break;
            case "TURTWIG":
                System.out.println("You chose TurtWig");
                new Combat(new GrassType(5), player);
                break;
            default:
                throw new Exception("Didn't enter a valid Starter name...");
        }
    }

    public void fight() throws IOException {
        starter.changeStats();
        while (starter.isAlive()) {
            EnemyPokemon enemy = spawnEnemy();
            System.out.println("Your opponent is " + enemy.getName());
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
    }
    public EnemyPokemon spawnEnemy() {
        return new EnemyPokemon(PokemonList.valueOf(starter.getLevel()).get());
    }
    
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

