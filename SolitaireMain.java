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
    private int currPlayer; // Keeps track of the current player array position

    //======================= CONSTRUCTOR =======================//
    // Initialize the game's instance variables. 
    public Solitaire() {
        currCardPos = 0;
        board = new Card[13][7];
        waste = new Card[13][4];
        stockpile = new Card[24];
        temp = new Card[52];
        allPlayers = new Player[2];
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


    // Developed by ANDY
    // Randomizes the cards in the stockpile 
    private void RandomizeStockpile() {
        // Shuffle the remaining cards in the temp array
        Random rand = new Random();
        int count = 0;
        boolean run = true;

        // Collect non-null cards
        Card[] remainingCards = new Card[28];
        while (run){
          for (int i = 0; i < 52; i++){
            if (temp[i] != null && count < 28) {
                remainingCards[count] = temp[i];
                count ++;
            }
            run = false;
          }
        }

        // Shuffle the remaining cards
        for (int i = remainingCards.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            Card tempCard = remainingCards[index];
            remainingCards[index] = remainingCards[i];
            remainingCards[i] = tempCard;
        }

        count = 0;
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row <= col; row++) {
                for (int i = 0; i < 52; i++) {
                    if (temp[i] != null) {
                        board[row][col] = temp[i];
                        temp[i] = null;
                        break;
                    }
                }
                board[row][col] = remainingCards[count++];
            }
        }

    }

    // Developed by ANDY
    // Randomises the remaining cards after running RandomizeStockpile and randomises them into the board
    private void RandomizeBoard() {
            // Shuffle the remaining cards in the temp array
            Random rand = new Random();
            int count = 0;
            boolean run = true;
    
            // Collect non-null cards
            Card[] remainingCards = new Card[28];
            while (run){
              for (int i = 0; i < 52; i++){
                if (temp[i] != null && count < 28) {
                  System.out.println(temp[i].GetNumber());
                    remainingCards[count] = temp[i];
                    count ++;
                }
                run = false;
              }
              System.out.println("done");
            }
    
            // Shuffle the remaining cards
            for (int i = remainingCards.length - 1; i > 0; i--) {
                int index = rand.nextInt(i + 1);
                Card tempCard = remainingCards[index];
                remainingCards[index] = remainingCards[i];
                remainingCards[i] = tempCard;
            }
    
            count = 0;
            for (int col = 0; col < 7; col++) {
                for (int row = 0; row <= col; row++) {
                    for (int i = 0; i < 52; i++) {
                        if (temp[i] != null) {
                            board[row][col] = temp[i];
                            temp[i] = null;
                            break;
                        }
                    }
                    board[row][col] = remainingCards[count++];
                }
            }
        }

    // Developed by ANDY
    /* Removes a card from the stockpile
     * @param card - The card to be removed */
    private void RemoveCardFromStockpile(Card card) {
        for (int i = 0; i < 24; i++) {
            if (stockpile[i] != null){
                if (card.GetPattern().equals(stockpile[i].GetPattern()) && card.GetNumber() == stockpile[i].GetNumber()) {
                    allPlayers[currPlayer].AddScore(stockpile[i].CalcScore());
                    stockpile[i] = null;
                    System.out.println("success");
                }
            }
        }
    }

    // Developed by ANDY
    // Checks if the current stockpile is empty and moves to the next card if it is
    private void CheckStockpile(){
        int pos = 0;
        for (int i = 0; i < 24; i++) {
            if (stockpile[currCardPos] != null){
                break;
            }
            else if (stockpile[pos] == null){
                currCardPos++;
                break;
            }
        }
    }


    //====================== PUBLIC METHOD =======================//


    // Developed by ANDY
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

    // Developed by VISHALL
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

    // Developed by ANDY
    /*  Moves the current stockpile card into the waste pile.
        @return - true if card is moved succesffuly
                - false if card is not moved */
    public boolean StockpileToWaste() {
        int count = 0;
        while (count < 25) {
            System.out.println(count);
            if (stockpile[currCardPos] == null ) {
                System.out.println("ended333333333333333 sadsadsadasddsa");
                System.out.println(count);
                CheckStockpile();
            } else if (stockpile[currCardPos].GetNumber() == 1) {
                System.out.println("ended sadsadsadasddsa");
                for (int k = 0; k < 4; k++) {
                    System.out.println("ended4444 sadsadsadasddsa");
                    if (waste[0][k] == null) {
                        System.out.println("ended 5555555sadsadsadasddsa");
                        waste[0][k] = stockpile[currCardPos];
                        System.out.println(waste[0][k].GetPattern());
                        RemoveCardFromStockpile(stockpile[currCardPos]);
                        CheckStockpile();
                        round ++;
                        return true;
                    }
                }
            }
            else if (stockpile[currCardPos].GetNumber() > 1 ) {
                for (int k = 0; k < 4; k++) {
                    for (int i = 1; i < 13; i++) {
                        if (waste[i][k] == null && waste[i-1][k] != null) {
                            System.out.println("ended 111111111sadsadsadasddsa");
                            if (stockpile[currCardPos].GetPattern() == waste[i-1][k].GetPattern()) {
                                System.out.println("ended 2222222sadsadsadasddsa");
                            waste[i][k] = stockpile[currCardPos];
                            RemoveCardFromStockpile(stockpile[currCardPos]);
                            CheckStockpile();
                            round ++;
                            return true;
                            }
                        }
                    }
                }
            }
            count ++;
            System.out.println(count);
        }
        System.out.println("ended StockpileToWaste");
        return false;
    }

    


    /* The movement of the card within the board
    * @return - -1 if the column number is invalid
              - 0 if the movement is not complete
              - 1 if the movement is complete 
              -2 if coloumn is invalid*/
   public int BoardCardMovement(int fromPile, int toPile) {
    // Check if the column numbers are valid
    if (fromPile < 0 || fromPile >= 7 || toPile < 0 || toPile >= 7) {
        return -2; // Invalid column numbers
    }
    
    // Check if there are cards in the source pile
    if (board[0][fromPile] == null) {
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
        return 0; // Invalid move
    }
    
    return 0; // Unable to move the card
}
   

    /* The movement of the card from the stockpile
    * @return -  -1 if the column number is invalid
                 -0 if the movement is not complete
                 -1 if the movement is complete 
                 -2 if Stockpile is empty */
   public int StockpileCardMovement(int toPile) {
    // Check if the column number is valid
    if (toPile < 0 || toPile >= 7) {
        return -1; // Invalid column number
    }
    
    // Check if the stockpile is empty
    if (stockpile[currCardPos] == null) {
        return -2; // Stockpile is empty
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
        return 0; // Invalid move
    }
    return 0; // Unable to move the card
}

    /* Switch player's turn to the next player (If current player is player 1, then it 
    * switches to player 2. If current player is player 2, then it switches to player 1) */   
    public void SwitchPlayer() {
    if (allPlayers[currPlayer] == allPlayers[0]) {
    currPlayer = 1;
    } 
    else {
    currPlayer = 0;
    }
  }

    // Developed by ANDY
    /* Get the current card from the stockpile
     * @return - The current card from the stockpile */
    public int GetCurrStockpilePos() {
        return currCardPos;
    }

    // Developed by ANDY
    /* Get the board 2d array
     * @return - The board 2d array */
    public Card[][] GetBoard() {
        return board;
    }

    // Developed by ANDY
    /* Get the waste 2d array
     * @return - The waste 2d array */
    public Card[][] GetWaste() {
        return waste;
    }

    // Developed by ANDY
    /* Get the stockpile array
     * @return - The stockpile array */
    public Card[] GetStockpile() {
        return stockpile;
    }

    // Developed by ANDY
    /* Get the array with all player data
     * @return - The allPlayer array */
    public Player[] GetPlayers() {
        return allPlayers;
    }

    // Developed by ANDY
    /* Get the current round
     * @return - The current card from the stockpile */
    public int GetRound() {
        return round;
    }

    // Developed by ANDY
    /* Get the current player
     * @return - The current player */
    public Player GetCurrPlayer() {
        return allPlayers[currPlayer];
    }

}


