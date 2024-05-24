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

        // Movements within the 7 piles
        System.out.println("Do you want to move cards within the piles of cards? (Y/N)");
        char moveCards  = input.next().charAt(0);
        int fromPile;
        int toPile;
        if(moveCards == 'y' || moveCards == 'Y'){
            do{
                System.out.println("Move card from pile number(Key in 0 if proceeding to stockpile): "); 
                fromPile = input.nextInt();

                System.out.println("Move card to pile number: ");
                toPile = input.nextInt();

                sol.BoardCardMovement(fromPile, toPile);
            }
            while(fromPile == 0);
            
        }

        System.out.println("Where do you want to place the stockpile card?(Column 1-7, 8 to move to waste)");
        int stockpileMove = input.nextInt();

        sol.StockpileCardMovement(stockpileMove);

        input.close();
    }
}
