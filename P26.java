import java.util.Scanner;

public class P26 {
    static P25 helper = new P25();
    static String[] words = {"example 1", "example 2"}; // you can change these values to whatever you want or add more values.

    static void displayHangMan(int numWrong) {
        String[] hangmanImage = {
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n=========",
        };
        if (numWrong < hangmanImage.length) {
            System.out.println(hangmanImage[numWrong]);
        } else {
            System.out.println("Error: invalid number of wrong guesses");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretWord = helper.getRandomWord(words);
        String guessedChars = "";
        int wrongGuesses = 0;

        System.out.println("  WELCOME HANGMAN!");
        System.out.println("MADE BY: YUVRAJ SINGH\n");

        while (wrongGuesses < 6) {
            System.out.println("\nGUESS A CHARACTER:");
            char guess = scanner.next().charAt(0);

            if (helper.checkChar(guess, secretWord)) {
                System.out.println("\nYOUR GUESS WAS CORRECT!");
                guessedChars += guess;
            } else {
                System.out.println("\nYOUR GUESS WAS INCORRECT.");
                wrongGuesses++;
            }

            String revealed = helper.getRevealedChars(secretWord, guessedChars);
            System.out.println("\nCHARACTERS REVEALED: " + revealed);
            displayHangMan(wrongGuesses);

            if (!revealed.contains("_")) {
                System.out.println("\nCONGRATULATIONS! YOU WIN!");
                return;
            }
        }

        System.out.println("\nGAME OVER!\nSORRY, YOU LOSE!");
    }
}
// if you're from my school, i hope you don't use my code to cheat on the project as mr.zamar will probably find out :/