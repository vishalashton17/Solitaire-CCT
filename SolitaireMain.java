// Developed by Vishal
import java.util.Scanner;

public class SolitaireMain {
public static void main(String[] args) {
    Player playerone, playertwo;
    int output;
    int stockpileMove = -1;
    boolean success;
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


    // main game and printing
    while(!sol.CheckIfWon()) {
        Player[] allPlayers = new Player[2];
        allPlayers = sol.GetPlayers();
        playerone = allPlayers[0];
        playertwo = allPlayers[1];
        // Display the initial game state
        displayer.ScoreBoard(playerone, playertwo ,sol.GetCurrPlayer());
        displayer.DisplayStockpile(sol.GetStockpile(), sol.GetCurrStockpilePos());
        displayer.DisplayWaste(sol.GetWaste());
        displayer.DisplayBoard(sol.GetBoard());
    
        // Get and display current player

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

                output = sol.BoardCardMovement(fromPile, toPile);
                if (output == 1){
                    System.out.println("Successfully moved card.");
                }
                else if (output == -1){
                    System.out.println("Source pile is empty.");
                }
                else if (output == -2){
                    System.out.println("Invalid column numbers.");
                }
                else if (output == 0){
                    System.out.println("Invalid move.");
                    System.out.println("Unable to move the card.");
                }
            } while(fromPile == 0);
        }
        else if (moveCards == 'n' || moveCards == 'N' ){
            System.out.println("Ending game");
            break;
        }
        else {
            System.out.println("Unsupported input");
        }
        if(moveCards == 'y' || moveCards == 'Y') {
        System.out.println("Where do you want to place the stockpile card? (Column 1-7, 8 to move to waste)");
        stockpileMove = input.nextInt();
        if (stockpileMove == 8) {
            success = sol.StockpileToWaste();
            System.out.println("Successfully moved card.");
            if (success) {
                System.out.println("Successfully moved card.");
                success = false;
            }
            else {
                System.out.println("Unable to move the card.");
            }

            sol.SwitchPlayer();
            }
        }
        else {
            output = sol.StockpileCardMovement(stockpileMove);
            if (output == 1){
                System.out.println("Successfully moved card.");
            }
            else if (output == -1){
                System.out.println("Invalid column number.");
            }
            else if (output == -2){
                System.out.println("Stockpile is empty.");
            }
            else if (output == 0){
                System.out.println("Unable to move the card.");
            }

            sol.SwitchPlayer();
            }
        }
// Game is won
    Player[] allPlayers = new Player[2];
    allPlayers = sol.GetPlayers();
    playerone = allPlayers[0];
    playertwo = allPlayers[1];
    if (playerone.GetScore() < playertwo.GetScore()){
        System.out.println("Congratulations " + playertwo.GetName() + "! You've won the game!");
    }
    else if (playerone.GetScore() > playertwo.GetScore()){
        System.out.println("Congratulations " + playerone.GetName() + "! You've won the game!");
    }
    else {
        System.out.println("Its a tie!");
    }

    input.close();
}
}
