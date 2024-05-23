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

        displayer.GameHeader(); // Displays game header

        sol = new Solitaire(); // Initialize Solitaire object

        // Initialize the game
        sol.InitializeGame();

        // Display the initial game state
        displayer.DisplayStockpile(sol.GetStockpile(), sol.GetCurrStockpilePos());
        displayer.DisplayWaste(sol.GetWaste());
        displayer.DisplayBoard(sol.GetBoard());

        input.close();
    }
}
