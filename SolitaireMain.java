// Developed by Vishal
import java.util.Scanner;

public class SolitaireMain {
    // The start of the game
    public static void main(String[] args) {
        // Creates the Displayer object
        Displayer displayer = new Displayer();
        
        // Creates the Solitaire object
        Solitaire sol;

        // Create scanner object for user input
        Scanner input = new Scanner(System.in);

        // Declared and initialised all variables
        int rounds = 0;

        displayer.GameHeader(); // Displays game header

        // Get the number of rounds
        do {
            System.out.print("Number of rounds to play: ");
            rounds = input.nextInt();
            // Error checking and validation
            if (rounds <= 0) {
                System.out.println("ERROR: Invalid number of rounds!");
            }
        } while (rounds <= 0);

        sol = new Solitaire(); // Initialize Solitaire object

        // Initialize the game
        sol.InitializeGame();

        // Display the initial game state
        displayer.DisplayBoard(sol.GetBoard());
        displayer.DisplayStockpile(sol.GetStockpile());
        displayer.DisplayWaste(sol.GetWaste());

        input.close();
    }
}
