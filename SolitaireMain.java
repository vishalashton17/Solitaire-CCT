// Developed by Vishal
import java.util.Scanner;

public class SolitaireMain {
public static void main(String[] args) {
    // Creates the Displayer object
    Displayer displayer = new Displayer();
    
    // Creates the Solitaire object
    Solitaire sol;

    // Create scanner object for user input
    Scanner input = new Scanner(System.in);

    // Declared and initialised all variables
    String player1, player2;
    

    displayer.GameHeader(); // Displays game header

    sol = new Solitaire(); // Initialize Solitaire object
    
    System.out.println("Initializing game");
   
    System.out.println("Enter first player's name:"); 
    player1 = input.nextLine();
    System.out.println("Enter second player's name:"); 
    player2 = input.nextLine();
    
    // Initialize the game
    sol.InitializeGame(player1, player2);
    
    while(!sol.CheckIfWon()) {
        // Display the initial game state
        displayer.DisplayStockpile(sol.GetStockpile(), sol.GetCurrStockpilePos());
        displayer.DisplayWaste(sol.GetWaste());
        displayer.DisplayBoard(sol.GetBoard());

        // Get and display current player
        String currPlayer = sol.GetCurrPlayer();
        System.out.println("Current Player: " + currPlayer);

        // Movements within the 7 piles
        System.out.println("Do you want to move cards within the piles of cards? (Y/N)");
        char moveCards = input.next().charAt(0);
        int fromPile, toPile;
        if(moveCards == 'y' || moveCards == 'Y') {
            do {
                System.out.println("Move card from pile number (Enter 0 to proceed to stockpile): "); 
                fromPile = input.nextInt();
                input.nextLine(); // newline

                if(fromPile == 0) {
                  break;
                }
                
                System.out.println("Move card to pile number: ");
                toPile = input.nextInt();
                input.nextLine(); //newline

                sol.BoardCardMovement(fromPile, toPile);
            } while(fromPile == 0);
        }

        System.out.println("Where do you want to place the stockpile card? (Column 1-7, 8 to move to waste)");
        int stockpileMove = input.nextInt();
        sol.StockpileCardMovement(stockpileMove);
        
        sol.SwitchPlayer();
    }
// Game is won
    boolean winner = sol.CheckIfWon();
    System.out.println("Congratulations " + winner + "! You've won the game!");

    input.close();
}
}
