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
                return new Combat(new Mudkip(5));
            case "Charmander":
                return new Combat(new Charmander(5));
            case "Turtwig":
                return new Combat(new Turtwig(5));

        }
        throw new Exception("Didn't enter valid starter pokemon");
    }

    public void fight() {
        while (starter.isAlive()) {
            EnemyPokemon enemy = spawnEnemy();
            System.out.println("Your opponent is " + enemy.getName());
            System.out.println(enemy.getName() + " has " + enemy.getHp() + " HP");
            while (enemy.isAlive()) {

                Scanner input = new Scanner(System.in);
                System.out.println("What do you want to do ? \n Attack ? (enter A) \n Defend ? (enter D)");
                String action = input.nextLine();
                switch (action) {
                    case "A":
                        starter.attack(enemy);
                        System.out.println(enemy.getName() + " has " + (enemy.getHp() - enemy.getLostHp()) + " HP");
                }

            }
            starter.levelUp();
        }
    }
    public EnemyPokemon spawnEnemy() {
        return new EnemyPokemon(PokemonList.valueOf(starter.getLevel()).get());
    }
}
