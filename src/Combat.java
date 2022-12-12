import java.util.Scanner;

public class Combat {
    private AllyPokemon starter;

    public Combat(AllyPokemon starter) {
        this.starter = starter;
        fight();

    }

    public static void start() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your starter between Mudkip, Charmander and Turtwig");
        String name = input.nextLine();
        switch (name) {
            case "Mudkip":
                System.out.println("You chose Mudkip");
                new Combat(new WaterType(5));
            case "Charmander":
                System.out.println("You chose Charmander");
                new Combat(new FireType(5));
            case "Turtwig":
                System.out.println("You chose TurtWig");
                new Combat(new GrassType(5));
        }
        throw new Exception("Didn't enter valid starter pokemon");
    }

    public void fight() {
        starter.changeStats();
        while (starter.isAlive()) {
            EnemyPokemon enemy = spawnEnemy();
            System.out.println("Your opponent is " + enemy.getName());
            System.out.println(enemy.getName() + " has " + enemy.remainingHp() + " HP");
            while (enemy.isAlive()) {
                if (!action(enemy))
                    enemy.attack(starter);
                System.out.println("Your Pokemon has "+starter.remainingHp()+ " HP");
                if (!starter.isAlive()) break;
            }
            starter.levelUp();
        }
        System.out.println("Votre pokémon est mort vous avez perdu");
    }
    public EnemyPokemon spawnEnemy() {
        return new EnemyPokemon(PokemonList.valueOf(starter.getLevel()).get());
    }
    
    public boolean action(EnemyPokemon enemy) {
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to do ? \n Attack ? (enter A) \n Defend ? (enter D) \n Heal ? (enter H) \n");
        String action = input.nextLine();
        switch (action) {
            case "A":
                starter.attack(enemy);
                System.out.println(enemy.getName() + " has " + enemy.remainingHp()+ " HP \n");
                return false;
            case "H":
                starter.setLostHp(0);
                System.out.println("Your Pokemon is fully healed he has now "+ starter.getHp() + " HP");
                return false;
            case "D":
                return true;
        }
        return false;
    }
}

