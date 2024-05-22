// Developed by Vishal
public class Solitaire {
    public final static int DEFAULT_ROUND = 1;  // The default round number 

    private Card[][] board;            // Array to represent the game board
    private Card[][] waste;            // Array to represent the waste pile
    private Card[] stockpile;        // Array to represent the stockpile
    private Player[] allPlayers;     // An array that stores all the player objects
    private Player currPlayer;       // keeps track of the current player
    private int round;               // Keeps track of the current round
    private int currCardPos;         // Keeps track of the current card position
    private Card[] temp;        // Array to store cards when they are first created
    
  
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

    
    
    //====================== PUBLIC METHOD =======================//
    // Initializes the game
    public void InitializeGame() {
      for (int i = 0; i<4; i++){
        for (int k = 0; k<13; k++){
          if (k == 0){
            temp[i] = new Diamonds(k+1, "diamond", "red", "Shine bright like a diamond <3");
          }
          else if (i == 1){
            temp[i+13] = new Hearts(k+1, "heart", "red", -7);
          }
          else if (i == 2){
            temp[i+26] = new Clubs(k+1, "club", "black", 'z');
          }
          else if (i == 3){
            temp[i+39] = new Spades(k+1, "spade", "black", -7.0);
          }

        }
      }

      // temp way to fill stockpile and board, for testing
      for (int i = 0; i<24; i++){
        AddCardToStockpile(temp[i]);
        temp[i] = null;
      }
      int count = 24;
      for(int k = 0; k<13 ; k++){
        for (int i = 0; i<4; i++){
          if (count < 52) {
          board[i][k] = temp[(count)];
          count ++;
        }
      }
      }
    // end of temp
    }
    // Randomizes the cards in the stockpile 
    public void RandomizeCards() {
        
    }
    
    // Flips the top card from the stockpile to the waste pile 
    public void FlipStockpile() {
      if (stockpile[currCardPos] == null){

      }
      else if (stockpile[currCardPos].GetNumber() == 1){
        for (int k = 0; k<4; k++){
          if (waste[0][k] == null){
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
      for (int i = 0; i<24; i++){
        if (stockpile[i] == null){
          stockpile[i] = card;
          break;
        }
      }
    }
    
    /* Removes a card from the stockpile
     * @param card - The card to be removed */
    public void RemoveCardFromStockpile(Card card) {
      for (int i = 0; i<24; i++){
        if (card.GetPattern().equals(stockpile[i].GetPattern()) && card.GetNumber() == stockpile[i].GetNumber()){
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
      return false;
    }
    
    /* Adds score to the game */
    public void AddScore() {

    }
    public Card[][] GetBoard(){
      return board;
    }
    public Card[][] GetWaste(){
      return waste;
    }
    public Card[] GetStockpile(){
      return stockpile;
    }
    public Player[] GetPlayers(){
      return allPlayers;
    }
    public int GetRound(){
      return round;
    }
    public int GetCurr(){
      return round;
    }

    }
