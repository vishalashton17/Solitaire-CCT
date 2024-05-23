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

        sol = new Solitaire(); // Initialize Solitaire object

        System.out.println("initalizing game");
        // Initialize the game
        sol.InitializeGame();


        // Display the initial game state
        displayer.DisplayBoard(sol.GetBoard());
        displayer.DisplayStockpile(sol.GetStockpile(), sol.GetCurrStockpilePos());
        displayer.DisplayWaste(sol.GetWaste());

        input.close();
    }
}
