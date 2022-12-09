import java.util.Scanner;

public class Combat {
    private AllyPokemon starter;

    public Combat(AllyPokemon starter) {
        this.starter = starter;


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
        
    }




}
