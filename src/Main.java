import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean done = false;
        String YNResponse = "";
        String trash = "";
        do {
            System.out.println("Welcome to the Craps game!");
        System.out.println("That is the name of this game. I can't believe I'm programming this.");
        System.out.println("Let's start!");
        Random generator = new Random();
        int die1 = generator.nextInt(6) + 1;
        int die2 = generator.nextInt(6) + 1;
        int crapsRoll = die1 + die2;
        int thePoint = 0;
        System.out.printf("%5s%15s%15s\n", "die1", "die2", "Sum");
        System.out.printf("%5s%15s%15s\n", die1, die2, crapsRoll);
        if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
            System.out.println("Yikes! You crapped out. You rolled a sum of " + crapsRoll + "! Sad loss.");
        } // instant lose: 2, 3, 12
        else if (crapsRoll == 7 || crapsRoll == 11) {
            System.out.println("Awesome! You got a natural, a sum of " + crapsRoll + "! That's a win!");
        }
        // instant win: 7 (first time), 11
        else {
            thePoint = crapsRoll;
            System.out.println("The goal to win is ''the point,'' which is now " + thePoint + "! No 7 allowed!");
            do {
                die1 = generator.nextInt(6) + 1;
                die2 = generator.nextInt(6) + 1;
                crapsRoll = die1 + die2;
                System.out.printf("%5s%15s%15s\n", die1, die2, crapsRoll);
            } while (crapsRoll != thePoint && crapsRoll != 7);

            if (crapsRoll == thePoint) {
                System.out.println("You met the point, " + thePoint + "! You win!");
            } // winning with the point
            else {
                System.out.println("Yikes! Looks like you got a " + crapsRoll + " before " + thePoint + "! Sad loss!");
            }
                // losing by getting seven
        }
        // "the point" or lose with 7.

            System.out.println("Play again? [Y/N]");
            Scanner in = new Scanner(System.in);
            YNResponse = in.nextLine().toUpperCase();
            if (YNResponse.equals("N")){
                done = true;
            } else if (!YNResponse.equals("Y")) {
                trash = YNResponse;
                System.out.println("Invalid input: " + trash + ". Running again!");
            } // check if user wants to play again
        } while (!done);
    }
}