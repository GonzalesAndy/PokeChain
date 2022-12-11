import java.util.Scanner;

public class Combat {
    private AllyPokemon starter;

    public Combat(AllyPokemon starter) {
        this.starter = starter;
        fight();

    }

    public static Combat start() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your starter between Mudkip, Charmander and Turtwig");
        String name = input.nextLine();
        switch (name) {
            case "Mudkip":
                System.out.println("You chose Mudkip");
                return new Combat(new WaterType(5));
            case "Charmander":
                System.out.println("You chose Charmander");
                return new Combat(new FireType(5));
            case "TurtWig":
                System.out.println("You chose TurtWig");
                return new Combat(new GrassType(5));
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

                Scanner input = new Scanner(System.in);
                System.out.println("What do you want to do ? \n Attack ? (enter A) \n Defend ? (enter D) \n Heal ? (enter H) \n");
                String action = input.nextLine();
                switch (action) {
                    case "A":
                        starter.attack(enemy);
                        System.out.println(enemy.getName() + " has " + enemy.remainingHp()+ " HP \n");
                        break;
                    case "H":
                        starter.setLostHp(0);
                        System.out.println("Your Pokemon is fully healed he has now "+ starter.getHp() + " HP");
                        break;
                    case "D":
                        break;
                }
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
}
