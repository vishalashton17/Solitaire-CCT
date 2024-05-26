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
   
    System.out.println("Enter first player's name:"); 
    player1 = input.nextLine();
    System.out.println("Enter second player's name:"); 
    player2 = input.nextLine();
    
    // Initialize the game
    sol.SetPlayers(player1, player2);
    sol.InitializeGame();
    
    while(!sol.CheckIfWon()) {
        // Display the initial game state
        displayer.DisplayBoard(sol.GetBoard());
        displayer.DisplayStockpile(sol.GetStockpile(), sol.GetCurrStockpilePos());
        displayer.DisplayWaste(sol.GetWaste());

        // Get and display current player
        String currPlayer = sol.GetCurrPlayer();
        System.out.println("Current Player: " + currPlayer);

        // Movements within the 7 piles
        char moveCards;
        System.out.println("Do you want to move cards within the piles of cards? (Y/N)");
        moveCards = input.next().charAt(0);
        int fromPile, toPile;
        while(moveCards == 'y' || moveCards == 'Y') {
                System.out.println("Move card from pile number: "); 
                fromPile = input.nextInt();
                input.nextLine(); // newline
                
                System.out.println("Move card to pile number: ");
                toPile = input.nextInt();
                input.nextLine(); //newline

                int boardMovement = sol.BoardCardMovement(fromPile-1, toPile-1);
                if (boardMovement == -1) {
                  System.out.println("ERROR: Invalid column numbers!");    
                }
                else if (boardMovement == 1) {
                  System.out.println("Card moved successfully");  
                }
                else {
                  System.out.println("ERROR: Invalid move!");
                }
               System.out.println("Do you want to continue move cards within the piles of cards? (Y/N)");
               moveCards = input.next().charAt(0);
            }
        

        System.out.println("Where do you want to place the stockpile card? (Column 1-7, 8 to move to waste)");
        int stockpileMove = input.nextInt();

        sol.StockpileCardMovement(stockpileMove);
        int stockpileToBoardMovement = sol.StockpileCardMovement(stockpileMove-1);
                if (stockpileToBoardMovement == -1) {
                  System.out.println("ERROR: Invalid column numbers!");    
                }
                else if (stockpileToBoardMovement == 1) {
                  System.out.println("Card moved successfully");  
                  sol.AddScore();
                }
                else {
                  System.out.println("ERROR: Invalid move!");
                }
                
        sol.SwitchPlayer();
    }
// Game is won
    String winner = sol.GetWinner();
    System.out.println("Congratulations " + winner + "! You've won the game!");

    input.close();
}
}
