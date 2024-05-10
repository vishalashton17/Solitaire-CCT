// Developed by Vishal
public class Solitaire {
    public final static int DEFAULT_ROUND = 1;  // The default round number 

    private Card[] board;            // Array to represent the game board
    private Card[] waste;            // Array to represent the waste pile
    private Card[] stockpile;        // Array to represent the stockpile
    private Player[] allPlayers;     // An array that stores all the player objects
    private int round;               // Keeps track of the current round
    private int currCardPos;         // Keeps track of the current card position
  
    //======================= CONSTRUCTOR =======================//
    // Initialize the game's instance variables. 
    public Solitaire() {
      
    }

    //====================== PRIVATE METHOD =======================//

    
    
    //====================== PUBLIC METHOD =======================//
    // Randomizes the cards in the stockpile 
    public void RandomizeCards() {
        
    }
    
    // Flips the top card from the stockpile to the waste pile 
    public void FlipStockpile() {
      
    }
    
    /* Adds a card to the stockpile
     * @param card - The card to be added */
    public void AddCardToStockpile(Card card) {
      
    }
    
    /* Removes a card from the stockpile
     * @param card - The card to be removed */
    public void RemoveCardFromStockpile(Card card) {
      
    }
    
    /* Get the current card from the stockpile
     * @return - The current card from the stockpile */
    public Card GetCurrStockpileCard() {
      return null;   // Dummy return value
    }
    
    // Initializes the game
    public void InitializeGame() {
      
    }
    
    /* Moves a card from the store to the stockpile
     * @param card - The card to be moved
     * @return - The number of points gained */
    public int MoveCardFromStore(Card card) {
      return 0;   // Dummy return value
    }
    
    /* Checks if the game is won
     * @return - true if the game is won
               - false otherwise */
    public boolean CheckIfWon() {
      return false;   // Dummy return value
    }
    
    /* Adds score to the game */
    public void AddScore() {

    }

    }
  }
