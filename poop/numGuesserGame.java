import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

/* todo list
* add user difficulty
* add helper ✅
* maybe keep score
* progressively increase dif
* obmedzeny pocet hintov
* */

public class GuessGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to Guess the Number Game!");

        boolean shouldRun = true;
        Integer minNum = null;
        Integer maxNum = null;
        Integer lastNum = null;
        Integer randomNumber = null;


        System.out.print("\nWhat mode you want to play: ");

        while (shouldRun) {
            switch (input.next().trim().toLowerCase()) {
                case "classic" -> {
                    minNum = 1;
                    maxNum = 10;
                    randomNumber = rand.nextInt(maxNum - minNum + 1) + minNum;
                    shouldRun = false;
                }

                case "normal" -> {
                    System.out.print("\nWith how many digits you wanna play: ");
                    int digits = input.nextInt();
                    minNum = 1;
                    maxNum = (int) Math.pow(10, digits) - 1;
                    randomNumber = rand.nextInt(maxNum - minNum + 1) + minNum;
                    shouldRun = false;
                }

                case "custom" -> {
                    System.out.print("\nSet a range \"num - num\": ");
                    String nums = input.next();
                    String[] idk = nums.trim().split("-");

                    minNum = Integer.parseInt(idk[0].trim());
                    maxNum = Integer.parseInt(idk[1].trim());
                    randomNumber = rand.nextInt(maxNum - minNum + 1) + minNum;

                    shouldRun = false;
                }

                default -> System.out.println("Learn how to write");
            }
        }


        String randomNumberStr = Integer.toString(randomNumber);
        System.out.println("How to play: 1.Guess number between " + minNum + "-" + maxNum);


        while (true) {
            System.out.print("Guess number: ");
            String guess = input.next().trim();

            if (guess.equals(randomNumberStr)) {
                System.out.println("You won! The number was " + randomNumber);
                break;
            }

            if (guess.equals("hint")) {
                System.out.println(randomNumberStr);
                if (lastNum == null) {
                    System.out.println("You haven't guessed yet dumbass!");

                } else {
                    System.out.println(lastNum > randomNumber ? "Lower" : "Upper");
                }

            } else {
                try {
                    lastNum = Integer.valueOf(guess);
                    System.out.println("You guessed wrong! Try again...");

                } catch (NumberFormatException kys) {
                    System.out.println("Invalid input. Next time enter a number.");
                }
            }
        }
    }
}
