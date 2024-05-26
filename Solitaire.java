import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Solitaire {
    public final static int DEFAULT_ROUND = 1; // The default round number 

    private Card[][] board; // Array to represent the game board
    private Card[][] waste; // Array to represent the waste pile
    private Card[] stockpile; // Array to represent the stockpile
    private Player[] allPlayers; // An array that stores all the player objects
    private int round; // Keeps track of the current round
    private int currCardPos; // Keeps track of the current card position
    private Card[] temp; // Array to store cards when they are first created
    private String currPlayer;

    //======================= CONSTRUCTOR =======================//
    // Initialize the game's instance variables. 
    public Solitaire() {
        currCardPos = 0;
        board = new Card[13][7];
        waste = new Card[13][4];
        stockpile = new Card[24];
        temp = new Card[52];
    }

    //====================== PRIVATE METHOD =======================//
    private boolean IsCardInPiles(int rank, int pattern) {
        Card[] piles;
        // Determine the index of the pile based on the suit
        switch (pattern) {
            case 0: // Diamonds
                piles = waste[0];
                break;
            case 1: // Hearts
                piles = waste[1];
                break;
            case 2: // Clubs
                piles = waste[2];
                break;
            case 3: // Spades
                piles = waste[3];
                break;
            default:
                return false; // Invalid suit
        }

        // Check if the card with the given rank is in the foundation pile
        for (Card card: piles) {
            if (card != null && card.GetNumber() == rank) {
                return true; // Card found in the foundation pile
            }
        }
        return false; // Card not found in the foundation pile
    }

    //====================== PUBLIC METHOD =======================//
    // Initializes the game
    public void InitializeGame(String player1, String player2) {
        allPlayers[0] = new Player(player1);
        allPlayers[1] = new Player(player2);
        
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 13; k++) {
                if (i == 0) {
                    temp[k] = new Diamonds(k + 1, "diamond", "red", " <3");
                } else if (i == 1) {
                    temp[k + 13] = new Hearts(k + 1, "heart", "red", -7);
                } else if (i == 2) {
                    temp[k + 26] = new Clubs(k + 1, "club", "black", 'z');
                } else if (i == 3) {
                    temp[k + 39] = new Spades(k + 1, "spade", "black", -7.0);
                }

            }
        }

        RandomizeStockpile();
        RandomizeBoard();
        // sets the last cards of each coloumn to facing up

        board[0][0].SetFacing();
        board[1][1].SetFacing();
        board[2][2].SetFacing();
        board[3][3].SetFacing();
        board[4][4].SetFacing();
        board[5][5].SetFacing();
        board[6][6].SetFacing();
    }


    // Randomizes the cards in the stockpile 
    public void RandomizeStockpile() {
        Random rand = new Random();
        int index;
        boolean[] used = new boolean[52];
        Arrays.fill(used, false);

        for (int i = 0; i < 24; i++) {
            do {
                index = rand.nextInt(52);
            } while (used[index]);

            used[index] = true;
            AddCardToStockpile(temp[index]);
        }
    }

    public void RandomizeBoard() {
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row <= col; row++) {
                for (int i = 0; i < 52; i++) {
                    if (temp[i] != null) {
                        board[row][col] = temp[i];
                        temp[i] = null;
                        break;
                    }
                }
            }
        }
    }

    // Flips the top card from the stockpile to the waste pile 
    public void StockpileToWaste() {
        if (stockpile[currCardPos] == null) {

        } else if (stockpile[currCardPos].GetNumber() == 1) {
            for (int k = 0; k < 4; k++) {
                if (waste[0][k] == null) {
                    waste[0][k] = stockpile[currCardPos];
                    RemoveCardFromStockpile(stockpile[currCardPos]);
                    break;
                }
            }
        }
    }

    /* Adds a card to the stockpile
     * @param card - The card to be added */
    public void AddCardToStockpile(Card card) {
        for (int i = 0; i < 24; i++) {
            if (stockpile[i] == null) {
                stockpile[i] = card;
                break;
            }
        }
    }

    /* Removes a card from the stockpile
     * @param card - The card to be removed */
    public void RemoveCardFromStockpile(Card card) {
        for (int i = 0; i < 24; i++) {
            if (card.GetPattern().equals(stockpile[i].GetPattern()) && card.GetNumber() == stockpile[i].GetNumber()) {
                stockpile[i] = null;
            }
        }
    }

    /* Get the current card from the stockpile
     * @return - The current card from the stockpile */
    public int GetCurrStockpilePos() {
        return currCardPos;
    }

    /* Moves a card from the store to the stockpile
     * @param card - The card to be moved
     * @return - The number of points gained */
    public int MoveCardFromStore(Card card) {
        return 0;
    }

    /* Checks if the game is won
     * @return - true if the game is won
               - false otherwise */
    public boolean CheckIfWon() {
        // check the 7 piles
        for (int suit = 0; suit < 4; suit++) {
            //  foundation pile has all cards from Ace to King?
            for (int rank = 1; rank <= 13; rank++) {
                if (!IsCardInPiles(rank, suit)) {
                    return false; // 
                }
            }
        }
        return true; // All cards are in the foundation piles
    }


    /* The movement of the card within the board
    * @return - -1 if the column number is invalid
              - 0 if the movement is not complete
              - 1 if the movement is complete */
   public int BoardCardMovement(int fromPile, int toPile) {
    // Check if the column numbers are valid
    if (fromPile < 0 || fromPile >= 7 || toPile < 0 || toPile >= 7) {
        System.out.println("Invalid column numbers.");
        return -1; // Invalid column numbers
    }
    
    // Check if there are cards in the source pile
    if (board[0][fromPile] == null) {
        System.out.println("Source pile is empty.");
        return -1; // Source pile is empty
    }
    
    // Check if the destination pile is empty or if the move is valid
    if (board[0][toPile] == null || board[0][toPile].CanMoveOnto(board[0][fromPile])) {
        // Move the card
        for (int row = 12; row >= 0; row--) {
            if (board[row][fromPile] != null) {
                board[row][toPile] = board[row][fromPile];
                board[row][fromPile] = null;
                return 1; // Movement successful
            }
        }
    } else {
        System.out.println("Invalid move.");
        return 0; // Invalid move
    }
    
    System.out.println("Unable to move the card.");
    return 0; // Unable to move the card
}
   

    /* The movement of the card from the stockpile
    * @return - -1 if the column number is invalid
              - 0 if the movement is not complete
              - 1 if the movement is complete */
   public int StockpileCardMovement(int toPile) {
    // Check if the column number is valid
    if (toPile < 0 || toPile >= 7) {
        System.out.println("Invalid column number.");
        return -1; // Invalid column number
    }
    
    // Check if the stockpile is empty
    if (stockpile[currCardPos] == null) {
        System.out.println("Stockpile is empty.");
        return -1; // Stockpile is empty
    }
    
    // Check if the destination pile is empty or if the move is valid
    if (board[0][toPile] == null || board[0][toPile].CanMoveOnto(stockpile[currCardPos])) {
        // Move the card from the stockpile to the board
        for (int row = 12; row >= 0; row--) {
            if (board[row][toPile] == null) {
                board[row][toPile] = stockpile[currCardPos];
                stockpile[currCardPos] = null;
                currCardPos++;
                return 1; // Movement successful
            }
        }
    } else {
        System.out.println("Invalid move.");
        return 0; // Invalid move
    }
    
    System.out.println("Unable to move the card.");
    return 0; // Unable to move the card
}



    /* Adds score to the game */
    public void AddScore() {

    }

    /* Switch player's turn to the next player (If current player is player 1, then it 
    * switches to player 2. If current player is player 2, then it switches to player 1) */   
    public void SwitchPlayer() {
    if (currPlayer == allPlayers[0]) {
    currPlayer = allPlayers[1];
} 
    else {
    currPlayer = allPlayers[0];
}
  }

    public Card[][] GetBoard() {
        return board;
    }
    public Card[][] GetWaste() {
        return waste;
    }
    public Card[] GetStockpile() {
        return stockpile;
    }
    public Player[] GetPlayers() {
        return allPlayers;
    }
    public int GetRound() {
        return round;
    }
    public int GetCurrRound() {
        return round;
    }

    public String GetCurrPlayer() {
        return("");
    }

}


